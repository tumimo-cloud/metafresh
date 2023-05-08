DROP VIEW C_Invoice_LineTax_vt
;

CREATE OR REPLACE VIEW C_Invoice_LineTax_vt AS
SELECT il.ad_client_id,
       il.ad_org_id,
       il.isactive,
       il.created,
       il.createdby,
       il.updated,
       il.updatedby,
       uom.ad_language,
       il.c_invoice_id,
       il.c_invoiceline_id,
       il.c_tax_id,
       il.taxamt,
       il.linetotalamt,
       t.taxindicator,
       il.line,
       p.m_product_id,
       CASE
           WHEN il.qtyinvoiced <> 0::numeric OR il.m_product_id IS NOT NULL THEN il.qtyinvoiced
                                                                            ELSE NULL::numeric
       END                                                                                                                                                                             AS qtyinvoiced,
       CASE
           WHEN il.qtyentered <> 0::numeric OR il.m_product_id IS NOT NULL THEN il.qtyentered
                                                                           ELSE NULL::numeric
       END                                                                                                                                                                             AS qtyentered,
       CASE
           WHEN il.qtyentered <> 0::numeric OR il.m_product_id IS NOT NULL THEN uom.uomsymbol
                                                                           ELSE NULL::character varying
       END                                                                                                                                                                             AS uomsymbol,
       COALESCE(c.name, (COALESCE(pt.name, p.name)::text || COALESCE(productattribute(il.m_attributesetinstance_id), ''::character varying)::text)::character varying, il.description) AS name,
       CASE
           WHEN COALESCE(c.name, pt.name, p.name) IS NOT NULL THEN il.description
                                                              ELSE NULL::character varying
       END                                                                                                                                                                             AS description,
       COALESCE(pt.documentnote, p.documentnote)                                                                                                                                       AS documentnote,
       p.upc,
       p.sku,
       COALESCE(pp.vendorproductno, p.value)                                                                                                                                           AS productvalue,
       ra.description                                                                                                                                                                  AS resourcedescription,
       CASE
           WHEN i.isdiscountprinted = 'Y'::bpchar AND il.pricelist <> 0::numeric THEN il.pricelist
                                                                                 ELSE NULL::NUMERIC

       END                                                                                                                                                                             AS pricelist,
       CASE
           WHEN i.isdiscountprinted = 'Y'::bpchar AND il.pricelist <> 0::NUMERIC AND il.qtyentered <> 0::NUMERIC THEN il.pricelist * il.qtyinvoiced / il.qtyentered
                                                                                                                 ELSE NULL::NUMERIC

       END                                                                                                                                                                             AS priceenteredlist,
       CASE
           WHEN i.isdiscountprinted = 'Y'::bpchar AND il.pricelist > il.priceactual AND il.pricelist <> 0::NUMERIC THEN (il.pricelist - il.priceactual) / il.pricelist * 100::NUMERIC
                                                                                                                   ELSE NULL::NUMERIC

       END                                                                                                                                                                             AS discount,
       CASE
           WHEN il.priceactual <> 0::NUMERIC OR il.m_product_id IS NOT NULL THEN il.priceactual
                                                                            ELSE NULL::NUMERIC

       END                                                                                                                                                                             AS priceactual,
       CASE
           WHEN il.priceentered <> 0::NUMERIC OR il.m_product_id IS NOT NULL THEN il.priceentered
                                                                             ELSE NULL::NUMERIC

       END                                                                                                                                                                             AS priceentered,
       CASE
           WHEN il.linenetamt <> 0::NUMERIC OR il.m_product_id IS NOT NULL THEN il.linenetamt
                                                                           ELSE NULL::NUMERIC

       END                                                                                                                                                                             AS linenetamt,
       il.m_attributesetinstance_id,
       asi.m_attributeset_id,
       pt.description                                                                                                                                                                  AS productdescription,
       p.imageurl,
       il.c_campaign_id,
       il.c_project_id,
       il.c_activity_id,
       il.c_projectphase_id,
       il.c_projecttask_id
