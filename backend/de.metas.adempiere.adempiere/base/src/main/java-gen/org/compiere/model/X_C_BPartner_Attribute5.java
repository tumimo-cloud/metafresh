// Generated Model - DO NOT CHANGE
package org.compiere.model;

import java.sql.ResultSet;
import java.util.Properties;
import javax.annotation.Nullable;

/** Generated Model for C_BPartner_Attribute5
 *  @author metasfresh (generated) 
 */
@SuppressWarnings("unused")
public class X_C_BPartner_Attribute5 extends org.compiere.model.PO implements I_C_BPartner_Attribute5, org.compiere.model.I_Persistent 
{

	private static final long serialVersionUID = -1180528785L;

    /** Standard Constructor */
    public X_C_BPartner_Attribute5 (final Properties ctx, final int C_BPartner_Attribute5_ID, @Nullable final String trxName)
    {
      super (ctx, C_BPartner_Attribute5_ID, trxName);
    }

    /** Load Constructor */
    public X_C_BPartner_Attribute5 (final Properties ctx, final ResultSet rs, @Nullable final String trxName)
    {
      super (ctx, rs, trxName);
    }


	/** Load Meta Data */
	@Override
	protected org.compiere.model.POInfo initPO(final Properties ctx)
	{
		return org.compiere.model.POInfo.getPOInfo(Table_Name);
	}

	/** 
	 * Attributes5 AD_Reference_ID=541336
	 * Reference name: Attributes5
	 */
	public static final int ATTRIBUTES5_AD_Reference_ID=541336;
	@Override
	public void setAttributes5 (final java.lang.String Attributes5)
	{
		set_Value (COLUMNNAME_Attributes5, Attributes5);
	}

	@Override
	public java.lang.String getAttributes5() 
	{
		return get_ValueAsString(COLUMNNAME_Attributes5);
	}

	@Override
	public void setC_BPartner_Attribute5_ID (final int C_BPartner_Attribute5_ID)
	{
		if (C_BPartner_Attribute5_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_Attribute5_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_Attribute5_ID, C_BPartner_Attribute5_ID);
	}

	@Override
	public int getC_BPartner_Attribute5_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_C_BPartner_Attribute5_ID);
	}

	@Override
	public void setC_BPartner_ID (final int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, C_BPartner_ID);
	}

	@Override
	public int getC_BPartner_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_C_BPartner_ID);
	}
}