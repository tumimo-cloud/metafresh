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
 * The payload schema for the getRates operation.
 */
@Schema(description = "The payload schema for the getRates operation.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-12T14:28:53.571+02:00")
public class GetRatesResult {
  @SerializedName("serviceRates")
  private ServiceRateList serviceRates = null;

  public GetRatesResult serviceRates(ServiceRateList serviceRates) {
    this.serviceRates = serviceRates;
    return this;
  }

   /**
   * Get serviceRates
   * @return serviceRates
  **/
  @Schema(required = true, description = "")
  public ServiceRateList getServiceRates() {
    return serviceRates;
  }

  public void setServiceRates(ServiceRateList serviceRates) {
    this.serviceRates = serviceRates;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetRatesResult getRatesResult = (GetRatesResult) o;
    return Objects.equals(this.serviceRates, getRatesResult.serviceRates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceRates);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetRatesResult {\n");
    
    sb.append("    serviceRates: ").append(toIndentedString(serviceRates)).append("\n");
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