FROM c_invoiceline il
         JOIN c_uom_trl uom ON il.c_uom_id = uom.c_uom_id
         JOIN c_invoice i ON il.c_invoice_id = i.c_invoice_id
         LEFT JOIN c_tax_trl t ON il.c_tax_id = t.c_tax_id AND uom.ad_language::TEXT = t.ad_language::TEXT
         LEFT JOIN m_product p ON il.m_product_id = p.m_product_id
         LEFT JOIN c_charge_trl C ON il.c_charge_id = C.c_charge_id
         LEFT JOIN c_bpartner_product pp ON il.m_product_id = pp.m_product_id AND i.c_bpartner_id = pp.c_bpartner_id
         LEFT JOIN m_product_trl pt ON il.m_product_id = pt.m_product_id AND uom.ad_language::TEXT = pt.ad_language::TEXT
         LEFT JOIN s_resourceassignment ra ON il.s_resourceassignment_id = ra.s_resourceassignment_id
         LEFT JOIN m_attributesetinstance asi ON il.m_attributesetinstance_id = asi.m_attributesetinstance_id
UNION

SELECT il.ad_client_id,
       il.ad_org_id,
       il.isactive,
       il.created,
       il.createdby,
       il.updated,
       il.updatedby,
       uom.ad_language,
       il.c_invoice_id,
       il.c_invoiceline_id,
       il.c_tax_id,
       il.taxamt,
       il.linetotalamt,
       t.taxindicator,
       il.line + bl.line / 100::numeric          AS line,
       p.m_product_id,
       CASE
           WHEN bl.isqtypercentage = 'N'::bpchar THEN il.qtyinvoiced * bl.qtybom
                                                 ELSE il.qtyinvoiced * (bl.qtybatch / 100::numeric)
       END                                       AS qtyinvoiced,
       CASE
           WHEN bl.isqtypercentage = 'N'::bpchar THEN il.qtyentered * bl.qtybom
                                                 ELSE il.qtyentered * (bl.qtybatch / 100::numeric)
       END                                       AS qtyentered,
       uom.uomsymbol,
       COALESCE(pt.name, p.name)                 AS name,
       b.description,
       COALESCE(pt.documentnote, p.documentnote) AS documentnote,
       p.upc,
       p.sku,
       p.value                                   AS productvalue,
       NULL::character varying                   AS resourcedescription,
       NULL::numeric                             AS pricelist,
       NULL::numeric                             AS priceenteredlist,
       NULL::numeric                             AS discount,
       NULL::numeric                             AS priceactual,
       NULL::numeric                             AS priceentered,
       NULL::numeric                             AS linenetamt,
       il.m_attributesetinstance_id,
       asi.m_attributeset_id,
       pt.description                            AS productdescription,
       p.imageurl,
       il.c_campaign_id,
       il.c_project_id,
       il.c_activity_id,
       il.c_projectphase_id,
       il.c_projecttask_id
FROM pp_product_bom b
         JOIN c_invoiceline il ON b.m_product_id = il.m_product_id
         JOIN m_product bp ON bp.m_product_id = il.m_product_id AND bp.isbom = 'Y'::bpchar AND bp.isverified = 'Y'::bpchar AND bp.isinvoiceprintdetails = 'Y'::bpchar
         JOIN pp_product_bomline bl
              ON bl.pp_product_bom_id = b.pp_product_bom_id
         JOIN m_product p ON bl.m_product_id = p.m_product_id
         JOIN c_uom_trl uom ON p.c_uom_id = uom.c_uom_id
         JOIN m_product_trl pt ON bl.m_product_id = pt.m_product_id AND uom.ad_language::TEXT = pt.ad_language::TEXT
         LEFT JOIN c_tax t ON il.c_tax_id = t.c_tax_id
         LEFT JOIN m_attributesetinstance asi ON il.m_attributesetinstance_id = asi.m_attributesetinstance_id
UNION

SELECT il.ad_client_id,
       il.ad_org_id,
       il.isactive,
       il.created,
       il.createdby,
       il.updated,
       il.updatedby,
       l.ad_language,
       il.c_invoice_id,
       il.c_invoiceline_id,
       NULL::numeric           AS c_tax_id,
       NULL::numeric           AS taxamt,
       NULL::numeric           AS linetotalamt,
       NULL::character varying AS taxindicator,
       il.line,
       NULL::numeric           AS m_product_id,
       NULL::numeric           AS qtyinvoiced,
       NULL::numeric           AS qtyentered,
       NULL::character varying AS uomsymbol,
       il.description          AS name,
       NULL::character varying AS description,
       NULL::character varying AS documentnote,
       NULL::character varying AS upc,
       NULL::character varying AS sku,
       NULL::character varying AS productvalue,
       NULL::character varying AS resourcedescription,
       NULL::numeric           AS pricelist,
       NULL::numeric           AS priceenteredlist,
       NULL::numeric           AS discount,
       NULL::numeric           AS priceactual,
       NULL::numeric           AS priceentered,
       NULL::numeric           AS linenetamt,
       NULL::numeric           AS m_attributesetinstance_id,
       NULL::numeric           AS m_attributeset_id,
       NULL::character varying AS productdescription,
       NULL::character varying AS imageurl,
       NULL::numeric           AS c_campaign_id,
       NULL::numeric           AS c_project_id,
       NULL::numeric           AS c_activity_id,
       NULL::numeric           AS c_projectphase_id,
       NULL::numeric           AS c_projecttask_id
