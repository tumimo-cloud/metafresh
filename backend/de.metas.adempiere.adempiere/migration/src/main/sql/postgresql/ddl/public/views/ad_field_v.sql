-- NOTE: keep in sync with ad_field_vt

drop view if exists ad_field_v;
CREATE OR REPLACE VIEW ad_field_v AS 
SELECT
	t.ad_window_id
	, f.colorlogic
	, t.ad_tab_id
	, f.ad_field_id
	, tbl.ad_table_id
	, c.ad_column_id
    , c.ad_sequence_id AS Column_AD_Sequence_ID
	, COALESCE(f.name, c.name) AS name
	, COALESCE(f.description, c.description) AS description
	, COALESCE(f.help, t.help) AS help
	, f.isdisplayed
	, f.isdisplayedgrid
	, f.displaylogic
	, COALESCE(f.displaylength, 0::numeric) AS displaylength
	, f.columndisplaylength
	, f.seqno
	, f.seqnogrid
	, f.sortno
    , f.ad_sequence_id AS Field_AD_Sequence_ID
	, COALESCE(f.issameline, 'N'::bpchar) AS issameline
	, COALESCE(f.isheading, 'N'::bpchar) AS isheading
	, COALESCE(f.isfieldonly, 'N'::bpchar) AS isfieldonly
	, COALESCE(f.isreadonly, 'Y'::bpchar) AS isreadonly
	, COALESCE(f.isencrypted, c.isencrypted) AS isencryptedfield
	, f.obscuretype
	, c.columnname
	, c.columnsql
	, c.fieldlength
	, c.vformat
	, COALESCE(f.defaultvalue, c.defaultvalue) AS defaultvalue
	, c.iskey
	, c.isparent
	, COALESCE(f.ismandatory, c.ismandatory) AS ismandatory
	, c.IsMandatory as IsMandatoryDB
	, c.isidentifier
	, c.istranslated
	, COALESCE(f.ad_reference_value_id, c.ad_reference_value_id) AS ad_reference_value_id
	, c.callout
	, COALESCE(f.ad_reference_id, c.ad_reference_id) AS ad_reference_id
	, COALESCE(f.ad_val_rule_id, c.ad_val_rule_id) AS ad_val_rule_id
	, c.ad_process_id
	, c.isalwaysupdateable
	, c.readonlylogic
	, c.mandatorylogic
	, c.isupdateable
	, c.isencrypted AS isencryptedcolumn
	, tbl.tablename
	, c.valuemin
	, c.valuemax
	, fg.name AS fieldgroup
	, vr.code AS validationcode
	, f.included_tab_id
	, fg.fieldgrouptype
	, fg.iscollapsedbydefault
	, COALESCE(f.infofactoryclass, c.infofactoryclass) AS infofactoryclass
	, c.isautocomplete
	, f.includedtabheight
	, c.iscalculated
	, f.SpanX
	, f.SpanY
	, f.EntityType as FieldEntityType
	, c.FormatPattern
	, c.IsUseDocSequence
	--
	-- Filtering
	, c.IsSelectionColumn
	, c.SelectionColumnSeqNo
	, c.filteroperator
	, c.IsShowFilterIncrementButtons
    , c.IsShowFilterInline
	, c.FilterDefaultValue
	, c.IsFacetFilter
	, c.FacetFilterSeqNo
	, c.MaxFacetsToFetch
--
FROM ad_tab t
	JOIN ad_table tbl ON tbl.ad_table_id = t.ad_table_id
	JOIN ad_column c ON c.ad_table_id = t.ad_table_id
		LEFT JOIN ad_field f ON f.ad_tab_id = t.ad_tab_id AND f.ad_column_id = c.ad_column_id
			LEFT JOIN ad_fieldgroup fg ON fg.ad_fieldgroup_id = f.ad_fieldgroup_id
			LEFT JOIN ad_val_rule vr ON vr.ad_val_rule_id = COALESCE(f.ad_val_rule_id, c.ad_val_rule_id)
WHERE 
(f.isactive = 'Y' or f.AD_Field_ID is null)
AND c.isactive = 'Y'
;
