/*
 * Patient - Warenwirtschaft (Basis)
 * Synchronisation der Patienten mit der Warenwirtschaft
 *
 * OpenAPI spec version: 1.0.7
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.math.BigDecimal;
import org.threeten.bp.OffsetDateTime;
/**
 * Payer
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-11-24T08:15:46.695Z[GMT]")
public class Payer {
  @SerializedName("_id")
  private String _id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("type")
  private BigDecimal type = null;

  @SerializedName("ikNumber")
  private String ikNumber = null;

  @SerializedName("timestamp")
  private OffsetDateTime timestamp = null;

  public Payer _id(String _id) {
    this._id = _id;
    return this;
  }

   /**
   * Id
   * @return _id
  **/
  @Schema(example = "5ada01a2c3918e1bdcb54612", required = true, description = "Id")
  public String getId() {
    return _id;
  }

  public void setId(String _id) {
    this._id = _id;
  }

  public Payer name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(example = "AOK Bremen / Bremerhaven", description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Payer type(BigDecimal type) {
    this.type = type;
    return this;
  }

   /**
   * 0 &#x3D; Unbekannt, 1 &#x3D; gesetzlich, 2 &#x3D; privat, 3 &#x3D; Berufsgenossenschaft, 4 &#x3D; Selbstzahler, 5 &#x3D; Andere
   * minimum: 0
   * maximum: 5
   * @return type
  **/
  @Schema(example = "1", description = "0 = Unbekannt, 1 = gesetzlich, 2 = privat, 3 = Berufsgenossenschaft, 4 = Selbstzahler, 5 = Andere")
  public BigDecimal getType() {
    return type;
  }

  public void setType(BigDecimal type) {
    this.type = type;
  }

  public Payer ikNumber(String ikNumber) {
    this.ikNumber = ikNumber;
    return this;
  }

   /**
   * Get ikNumber
   * @return ikNumber
  **/
  @Schema(example = "108534160", description = "")
  public String getIkNumber() {
    return ikNumber;
  }

  public void setIkNumber(String ikNumber) {
    this.ikNumber = ikNumber;
  }

  public Payer timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Der Zeitstempel der letzten Änderung
   * @return timestamp
  **/
  @Schema(description = "Der Zeitstempel der letzten Änderung")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payer payer = (Payer) o;
    return Objects.equals(this._id, payer._id) &&
        Objects.equals(this.name, payer.name) &&
        Objects.equals(this.type, payer.type) &&
        Objects.equals(this.ikNumber, payer.ikNumber) &&
        Objects.equals(this.timestamp, payer.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_id, name, type, ikNumber, timestamp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payer {\n");
    
    sb.append("    _id: ").append(toIndentedString(_id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    ikNumber: ").append(toIndentedString(ikNumber)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