FROM c_invoiceline il,
     ad_language l
WHERE il.c_uom_id IS NULL
  AND l.isbaselanguage = 'N'::bpchar
  AND l.issystemlanguage = 'Y'::bpchar
UNION

SELECT i.ad_client_id,
       i.ad_org_id,
       i.isactive,
       i.created,
       i.createdby,
       i.updated,
       i.updatedby,
       l.ad_language,
       i.c_invoice_id,
       NULL::numeric           AS c_invoiceline_id,
       NULL::numeric           AS c_tax_id,
       NULL::numeric           AS taxamt,
       NULL::numeric           AS linetotalamt,
       NULL::character varying AS taxindicator,
       9998                    AS line,
       NULL::numeric           AS m_product_id,
       NULL::numeric           AS qtyinvoiced,
       NULL::numeric           AS qtyentered,
       NULL::character varying AS uomsymbol,
       NULL::character varying AS name,
       NULL::character varying AS description,
       NULL::character varying AS documentnote,
       NULL::character varying AS upc,
       NULL::character varying AS sku,
       NULL::character varying AS productvalue,
       NULL::character varying AS resourcedescription,
       NULL::numeric           AS pricelist,
       NULL::numeric           AS priceenteredlist,
       NULL::numeric           AS discount,
       NULL::numeric           AS priceactual,
       NULL::numeric           AS priceentered,
       NULL::numeric           AS linenetamt,
       NULL::numeric           AS m_attributesetinstance_id,
       NULL::numeric           AS m_attributeset_id,
       NULL::character varying AS productdescription,
       NULL::character varying AS imageurl,
       NULL::numeric           AS c_campaign_id,
       NULL::numeric           AS c_project_id,
       NULL::numeric           AS c_activity_id,
       NULL::numeric           AS c_projectphase_id,
       NULL::numeric           AS c_projecttask_id
FROM c_invoice i,
     ad_language l
WHERE l.isbaselanguage = 'N'::bpchar
  AND l.issystemlanguage = 'Y'::bpchar
UNION

SELECT it.ad_client_id,
       it.ad_org_id,
       it.isactive,
       it.created,
       it.createdby,
       it.updated,
       it.updatedby,
       t.ad_language,
       it.c_invoice_id,
       NULL::numeric           AS c_invoiceline_id,
       it.c_tax_id,
       NULL::numeric           AS taxamt,
       NULL::numeric           AS linetotalamt,
       t.taxindicator,
       9999                    AS line,
       NULL::numeric           AS m_product_id,
       NULL::numeric           AS qtyinvoiced,
       NULL::numeric           AS qtyentered,
       NULL::character varying AS uomsymbol,
       t.name,
       NULL::character varying AS description,
       NULL::character varying AS documentnote,
       NULL::character varying AS upc,
       NULL::character varying AS sku,
       NULL::character varying AS productvalue,
       NULL::character varying AS resourcedescription,
       NULL::numeric           AS pricelist,
       NULL::numeric           AS priceenteredlist,
       NULL::numeric           AS discount,
       CASE
           WHEN it.istaxincluded = 'Y'::bpchar THEN it.taxamt
                                               ELSE it.taxbaseamt
       END                     AS priceactual,
       CASE
           WHEN it.istaxincluded = 'Y'::bpchar THEN it.taxamt
                                               ELSE it.taxbaseamt
       END                     AS priceentered,
       CASE
           WHEN it.istaxincluded = 'Y'::bpchar THEN NULL::numeric
                                               ELSE it.taxamt
       END                     AS linenetamt,
       NULL::numeric           AS m_attributesetinstance_id,
       NULL::numeric           AS m_attributeset_id,
       NULL::character varying AS productdescription,
       NULL::character varying AS imageurl,
       NULL::numeric           AS c_campaign_id,
       NULL::numeric           AS c_project_id,
       NULL::numeric           AS c_activity_id,
       NULL::numeric           AS c_projectphase_id,
       NULL::numeric           AS c_projecttask_id
FROM c_invoicetax it
         JOIN c_tax_trl t ON it.c_tax_id = t.c_tax_id
;