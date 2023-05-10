
-- 2022-08-17T06:43:16.564Z
UPDATE AD_Process SET Classname='de.metas.serviceprovider.github.process.RegisterIssuesWebhookProcess',Updated=TO_TIMESTAMP('2022-08-17 09:43:16','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_ID=585089
;

-- 2022-08-17T06:44:36.323Z
INSERT INTO AD_Process (AccessLevel,AD_Client_ID,AD_Org_ID,AD_Process_ID,AllowProcessReRun,Classname,CopyFromProcess,Created,CreatedBy,EntityType,IsActive,IsApplySecuritySettings,IsBetaFunctionality,IsDirectPrint,IsFormatExcelFile,IsLogWarning,IsNotifyUserAfterExecution,IsOneInstanceOnly,IsReport,IsTranslateExcelHeaders,IsUpdateExportDate,IsUseBPartnerLanguage,LockWaitTimeout,Name,PostgrestResponseFormat,RefreshAllAfterExecution,ShowHelp,SpreadsheetFormat,Type,Updated,UpdatedBy,Value) VALUES ('3',0,0,585096,'Y','de.metas.serviceprovider.github.process.CreateEffortIssueProcess','N',TO_TIMESTAMP('2022-08-17 09:44:36','YYYY-MM-DD HH24:MI:SS'),100,'de.metas.serviceprovider','Y','N','N','N','Y','N','N','N','N','Y','N','Y',0,'Create effort Issue','json','N','N','xls','Java',TO_TIMESTAMP('2022-08-17 09:44:36','YYYY-MM-DD HH24:MI:SS'),100,'CreateEffortIssueProcess')
;

-- 2022-08-17T06:44:36.331Z
INSERT INTO AD_Process_Trl (AD_Language,AD_Process_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy,IsActive) SELECT l.AD_Language, t.AD_Process_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy,'Y' FROM AD_Language l, AD_Process t WHERE l.IsActive='Y'AND (l.IsSystemLanguage='Y') AND t.AD_Process_ID=585096 AND NOT EXISTS (SELECT 1 FROM AD_Process_Trl tt WHERE tt.AD_Language=l.AD_Language AND tt.AD_Process_ID=t.AD_Process_ID)
;

-- 2022-08-17T06:44:47.979Z
UPDATE AD_Process_Trl SET Name='Aufwand-Issue erstellen',Updated=TO_TIMESTAMP('2022-08-17 09:44:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Language='de_CH' AND AD_Process_ID=585096
;

-- 2022-08-17T06:44:51.448Z
UPDATE AD_Process_Trl SET Name='Aufwand-Issue erstellen',Updated=TO_TIMESTAMP('2022-08-17 09:44:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Language='fr_CH' AND AD_Process_ID=585096
;

-- 2022-08-17T06:44:59.366Z
UPDATE AD_Process_Trl SET Name='Aufwand-Issue erstellen',Updated=TO_TIMESTAMP('2022-08-17 09:44:59','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Language='nl_NL' AND AD_Process_ID=585096
;

-- 2022-08-17T06:45:02.481Z
UPDATE AD_Process SET Description=NULL, Help=NULL, Name='Aufwand-Issue erstellen',Updated=TO_TIMESTAMP('2022-08-17 09:45:02','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_ID=585096
;

-- 2022-08-17T06:45:02.474Z
UPDATE AD_Process_Trl SET Name='Aufwand-Issue erstellen',Updated=TO_TIMESTAMP('2022-08-17 09:45:02','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Language='de_DE' AND AD_Process_ID=585096
;

-- 2022-08-17T07:03:20.019Z
INSERT INTO AD_Table_Process (AD_Client_ID,AD_Org_ID,AD_Process_ID,AD_Table_ID,AD_Table_Process_ID,AD_Window_ID,Created,CreatedBy,EntityType,IsActive,Updated,UpdatedBy,WEBUI_DocumentAction,WEBUI_IncludedTabTopAction,WEBUI_ViewAction,WEBUI_ViewQuickAction,WEBUI_ViewQuickAction_Default) VALUES (0,0,585096,541468,541140,540859,TO_TIMESTAMP('2022-08-17 10:03:19','YYYY-MM-DD HH24:MI:SS'),100,'de.metas.serviceprovider','Y',TO_TIMESTAMP('2022-08-17 10:03:19','YYYY-MM-DD HH24:MI:SS'),100,'Y','N','Y','N','N')
;
