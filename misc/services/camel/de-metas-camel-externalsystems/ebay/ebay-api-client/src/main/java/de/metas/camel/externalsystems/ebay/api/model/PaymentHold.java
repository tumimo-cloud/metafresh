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
import de.metas.camel.externalsystems.ebay.api.model.Amount;
import de.metas.camel.externalsystems.ebay.api.model.SellerActionsToRelease;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This type contains information about a hold placed on a payment to a seller for an order, including the reason why the buyer&#39;s payment for the order is being held, the expected release date of the funds into the seller&#39;s account, the current state of the hold, and the actual release date if the payment has been released, and possible actions the seller can take to expedite the payout of
 * funds into their account.
 */
@ApiModel(description = "This type contains information about a hold placed on a payment to a seller for an order, including the reason why the buyer's payment for the order is being held, the expected release date of the funds into the seller's account, the current state of the hold, and the actual release date if the payment has been released, and possible actions the seller can take to expedite the payout of funds into their account.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-07-20T14:45:55.981728+02:00[Europe/Berlin]")
public class PaymentHold
{
	public static final String SERIALIZED_NAME_EXPECTED_RELEASE_DATE = "expectedReleaseDate";
	@SerializedName(SERIALIZED_NAME_EXPECTED_RELEASE_DATE)
	private String expectedReleaseDate;

	public static final String SERIALIZED_NAME_HOLD_AMOUNT = "holdAmount";
	@SerializedName(SERIALIZED_NAME_HOLD_AMOUNT)
	private Amount holdAmount;

	public static final String SERIALIZED_NAME_HOLD_REASON = "holdReason";
	@SerializedName(SERIALIZED_NAME_HOLD_REASON)
	private String holdReason;

	public static final String SERIALIZED_NAME_HOLD_STATE = "holdState";
	@SerializedName(SERIALIZED_NAME_HOLD_STATE)
	private String holdState;

	public static final String SERIALIZED_NAME_RELEASE_DATE = "releaseDate";
	@SerializedName(SERIALIZED_NAME_RELEASE_DATE)
	private String releaseDate;

	public static final String SERIALIZED_NAME_SELLER_ACTIONS_TO_RELEASE = "sellerActionsToRelease";
	@SerializedName(SERIALIZED_NAME_SELLER_ACTIONS_TO_RELEASE)
	private List<SellerActionsToRelease> sellerActionsToRelease = null;

	public PaymentHold expectedReleaseDate(String expectedReleaseDate)
	{

		this.expectedReleaseDate = expectedReleaseDate;
		return this;
	}

