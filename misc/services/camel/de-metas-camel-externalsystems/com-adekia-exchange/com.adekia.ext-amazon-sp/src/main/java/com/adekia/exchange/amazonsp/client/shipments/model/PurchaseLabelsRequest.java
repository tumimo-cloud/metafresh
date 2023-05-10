/*
 * Selling Partner API for Shipping
 * Provides programmatic access to Amazon Shipping APIs.
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.adekia.exchange.amazonsp.client.shipments.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * The request schema for the purchaseLabels operation.
 */
@Schema(description = "The request schema for the purchaseLabels operation.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-12T14:28:53.571+02:00")
public class PurchaseLabelsRequest {
  @SerializedName("rateId")
  private String rateId = null;

  @SerializedName("labelSpecification")
  private LabelSpecification labelSpecification = null;

  public PurchaseLabelsRequest rateId(String rateId) {
    this.rateId = rateId;
    return this;
  }

   /**
   * Get rateId
   * @return rateId
  **/
  @Schema(required = true, description = "")
  public String getRateId() {
    return rateId;
  }

  public void setRateId(String rateId) {
    this.rateId = rateId;
  }

  public PurchaseLabelsRequest labelSpecification(LabelSpecification labelSpecification) {
    this.labelSpecification = labelSpecification;
    return this;
  }

   /**
   * Get labelSpecification
   * @return labelSpecification
  **/
  @Schema(required = true, description = "")
  public LabelSpecification getLabelSpecification() {
    return labelSpecification;
  }

  public void setLabelSpecification(LabelSpecification labelSpecification) {
    this.labelSpecification = labelSpecification;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchaseLabelsRequest purchaseLabelsRequest = (PurchaseLabelsRequest) o;
    return Objects.equals(this.rateId, purchaseLabelsRequest.rateId) &&
        Objects.equals(this.labelSpecification, purchaseLabelsRequest.labelSpecification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rateId, labelSpecification);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PurchaseLabelsRequest {\n");
    
    sb.append("    rateId: ").append(toIndentedString(rateId)).append("\n");
    sb.append("    labelSpecification: ").append(toIndentedString(labelSpecification)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

