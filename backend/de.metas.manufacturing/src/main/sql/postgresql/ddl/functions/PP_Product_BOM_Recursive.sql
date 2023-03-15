<<<<<<< HEAD
drop function if exists PP_Product_BOM_Recursive(numeric, varchar);
create or replace function PP_Product_BOM_Recursive(p_PP_Product_BOM_ID numeric, p_ad_language varchar)
returns table
(
	Line text,
	Parent_Line text,
	ProductValue varchar,
	ProductName varchar,
	QtyBOM numeric,
	Percentage numeric,
	UOMSymbol varchar,
	--
	depth integer,
	M_Product_ID numeric,
	IsQtyPercentage char(1),
	C_UOM_ID numeric,
    path integer[]
)
as
$BODY$
--
	with recursive bomNode as (
		(
			select
				array[1::integer] as path,
				null::integer[] as parent_path,
				1 as depth,
				bomProduct.Value as ProductValue,
				coalesce(pt.Name, bomProduct.Name) as ProductName,
				bomProduct.M_Product_ID,
				bomProduct.IsBOM,
				bom.PP_Product_BOM_ID,
				'N'::char(1) as IsQtyPercentage,
				round(1::numeric, uom.StdPrecision) as QtyBOM,
				null::numeric as Percentage,
				COALESCE(uom.UOMSymbol, uomt.UOMSymbol) as UOMSymbol,
				uom.C_UOM_ID
			from PP_Product_BOM bom
			inner join M_Product bomProduct on bomProduct.M_Product_ID=bom.M_Product_ID
			LEFT OUTER JOIN M_Product_Trl pt    ON bomProduct.M_Product_ID = pt.M_Product_ID AND pt.AD_Language =p_ad_language
       AND pt.isActive = 'Y'
			left outer join C_UOM uom on uom.C_UOM_ID=coalesce(bom.C_UOM_ID, bomProduct.C_UOM_ID)
			LEFT OUTER JOIN C_UOM_Trl uomt ON uom.C_UOM_ID = uomt.C_UOM_ID AND uomt.IsActive='Y' and uomt.AD_Language = p_ad_language
			where
			bom.PP_Product_BOM_ID=PP_Product_BOM_Recursive.p_PP_Product_BOM_ID
		)
		--
		union all
		--
		(
			select
				parent.path || (row_number() over (partition by bomLine.PP_Product_BOM_ID order by bomLine.PP_Product_BOMLine_ID))::integer as path,
				parent.path as parent_path,
				parent.depth + 1 as depth,
				bomLineProduct.Value as ProductValue,
				coalesce(pt.Name, bomLineProduct.Name) as ProductName,
				bomLineProduct.M_Product_ID,
				bomLineProduct.IsBOM,
				(case when bomLineProduct.IsBOM='Y'
					then (select bom.PP_Product_BOM_ID from PP_Product_BOM bom
						where bom.M_Product_ID=bomLineProduct.M_Product_ID
						and bom.IsActive='Y'
						and bom.Value=bomLineProduct.Value
                        AND (bom.validto >= NOW() OR bom.validto IS NULL)
                        ORDER BY bom.validfrom DESC, bom.PP_Product_BOM_ID DESC
						limit 1)
					else null
					end)::numeric(10,0) as PP_Product_BOM_ID,
				bomLine.IsQtyPercentage,
				(case when bomLine.IsQtyPercentage='N' then round(bomLine.QtyBOM, uom.StdPrecision) else null end) as QtyBOM,
				(case when bomLine.IsQtyPercentage='Y' then round(bomLine.QtyBatch, 2) else null end) as Percentage,
				COALESCE(uom.UOMSymbol, uomt.UOMSymbol) as UOMSymbol,
				uom.C_UOM_ID
			from bomNode parent
			inner join PP_Product_BOMLine bomLine on bomLine.PP_Product_BOM_ID=parent.PP_Product_BOM_ID
			inner join M_Product bomLineProduct on bomLineProduct.M_Product_ID = bomLine.M_Product_ID
			LEFT OUTER JOIN M_Product_Trl pt    ON bomLineProduct.M_Product_ID = pt.M_Product_ID AND pt.AD_Language =p_ad_language
       AND pt.isActive = 'Y'
			left outer join C_UOM uom on uom.C_UOM_ID=bomLine.C_UOM_ID
			LEFT OUTER JOIN C_UOM_Trl uomt ON bomLine.C_UOM_ID = uomt.C_UOM_ID AND uomt.IsActive='Y' and uomt.AD_Language = p_ad_language
			where bomLine.IsActive='Y'
			order by bomLine.PP_Product_BOMLine_ID
		)
	)
	--
	select
		array_to_string(n.path, '.')||'.' as Line,
		array_to_string(n.parent_path, '.')||'.' as Parent_Line,
		n.ProductValue,
		n.ProductName,
		n.QtyBOM,
		n.Percentage,
		n.UOMSymbol,
		--
		n.depth,
		n.M_Product_ID,
		n.IsQtyPercentage,
		n.C_UOM_ID,
        n.path
	from bomNode n
	order by path
	;
