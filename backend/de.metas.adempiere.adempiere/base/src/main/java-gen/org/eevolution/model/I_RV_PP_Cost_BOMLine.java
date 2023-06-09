package org.eevolution.model;

import java.math.BigDecimal;
import javax.annotation.Nullable;
import org.adempiere.model.ModelColumn;

/** Generated Interface for RV_PP_Cost_BOMLine
 *  @author metasfresh (generated) 
 */
@SuppressWarnings("unused")
public interface I_RV_PP_Cost_BOMLine 
{

	String Table_Name = "RV_PP_Cost_BOMLine";

//	/** AD_Table_ID=53161 */
//	int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);


	/**
	 * Get Client.
	 * Client/Tenant for this installation.
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getAD_Client_ID();

	String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/**
	 * Set Organisation.
	 * Organisational entity within client
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setAD_Org_ID (int AD_Org_ID);

	/**
	 * Get Organisation.
	 * Organisational entity within client
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getAD_Org_ID();

	String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Set Process Instance.
	 * Instance of a Process
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setAD_PInstance_ID (int AD_PInstance_ID);

	/**
	 * Get Process Instance.
	 * Instance of a Process
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getAD_PInstance_ID();

	@Nullable org.compiere.model.I_AD_PInstance getAD_PInstance();

	void setAD_PInstance(@Nullable org.compiere.model.I_AD_PInstance AD_PInstance);

	ModelColumn<I_RV_PP_Cost_BOMLine, org.compiere.model.I_AD_PInstance> COLUMN_AD_PInstance_ID = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "AD_PInstance_ID", org.compiere.model.I_AD_PInstance.class);
	String COLUMNNAME_AD_PInstance_ID = "AD_PInstance_ID";

	/**
	 * Set Accounting Schema.
	 * Rules for accounting
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setC_AcctSchema_ID (int C_AcctSchema_ID);

	/**
	 * Get Accounting Schema.
	 * Rules for accounting
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getC_AcctSchema_ID();

	@Nullable org.compiere.model.I_C_AcctSchema getC_AcctSchema();

	void setC_AcctSchema(@Nullable org.compiere.model.I_C_AcctSchema C_AcctSchema);

	ModelColumn<I_RV_PP_Cost_BOMLine, org.compiere.model.I_C_AcctSchema> COLUMN_C_AcctSchema_ID = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "C_AcctSchema_ID", org.compiere.model.I_C_AcctSchema.class);
	String COLUMNNAME_C_AcctSchema_ID = "C_AcctSchema_ID";

	/**
	 * Set UOM.
	 * Unit of Measure
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setC_UOM_ID (int C_UOM_ID);

	/**
	 * Get UOM.
	 * Unit of Measure
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getC_UOM_ID();

	String COLUMNNAME_C_UOM_ID = "C_UOM_ID";

	/**
	 * Set Component Type.
	 * Component Type for a Bill of Material or Formula
	 *
	 * <br>Type: List
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setComponentType (@Nullable java.lang.String ComponentType);

	/**
	 * Get Component Type.
	 * Component Type for a Bill of Material or Formula
	 *
	 * <br>Type: List
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.lang.String getComponentType();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_ComponentType = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "ComponentType", null);
	String COLUMNNAME_ComponentType = "ComponentType";

	/**
	 * Set Kosten.
	 * Cost information
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setCost (@Nullable BigDecimal Cost);

	/**
	 * Get Kosten.
	 * Cost information
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getCost();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_Cost = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "Cost", null);
	String COLUMNNAME_Cost = "Cost";

	/**
	 * Set Kostenrechnungsmethode.
	 * Indicates how Costs will be calculated
	 *
	 * <br>Type: List
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setCostingMethod (@Nullable java.lang.String CostingMethod);

	/**
	 * Get Kostenrechnungsmethode.
	 * Indicates how Costs will be calculated
	 *
	 * <br>Type: List
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.lang.String getCostingMethod();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_CostingMethod = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "CostingMethod", null);
	String COLUMNNAME_CostingMethod = "CostingMethod";

	/**
	 * Set Standardkosten.
	 * Standard Costs
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setCostStandard (@Nullable BigDecimal CostStandard);

	/**
	 * Get Standardkosten.
	 * Standard Costs
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getCostStandard();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_CostStandard = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "CostStandard", null);
	String COLUMNNAME_CostStandard = "CostStandard";

	/**
	 * Get Created.
	 * Date this record was created
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.sql.Timestamp getCreated();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_Created = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "Created", null);
	String COLUMNNAME_Created = "Created";

	/**
	 * Get Created By.
	 * User who created this records
	 *
	 * <br>Type: Table
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getCreatedBy();

	String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Set Gegenwärtiger Kostenpreis.
	 * Der gegenwärtig verwendete Kostenpreis
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setCurrentCostPrice (@Nullable BigDecimal CurrentCostPrice);

	/**
	 * Get Gegenwärtiger Kostenpreis.
	 * Der gegenwärtig verwendete Kostenpreis
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getCurrentCostPrice();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_CurrentCostPrice = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "CurrentCostPrice", null);
	String COLUMNNAME_CurrentCostPrice = "CurrentCostPrice";

	/**
	 * Set Current Cost Price Lower Level.
	 * Current Price Lower Level Is the sum of the costs of the components of this product manufactured for this level.
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setCurrentCostPriceLL (@Nullable BigDecimal CurrentCostPriceLL);

	/**
	 * Get Current Cost Price Lower Level.
	 * Current Price Lower Level Is the sum of the costs of the components of this product manufactured for this level.
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getCurrentCostPriceLL();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_CurrentCostPriceLL = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "CurrentCostPriceLL", null);
	String COLUMNNAME_CurrentCostPriceLL = "CurrentCostPriceLL";

	/**
	 * Set Description.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setDescription (@Nullable java.lang.String Description);

	/**
	 * Get Description.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.lang.String getDescription();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_Description = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "Description", null);
	String COLUMNNAME_Description = "Description";

	/**
	 * Set Zukünftiger Kostenpreis.
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setFutureCostPrice (@Nullable BigDecimal FutureCostPrice);

	/**
	 * Get Zukünftiger Kostenpreis.
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getFutureCostPrice();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_FutureCostPrice = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "FutureCostPrice", null);
	String COLUMNNAME_FutureCostPrice = "FutureCostPrice";

	/**
	 * Set Future Cost Price Lower Level.
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setFutureCostPriceLL (@Nullable BigDecimal FutureCostPriceLL);

	/**
	 * Get Future Cost Price Lower Level.
	 *
	 * <br>Type: CostPrice
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getFutureCostPriceLL();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_FutureCostPriceLL = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "FutureCostPriceLL", null);
	String COLUMNNAME_FutureCostPriceLL = "FutureCostPriceLL";

	/**
	 * Set Implosion.
	 * Implosion of a Bill of Materials refers to finding all the BOM''s in which a component is used.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setImplosion (boolean Implosion);

	/**
	 * Get Implosion.
	 * Implosion of a Bill of Materials refers to finding all the BOM''s in which a component is used.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	boolean isImplosion();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_Implosion = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "Implosion", null);
	String COLUMNNAME_Implosion = "Implosion";

	/**
	 * Set Active.
	 * The record is active in the system
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setIsActive (boolean IsActive);

	/**
	 * Get Active.
	 * The record is active in the system
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	boolean isActive();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_IsActive = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "IsActive", null);
	String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Set Cost Frozen.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setIsCostFrozen (boolean IsCostFrozen);

	/**
	 * Get Cost Frozen.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	boolean isCostFrozen();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_IsCostFrozen = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "IsCostFrozen", null);
	String COLUMNNAME_IsCostFrozen = "IsCostFrozen";

	/**
	 * Set Is Critical Component.
	 * Indicate that a Manufacturing Order can not begin without have this component
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setIsCritical (boolean IsCritical);

	/**
	 * Get Is Critical Component.
	 * Indicate that a Manufacturing Order can not begin without have this component
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	boolean isCritical();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_IsCritical = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "IsCritical", null);
	String COLUMNNAME_IsCritical = "IsCritical";

	/**
	 * Set Is Qty Percentage.
	 * Indicate that this component is based in % Quantity
	 *
	 * <br>Type: Quantity
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setIsQtyPercentage (@Nullable BigDecimal IsQtyPercentage);

	/**
	 * Get Is Qty Percentage.
	 * Indicate that this component is based in % Quantity
	 *
	 * <br>Type: Quantity
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getIsQtyPercentage();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_IsQtyPercentage = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "IsQtyPercentage", null);
	String COLUMNNAME_IsQtyPercentage = "IsQtyPercentage";

	/**
	 * Set Issue Method.
	 * There are two methods for issue the components to Manufacturing Order
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setIssueMethod (boolean IssueMethod);

	/**
	 * Get Issue Method.
	 * There are two methods for issue the components to Manufacturing Order
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	boolean issueMethod();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_IssueMethod = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "IssueMethod", null);
	String COLUMNNAME_IssueMethod = "IssueMethod";

	/**
	 * Set Level no.
	 *
	 * <br>Type: Integer
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setLevelNo (int LevelNo);

	/**
	 * Get Level no.
	 *
	 * <br>Type: Integer
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getLevelNo();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_LevelNo = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "LevelNo", null);
	String COLUMNNAME_LevelNo = "LevelNo";

	/**
	 * Set Levels.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setLevels (@Nullable java.lang.String Levels);

	/**
	 * Get Levels.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.lang.String getLevels();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_Levels = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "Levels", null);
	String COLUMNNAME_Levels = "Levels";

	/**
	 * Set SeqNo..
	 *
	 * <br>Type: Integer
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setLine (int Line);

	/**
	 * Get SeqNo..
	 *
	 * <br>Type: Integer
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getLine();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_Line = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "Line", null);
	String COLUMNNAME_Line = "Line";

	/**
	 * Set Attributes.
	 * Attribute Instances for Products
	 *
	 * <br>Type: PAttribute
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setM_AttributeSetInstance_ID (int M_AttributeSetInstance_ID);

	/**
	 * Get Attributes.
	 * Attribute Instances for Products
	 *
	 * <br>Type: PAttribute
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getM_AttributeSetInstance_ID();

	@Nullable org.compiere.model.I_M_AttributeSetInstance getM_AttributeSetInstance();

	void setM_AttributeSetInstance(@Nullable org.compiere.model.I_M_AttributeSetInstance M_AttributeSetInstance);

	ModelColumn<I_RV_PP_Cost_BOMLine, org.compiere.model.I_M_AttributeSetInstance> COLUMN_M_AttributeSetInstance_ID = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "M_AttributeSetInstance_ID", org.compiere.model.I_M_AttributeSetInstance.class);
	String COLUMNNAME_M_AttributeSetInstance_ID = "M_AttributeSetInstance_ID";

	/**
	 * Set Kostenart.
	 * Product Cost Element
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setM_CostElement_ID (int M_CostElement_ID);

	/**
	 * Get Kostenart.
	 * Product Cost Element
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getM_CostElement_ID();

	@Nullable org.compiere.model.I_M_CostElement getM_CostElement();

	void setM_CostElement(@Nullable org.compiere.model.I_M_CostElement M_CostElement);

	ModelColumn<I_RV_PP_Cost_BOMLine, org.compiere.model.I_M_CostElement> COLUMN_M_CostElement_ID = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "M_CostElement_ID", org.compiere.model.I_M_CostElement.class);
	String COLUMNNAME_M_CostElement_ID = "M_CostElement_ID";

	/**
	 * Set Kostenkategorie.
	 * Type of Cost (e.g. Current, Plan, Future)
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setM_CostType_ID (int M_CostType_ID);

	/**
	 * Get Kostenkategorie.
	 * Type of Cost (e.g. Current, Plan, Future)
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getM_CostType_ID();

	@Nullable org.compiere.model.I_M_CostType getM_CostType();

	void setM_CostType(@Nullable org.compiere.model.I_M_CostType M_CostType);

	ModelColumn<I_RV_PP_Cost_BOMLine, org.compiere.model.I_M_CostType> COLUMN_M_CostType_ID = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "M_CostType_ID", org.compiere.model.I_M_CostType.class);
	String COLUMNNAME_M_CostType_ID = "M_CostType_ID";

	/**
	 * Set Product.
	 * Product, Service, Item
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setM_Product_ID (int M_Product_ID);

	/**
	 * Get Product.
	 * Product, Service, Item
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getM_Product_ID();

	String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/**
	 * Set BOM & Formula Version.
	 * BOM & Formula
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setPP_Product_BOM_ID (int PP_Product_BOM_ID);

	/**
	 * Get BOM & Formula Version.
	 * BOM & Formula
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getPP_Product_BOM_ID();

	@Nullable org.eevolution.model.I_PP_Product_BOM getPP_Product_BOM();

	void setPP_Product_BOM(@Nullable org.eevolution.model.I_PP_Product_BOM PP_Product_BOM);

	ModelColumn<I_RV_PP_Cost_BOMLine, org.eevolution.model.I_PP_Product_BOM> COLUMN_PP_Product_BOM_ID = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "PP_Product_BOM_ID", org.eevolution.model.I_PP_Product_BOM.class);
	String COLUMNNAME_PP_Product_BOM_ID = "PP_Product_BOM_ID";

	/**
	 * Set BOM Line.
	 * BOM Line
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setPP_Product_BOMLine_ID (int PP_Product_BOMLine_ID);

	/**
	 * Get BOM Line.
	 * BOM Line
	 *
	 * <br>Type: TableDir
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getPP_Product_BOMLine_ID();

	@Nullable org.eevolution.model.I_PP_Product_BOMLine getPP_Product_BOMLine();

	void setPP_Product_BOMLine(@Nullable org.eevolution.model.I_PP_Product_BOMLine PP_Product_BOMLine);

	ModelColumn<I_RV_PP_Cost_BOMLine, org.eevolution.model.I_PP_Product_BOMLine> COLUMN_PP_Product_BOMLine_ID = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "PP_Product_BOMLine_ID", org.eevolution.model.I_PP_Product_BOMLine.class);
	String COLUMNNAME_PP_Product_BOMLine_ID = "PP_Product_BOMLine_ID";

	/**
	 * Set Quantity.
	 * Indicate the Quantity  use in this BOM
	 *
	 * <br>Type: Quantity
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setQtyBOM (@Nullable BigDecimal QtyBOM);

	/**
	 * Get Quantity.
	 * Indicate the Quantity  use in this BOM
	 *
	 * <br>Type: Quantity
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getQtyBOM();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_QtyBOM = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "QtyBOM", null);
	String COLUMNNAME_QtyBOM = "QtyBOM";

	/**
	 * Set % Scrap.
	 * Indicate the % Scrap  for calculate the Scrap Quantity
	 *
	 * <br>Type: Number
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setScrap (@Nullable BigDecimal Scrap);

	/**
	 * Get % Scrap.
	 * Indicate the % Scrap  for calculate the Scrap Quantity
	 *
	 * <br>Type: Number
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	BigDecimal getScrap();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_Scrap = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "Scrap", null);
	String COLUMNNAME_Scrap = "Scrap";

	/**
	 * Set SeqNo.
	 * Method of ordering records;
 lowest number comes first
	 *
	 * <br>Type: Integer
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setSeqNo (int SeqNo);

	/**
	 * Get SeqNo.
	 * Method of ordering records;
 lowest number comes first
	 *
	 * <br>Type: Integer
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getSeqNo();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_SeqNo = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "SeqNo", null);
	String COLUMNNAME_SeqNo = "SeqNo";

	/**
	 * Set Product.
	 *
	 * <br>Type: Table
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setTM_Product_ID (int TM_Product_ID);

	/**
	 * Get Product.
	 *
	 * <br>Type: Table
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getTM_Product_ID();

	String COLUMNNAME_TM_Product_ID = "TM_Product_ID";

	/**
	 * Get Updated.
	 * Date this record was updated
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.sql.Timestamp getUpdated();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_Updated = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "Updated", null);
	String COLUMNNAME_Updated = "Updated";

	/**
	 * Get Updated By.
	 * User who updated this records
	 *
	 * <br>Type: Table
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getUpdatedBy();

	String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/**
	 * Set Valid From.
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setValidFrom (@Nullable java.sql.Timestamp ValidFrom);

	/**
	 * Get Valid From.
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.sql.Timestamp getValidFrom();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_ValidFrom = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "ValidFrom", null);
	String COLUMNNAME_ValidFrom = "ValidFrom";

	/**
	 * Set Valid to.
	 * Valid to including this date (last day)
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setValidTo (@Nullable java.sql.Timestamp ValidTo);

	/**
	 * Get Valid to.
	 * Valid to including this date (last day)
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.sql.Timestamp getValidTo();

	ModelColumn<I_RV_PP_Cost_BOMLine, Object> COLUMN_ValidTo = new ModelColumn<>(I_RV_PP_Cost_BOMLine.class, "ValidTo", null);
	String COLUMNNAME_ValidTo = "ValidTo";
}
