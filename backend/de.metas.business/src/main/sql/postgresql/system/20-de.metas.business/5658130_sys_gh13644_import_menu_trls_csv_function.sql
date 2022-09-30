DO
$$
    BEGIN
        UPDATE ad_element_trl
        SET name                    = data.name_trl
          , printname               = data.name_trl
          , description             = data.description_trl
          , webui_namenew           = data.webui_namenew_trl
          , webui_namebrowse        = data.webui_namebrowse_trl
          , webui_namenewbreadcrumb = data.webui_namenewbreadcrumb_trl
        FROM migration_data."AD_Menu_Trad" data
                 INNER JOIN ad_menu m ON data.ad_menu_id = m.ad_menu_id
        WHERE ad_element_trl.ad_element_id = m.ad_element_id
          AND ad_language IN ('fr_CH', 'fr_FR');

        PERFORM update_trl_tables_on_ad_element_trl_update(NULL, NULL);
    END;
$$
;