$BODY$
LANGUAGE sql STABLE
COST 100;
=======
DROP FUNCTION IF EXISTS PP_Product_BOM_Recursive(numeric,
                                                 varchar)
;
>>>>>>> 1fbf8175f4f (Stücklistenexport nach Excel - Reihenfolge der Zeilen wird ignoriert und Lieferant mit ausgeben (#14827))

CREATE OR REPLACE FUNCTION pp_product_bom_recursive(p_pp_product_bom_id numeric,
                                                    p_ad_language       character varying)
    RETURNS TABLE
            (
                line            text,
                parent_line     text,
                productvalue    character varying,
                productname     character varying,
                qtybom          numeric,
                percentage      numeric,
                uomsymbol       character varying,
                depth           integer,
                m_product_id    numeric,
                isqtypercentage character,
                c_uom_id        numeric,
                path            integer[],
                supplier        text
            )
    STABLE
    LANGUAGE sql
AS
$$
    --
WITH RECURSIVE bomNode AS ((SELECT ARRAY [1::integer]                      AS path,
                                   NULL::integer[]                         AS parent_path,
                                   1                                       AS depth,
                                   bomProduct.Value                        AS ProductValue,
                                   COALESCE(pt.Name, bomProduct.Name)      AS ProductName,
                                   bomProduct.M_Product_ID,
                                   bomProduct.IsBOM,
                                   bom.PP_Product_BOM_ID,
                                   'N'::char(1)                            AS IsQtyPercentage,
                                   ROUND(1::numeric, uom.StdPrecision)     AS QtyBOM,
                                   NULL::numeric                           AS Percentage,
                                   COALESCE(uom.UOMSymbol, uomt.UOMSymbol) AS UOMSymbol,
                                   uom.C_UOM_ID,
                                   (SELECT bPartner.value
                                    FROM C_BPartner_Product bPartnerProduct
                                             INNER JOIN C_BPartner bPartner ON bPartnerProduct.c_bpartner_id = bPartner.c_bpartner_id
                                    WHERE bomProduct.m_product_id = bPartnerProduct.m_product_id
                                      AND bPartnerProduct.iscurrentvendor = 'Y'
                                      AND bPartnerProduct.isActive = 'Y'
                                      AND bPartnerProduct.usedforvendor = 'Y'
                                   )                                       AS Supplier
                            FROM PP_Product_BOM bom
                                     INNER JOIN M_Product bomProduct ON bomProduct.M_Product_ID = bom.M_Product_ID
                                     LEFT OUTER JOIN M_Product_Trl pt ON bomProduct.M_Product_ID = pt.M_Product_ID AND pt.AD_Language = p_ad_language
                                AND pt.isActive = 'Y'
                                     LEFT OUTER JOIN C_UOM uom ON uom.C_UOM_ID = COALESCE(bom.C_UOM_ID, bomProduct.C_UOM_ID)
                                     LEFT OUTER JOIN C_UOM_Trl uomt ON uom.C_UOM_ID = uomt.C_UOM_ID AND uomt.IsActive = 'Y' AND uomt.AD_Language = p_ad_language
                            WHERE bom.PP_Product_BOM_ID = PP_Product_BOM_Recursive.p_PP_Product_BOM_ID)
                           --
                           UNION ALL
                           --
                           (SELECT parent.path || (ROW_NUMBER() OVER (PARTITION BY bomLine.PP_Product_BOM_ID ORDER BY bomLine.line, bomLine.PP_Product_BOMLine_ID))::integer AS path,
                                   parent.path                                                                                                                               AS parent_path,
                                   parent.depth + 1                                                                                                                          AS depth,
                                   bomLineProduct.Value                                                                                                                      AS ProductValue,
                                   COALESCE(pt.Name, bomLineProduct.Name)                                                                                                    AS ProductName,
                                   bomLineProduct.M_Product_ID,
                                   bomLineProduct.IsBOM,
                                   (CASE
                                        WHEN bomLineProduct.IsBOM = 'Y'
                                            THEN (SELECT bom.PP_Product_BOM_ID
                                                  FROM PP_Product_BOM bom
                                                  WHERE bom.M_Product_ID = bomLineProduct.M_Product_ID
                                                    AND bom.IsActive = 'Y'
                                                    AND bom.Value = bomLineProduct.Value
                                                  ORDER BY bom.PP_Product_BOM_ID
                                                  LIMIT 1)
                                            ELSE NULL
                                    END)::numeric(10, 0)                                                                                                                     AS PP_Product_BOM_ID,
                                   bomLine.IsQtyPercentage,
                                   (CASE WHEN bomLine.IsQtyPercentage = 'N' THEN ROUND(bomLine.QtyBOM, uom.StdPrecision) ELSE NULL END)                                      AS QtyBOM,
                                   (CASE WHEN bomLine.IsQtyPercentage = 'Y' THEN ROUND(bomLine.QtyBatch, 2) ELSE NULL END)                                                   AS Percentage,
                                   COALESCE(uom.UOMSymbol, uomt.UOMSymbol)                                                                                                   AS UOMSymbol,
                                   uom.C_UOM_ID,
                                   (SELECT bPartner.value
                                    FROM C_BPartner_Product bPartnerProduct
                                             INNER JOIN C_BPartner bPartner ON bPartnerProduct.c_bpartner_id = bPartner.c_bpartner_id
                                    WHERE bomLine.m_product_id = bPartnerProduct.m_product_id
                                      AND bPartnerProduct.iscurrentvendor = 'Y'
                                      AND bPartnerProduct.isActive = 'Y'
                                      AND bPartnerProduct.usedforvendor = 'Y'
                                   )                                                                                                                                         AS Supplier
                            FROM bomNode parent
                                     INNER JOIN PP_Product_BOMLine bomLine ON bomLine.PP_Product_BOM_ID = parent.PP_Product_BOM_ID
                                     INNER JOIN M_Product bomLineProduct ON bomLineProduct.M_Product_ID = bomLine.M_Product_ID
                                     LEFT OUTER JOIN M_Product_Trl pt ON bomLineProduct.M_Product_ID = pt.M_Product_ID AND pt.AD_Language = p_ad_language
                                AND pt.isActive = 'Y'
                                     LEFT OUTER JOIN C_UOM uom ON uom.C_UOM_ID = bomLine.C_UOM_ID
                                     LEFT OUTER JOIN C_UOM_Trl uomt ON bomLine.C_UOM_ID = uomt.C_UOM_ID AND uomt.IsActive = 'Y' AND uomt.AD_Language = p_ad_language
                            WHERE bomLine.IsActive = 'Y'
                            ORDER BY bomLine.PP_Product_BOMLine_ID))
               --
SELECT ARRAY_TO_STRING(n.path, '.') || '.'        AS Line,
       ARRAY_TO_STRING(n.parent_path, '.') || '.' AS Parent_Line,
       n.ProductValue,
       n.ProductName,
       n.QtyBOM,
       n.Percentage,
       n.UOMSymbol,
       --
       n.depth,
       n.M_Product_ID,
       n.IsQtyPercentage,
       n.C_UOM_ID,
       n.path,
       n.Supplier
FROM bomNode n
ORDER BY path
    ;
$$
;

ALTER FUNCTION pp_product_bom_recursive(numeric, varchar) OWNER TO metasfresh
;