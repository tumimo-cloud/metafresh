DROP FUNCTION IF EXISTS update_Tab_Translation_From_AD_Element(p_AD_Element_ID numeric,
                                                               p_AD_Language character varying)
;


CREATE OR REPLACE FUNCTION update_Tab_Translation_From_AD_Element(p_AD_Element_ID numeric = NULL,
                                                                  p_AD_Language character varying = NULL)
    RETURNS void
AS
$BODY$
DECLARE
    update_count integer;
BEGIN

    UPDATE AD_Tab_Trl t_trl
    SET IsTranslated  = e_trl.IsTranslated,
        Name          = e_trl.Name,
        Description   = e_trl.Description,
        Help          = e_trl.Help,
        CommitWarning = e_trl.CommitWarning,
        Updated       = e_trl.updated

    FROM AD_Element_Trl_Effective_v e_trl
    WHERE (p_AD_Element_ID IS NULL OR e_trl.AD_Element_ID = p_AD_Element_ID)
      AND (p_AD_Language IS NULL OR e_trl.AD_Language = p_AD_Language)
      AND t_trl.ad_language = e_trl.ad_language
      AND EXISTS(SELECT 1 FROM AD_Tab t WHERE t.ad_element_id = e_trl.ad_element_id AND t.ad_tab_id = t_trl.ad_tab_id)
      AND t_trl.updated <> e_trl.updated;

    GET DIAGNOSTICS update_count = ROW_COUNT;
    RAISE NOTICE 'Update % AD_Tab_Trl rows using AD_Element_ID=%, AD_Language=%', update_count, p_AD_Element_ID, p_AD_Language;

    IF (p_AD_Language IS NULL OR isBaseAD_Language(p_AD_Language) = 'Y') THEN
        UPDATE AD_Tab t
        SET Name          = e_trl.Name,
            Description   = e_trl.Description,
            Help          = e_trl.Help,
            CommitWarning = e_trl.CommitWarning,
            Updated       = e_trl.updated

        FROM AD_Element_Trl_Effective_v e_trl
        WHERE (p_AD_Element_ID IS NULL OR e_trl.AD_Element_ID = p_AD_Element_ID)
          AND (p_AD_Language IS NULL OR e_trl.AD_Language = p_AD_Language)
          AND t.ad_element_id = e_trl.ad_element_id
          AND isbasead_language(e_trl.ad_language) = 'Y'
          AND t.updated <> e_trl.updated;
        --
        GET DIAGNOSTICS update_count = ROW_COUNT;
        RAISE NOTICE 'Update % AD_Tab rows using AD_Element_ID=%, AD_Language=%', update_count, p_AD_Element_ID, p_AD_Language;
    END IF;

END;
$BODY$
    LANGUAGE plpgsql
    VOLATILE
    SECURITY DEFINER
    COST 100
;

COMMENT ON FUNCTION update_Tab_Translation_From_AD_Element(numeric, character varying) IS
    'When the AD_Tab.AD_Element_ID is changed, update all the AD_Tab_Trl entries of the AD_Tab, based on the AD_Element.'
;
