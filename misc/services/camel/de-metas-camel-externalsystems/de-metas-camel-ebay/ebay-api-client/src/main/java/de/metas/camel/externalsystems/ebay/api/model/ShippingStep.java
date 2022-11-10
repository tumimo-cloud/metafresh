/*
 * Fulfillment API
 * Use the Fulfillment API to complete the process of packaging, addressing, handling, and shipping each order on behalf of the seller, in accordance with the payment method and timing specified at checkout.
 *
 * The version of the OpenAPI document: v1.19.7
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package de.metas.camel.externalsystems.ebay.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.metas.camel.externalsystems.ebay.api.model.ExtendedContact;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * This type contains shipping information for a fulfillment, including the shipping carrier, the shipping service option, the shipment destination, and the Global Shipping Program reference ID.
 */
@ApiModel(description = "This type contains shipping information for a fulfillment, including the shipping carrier, the shipping service option, the shipment destination, and the Global Shipping Program reference ID.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class ShippingStep
{
	public static final String SERIALIZED_NAME_SHIPPING_CARRIER_CODE = "shippingCarrierCode";
	@SerializedName(SERIALIZED_NAME_SHIPPING_CARRIER_CODE)
	private String shippingCarrierCode;

	public static final String SERIALIZED_NAME_SHIPPING_SERVICE_CODE = "shippingServiceCode";
	@SerializedName(SERIALIZED_NAME_SHIPPING_SERVICE_CODE)
	private String shippingServiceCode;

	public static final String SERIALIZED_NAME_SHIP_TO = "shipTo";
	@SerializedName(SERIALIZED_NAME_SHIP_TO)
	private ExtendedContact shipTo;

	public static final String SERIALIZED_NAME_SHIP_TO_REFERENCE_ID = "shipToReferenceId";
	@SerializedName(SERIALIZED_NAME_SHIP_TO_REFERENCE_ID)
	private String shipToReferenceId;

	public ShippingStep shippingCarrierCode(String shippingCarrierCode)
	{

		this.shippingCarrierCode = shippingCarrierCode;
		return this;
	}

	/**
	 * The unique identifier of the shipping carrier being used to ship the line item. Note: The Trading API&#39;s GeteBayDetails call can be used to retrieve the latest shipping carrier and shipping service option enumeration values.
	 * 
	 * @return shippingCarrierCode
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The unique identifier of the shipping carrier being used to ship the line item. Note: The Trading API's GeteBayDetails call can be used to retrieve the latest shipping carrier and shipping service option enumeration values.")

	public String getShippingCarrierCode()
	{
		return shippingCarrierCode;
	}

	public void setShippingCarrierCode(String shippingCarrierCode)
	{
		this.shippingCarrierCode = shippingCarrierCode;
	}

	public ShippingStep shippingServiceCode(String shippingServiceCode)
	{

		this.shippingServiceCode = shippingServiceCode;
		return this;
	}

	/**
	 * The unique identifier of the shipping service option being used to ship the line item. Note: Use the Trading API&#39;s GeteBayDetails call to retrieve the latest shipping carrier and shipping service option enumeration values. When making the GeteBayDetails call, include the DetailName field in the request payload and set its value to ShippingServiceDetails. Each valid shipping service
	 * option (returned in ShippingServiceDetails.ShippingService field) and corresponding shipping carrier (returned in ShippingServiceDetails.ShippingCarrier field) is returned in response payload.
	 * 
	 * @return shippingServiceCode
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The unique identifier of the shipping service option being used to ship the line item. Note: Use the Trading API's GeteBayDetails call to retrieve the latest shipping carrier and shipping service option enumeration values. When making the GeteBayDetails call, include the DetailName field in the request payload and set its value to ShippingServiceDetails. Each valid shipping service option (returned in ShippingServiceDetails.ShippingService field) and corresponding shipping carrier (returned in ShippingServiceDetails.ShippingCarrier field) is returned in response payload.")

	public String getShippingServiceCode()
	{
		return shippingServiceCode;
	}

	public void setShippingServiceCode(String shippingServiceCode)
	{
		this.shippingServiceCode = shippingServiceCode;
	}

	public ShippingStep shipTo(ExtendedContact shipTo)
	{

		this.shipTo = shipTo;
		return this;
	}

	/**
	 * Get shipTo
	 * 
	 * @return shipTo
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public ExtendedContact getShipTo()
	{
		return shipTo;
	}

	public void setShipTo(ExtendedContact shipTo)
	{
		this.shipTo = shipTo;
	}

	public ShippingStep shipToReferenceId(String shipToReferenceId)
	{

		this.shipToReferenceId = shipToReferenceId;
		return this;
	}

	/**
	 * This is the unique identifer of the Global Shipping Program (GSP) shipment. This field is only returned if the line item is being shipped via GSP (the value of the fulfillmentStartInstructions.ebaySupportedFulfillment field will be true. The international shipping provider uses the shipToReferenceId value as the primary reference number to retrieve the relevant details about the buyer, the
	 * order, and the fulfillment, so the shipment can be completed. Sellers must include this value on the shipping label immediately above the street address of the international shipping provider. Example: &amp;quot;Reference #1234567890123456&amp;quot; Note: This value is the same as the ShipToAddress.ReferenceID value returned by the Trading API&#39;s GetOrders call.
	 * 
	 * @return shipToReferenceId
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "This is the unique identifer of the Global Shipping Program (GSP) shipment. This field is only returned if the line item is being shipped via GSP (the value of the fulfillmentStartInstructions.ebaySupportedFulfillment field will be true. The international shipping provider uses the shipToReferenceId value as the primary reference number to retrieve the relevant details about the buyer, the order, and the fulfillment, so the shipment can be completed. Sellers must include this value on the shipping label immediately above the street address of the international shipping provider. Example: &quot;Reference #1234567890123456&quot; Note: This value is the same as the ShipToAddress.ReferenceID value returned by the Trading API's GetOrders call.")

	public String getShipToReferenceId()
	{
		return shipToReferenceId;
	}

	public void setShipToReferenceId(String shipToReferenceId)
	{
		this.shipToReferenceId = shipToReferenceId;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		ShippingStep shippingStep = (ShippingStep)o;
		return Objects.equals(this.shippingCarrierCode, shippingStep.shippingCarrierCode) &&
				Objects.equals(this.shippingServiceCode, shippingStep.shippingServiceCode) &&
				Objects.equals(this.shipTo, shippingStep.shipTo) &&
				Objects.equals(this.shipToReferenceId, shippingStep.shipToReferenceId);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(shippingCarrierCode, shippingServiceCode, shipTo, shipToReferenceId);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class ShippingStep {\n");
		sb.append("    shippingCarrierCode: ").append(toIndentedString(shippingCarrierCode)).append("\n");
		sb.append("    shippingServiceCode: ").append(toIndentedString(shippingServiceCode)).append("\n");
		sb.append("    shipTo: ").append(toIndentedString(shipTo)).append("\n");
		sb.append("    shipToReferenceId: ").append(toIndentedString(shipToReferenceId)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o)
	{
		if (o == null)
		{
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