	/**
	 * The date and time that the payment being held is expected to be released to the seller. This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. This field will be returned if known by eBay. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z
	 * 
	 * @return expectedReleaseDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The date and time that the payment being held is expected to be released to the seller. This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. This field will be returned if known by eBay. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z")

	public String getExpectedReleaseDate()
	{
		return expectedReleaseDate;
	}

	public void setExpectedReleaseDate(String expectedReleaseDate)
	{
		this.expectedReleaseDate = expectedReleaseDate;
	}

	public PaymentHold holdAmount(Amount holdAmount)
	{

		this.holdAmount = holdAmount;
		return this;
	}

	/**
	 * Get holdAmount
	 * 
	 * @return holdAmount
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "")

	public Amount getHoldAmount()
	{
		return holdAmount;
	}

	public void setHoldAmount(Amount holdAmount)
	{
		this.holdAmount = holdAmount;
	}

	public PaymentHold holdReason(String holdReason)
	{

		this.holdReason = holdReason;
		return this;
	}

	/**
	 * The reason that the payment is being held. A seller&#39;s payment may be held for a number of reasons, including when the seller is new, the seller&#39;s level is below standard, or if a return case or &#39;Significantly not as described&#39; case is pending against the seller. This field is always returned with the paymentHolds array.
	 * 
	 * @return holdReason
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The reason that the payment is being held. A seller's payment may be held for a number of reasons, including when the seller is new, the seller's level is below standard, or if a return case or 'Significantly not as described' case is pending against the seller. This field is always returned with the paymentHolds array.")

	public String getHoldReason()
	{
		return holdReason;
	}

	public void setHoldReason(String holdReason)
	{
		this.holdReason = holdReason;
	}

	public PaymentHold holdState(String holdState)
	{

		this.holdState = holdState;
		return this;
	}

	/**
	 * The current stage or condition of the hold. This field is always returned with the paymentHolds array. Applicable values: HELD HELD_PENDING NOT_HELD RELEASE_CONFIRMED RELEASE_FAILED RELEASE_PENDING RELEASED
	 * 
	 * @return holdState
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The current stage or condition of the hold. This field is always returned with the paymentHolds array. Applicable values: HELD HELD_PENDING NOT_HELD RELEASE_CONFIRMED RELEASE_FAILED RELEASE_PENDING RELEASED")

	public String getHoldState()
	{
		return holdState;
	}

	public void setHoldState(String holdState)
	{
		this.holdState = holdState;
	}

	public PaymentHold releaseDate(String releaseDate)
	{

		this.releaseDate = releaseDate;
		return this;
	}

	/**
	 * The date and time that the payment being held was actually released to the seller. This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. This field is not returned until the seller&#39;s payment is actually released into the seller&#39;s account. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z
	 * 
	 * @return releaseDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "The date and time that the payment being held was actually released to the seller. This timestamp is in ISO 8601 format, which uses the 24-hour Universal Coordinated Time (UTC) clock. This field is not returned until the seller's payment is actually released into the seller's account. Format: [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].[sss]Z Example: 2015-08-04T19:09:02.768Z")

	public String getReleaseDate()
	{
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public PaymentHold sellerActionsToRelease(List<SellerActionsToRelease> sellerActionsToRelease)
	{

		this.sellerActionsToRelease = sellerActionsToRelease;
		return this;
	}

	public PaymentHold addSellerActionsToReleaseItem(SellerActionsToRelease sellerActionsToReleaseItem)
	{
		if (this.sellerActionsToRelease == null)
		{
			this.sellerActionsToRelease = new ArrayList<>();
		}
		this.sellerActionsToRelease.add(sellerActionsToReleaseItem);
		return this;
	}

	/**
	 * A list of one or more possible actions that the seller can take to expedite the release of the payment hold.
	 * 
	 * @return sellerActionsToRelease
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "A list of one or more possible actions that the seller can take to expedite the release of the payment hold.")

	public List<SellerActionsToRelease> getSellerActionsToRelease()
	{
		return sellerActionsToRelease;
	}

	public void setSellerActionsToRelease(List<SellerActionsToRelease> sellerActionsToRelease)
	{
		this.sellerActionsToRelease = sellerActionsToRelease;
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
		PaymentHold paymentHold = (PaymentHold)o;
		return Objects.equals(this.expectedReleaseDate, paymentHold.expectedReleaseDate) &&
				Objects.equals(this.holdAmount, paymentHold.holdAmount) &&
				Objects.equals(this.holdReason, paymentHold.holdReason) &&
				Objects.equals(this.holdState, paymentHold.holdState) &&
				Objects.equals(this.releaseDate, paymentHold.releaseDate) &&
				Objects.equals(this.sellerActionsToRelease, paymentHold.sellerActionsToRelease);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(expectedReleaseDate, holdAmount, holdReason, holdState, releaseDate, sellerActionsToRelease);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("class PaymentHold {\n");
		sb.append("    expectedReleaseDate: ").append(toIndentedString(expectedReleaseDate)).append("\n");
		sb.append("    holdAmount: ").append(toIndentedString(holdAmount)).append("\n");
		sb.append("    holdReason: ").append(toIndentedString(holdReason)).append("\n");
		sb.append("    holdState: ").append(toIndentedString(holdState)).append("\n");
		sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
		sb.append("    sellerActionsToRelease: ").append(toIndentedString(sellerActionsToRelease)).append("\n");
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
