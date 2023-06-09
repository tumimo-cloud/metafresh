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
 * The payload schema for the purchaseLabels operation.
 */
@Schema(description = "The payload schema for the purchaseLabels operation.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-12T14:28:53.571+02:00")
public class PurchaseLabelsResult {
  @SerializedName("shipmentId")
  private String shipmentId = null;

  @SerializedName("clientReferenceId")
  private String clientReferenceId = null;

  @SerializedName("acceptedRate")
  private AcceptedRate acceptedRate = null;

  @SerializedName("labelResults")
  private LabelResultList labelResults = null;

  public PurchaseLabelsResult shipmentId(String shipmentId) {
    this.shipmentId = shipmentId;
    return this;
  }

   /**
   * Get shipmentId
   * @return shipmentId
  **/
  @Schema(required = true, description = "")
  public String getShipmentId() {
    return shipmentId;
  }

  public void setShipmentId(String shipmentId) {
    this.shipmentId = shipmentId;
  }

  public PurchaseLabelsResult clientReferenceId(String clientReferenceId) {
    this.clientReferenceId = clientReferenceId;
    return this;
  }

   /**
   * Get clientReferenceId
   * @return clientReferenceId
  **/
  @Schema(description = "")
  public String getClientReferenceId() {
    return clientReferenceId;
  }

  public void setClientReferenceId(String clientReferenceId) {
    this.clientReferenceId = clientReferenceId;
  }

  public PurchaseLabelsResult acceptedRate(AcceptedRate acceptedRate) {
    this.acceptedRate = acceptedRate;
    return this;
  }

   /**
   * Get acceptedRate
   * @return acceptedRate
  **/
  @Schema(required = true, description = "")
  public AcceptedRate getAcceptedRate() {
    return acceptedRate;
  }

  public void setAcceptedRate(AcceptedRate acceptedRate) {
    this.acceptedRate = acceptedRate;
  }

  public PurchaseLabelsResult labelResults(LabelResultList labelResults) {
    this.labelResults = labelResults;
    return this;
  }

   /**
   * Get labelResults
   * @return labelResults
  **/
  @Schema(required = true, description = "")
  public LabelResultList getLabelResults() {
    return labelResults;
  }

  public void setLabelResults(LabelResultList labelResults) {
    this.labelResults = labelResults;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchaseLabelsResult purchaseLabelsResult = (PurchaseLabelsResult) o;
    return Objects.equals(this.shipmentId, purchaseLabelsResult.shipmentId) &&
        Objects.equals(this.clientReferenceId, purchaseLabelsResult.clientReferenceId) &&
        Objects.equals(this.acceptedRate, purchaseLabelsResult.acceptedRate) &&
        Objects.equals(this.labelResults, purchaseLabelsResult.labelResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shipmentId, clientReferenceId, acceptedRate, labelResults);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PurchaseLabelsResult {\n");
    
    sb.append("    shipmentId: ").append(toIndentedString(shipmentId)).append("\n");
    sb.append("    clientReferenceId: ").append(toIndentedString(clientReferenceId)).append("\n");
    sb.append("    acceptedRate: ").append(toIndentedString(acceptedRate)).append("\n");
    sb.append("    labelResults: ").append(toIndentedString(labelResults)).append("\n");
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

