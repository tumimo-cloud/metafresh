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

import java.util.Objects;
import java.util.Arrays;
import com.adekia.exchange.amazonsp.client.shipments.model.ErrorList;
import com.adekia.exchange.amazonsp.client.shipments.model.GetRatesResult;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * The response schema for the getRates operation.
 */
@ApiModel(description = "The response schema for the getRates operation.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-12T14:28:53.571+02:00")
public class GetRatesResponse {
  @SerializedName("payload")
  private GetRatesResult payload = null;

  @SerializedName("errors")
  private ErrorList errors = null;

  public GetRatesResponse payload(GetRatesResult payload) {
    this.payload = payload;
    return this;
  }

   /**
   * The payload for getRates operation
   * @return payload
  **/
  @ApiModelProperty(value = "The payload for getRates operation")
  public GetRatesResult getPayload() {
    return payload;
  }

  public void setPayload(GetRatesResult payload) {
    this.payload = payload;
  }

  public GetRatesResponse errors(ErrorList errors) {
    this.errors = errors;
    return this;
  }

   /**
   * Encountered errors for the operation.
   * @return errors
  **/
  @ApiModelProperty(value = "Encountered errors for the operation.")
  public ErrorList getErrors() {
    return errors;
  }

  public void setErrors(ErrorList errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetRatesResponse getRatesResponse = (GetRatesResponse) o;
    return Objects.equals(this.payload, getRatesResponse.payload) &&
        Objects.equals(this.errors, getRatesResponse.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payload, errors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetRatesResponse {\n");
    
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

