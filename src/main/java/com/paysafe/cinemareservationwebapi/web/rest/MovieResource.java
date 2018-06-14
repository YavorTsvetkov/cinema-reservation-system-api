package com.paysafe.cinemareservationwebapi.web.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResource {




  @NotNull
  public DecisionTableAttribute.DataType dataType;

  @NotNull
  public DecisionTableAttribute.AttributeType attributeType;

  @Valid
  public AttributeEnrichmentInfoResource enrichmentInfo;

  @Valid
  public AttributePredefinedEnrichmentInfoResource predefinedValuesInfo;

  public AttributeEnrichmentInfoResource getEnrichmentInfo() {
    return enrichmentInfo;
  }

  public AttributePredefinedEnrichmentInfoResource getPredefinedValuesInfo() {
    return predefinedValuesInfo;
  }

  static class AttributeEnrichmentInfoResource {

    @NotEmpty
    public String url;

    @NotNull
    public AttributeEnrichmentInfo.Method httpMethod;

    public String jsonBody;

    @NotEmpty
    public String responsePropertyPathSelector;

    public String getUrl() {
      return url;
    }

    public AttributeEnrichmentInfo.Method getHttpMethod() {
      return httpMethod;
    }

    public String getResponsePropertyPathSelector() {
      return responsePropertyPathSelector;
    }

    AttributeEnrichmentInfo toDomainObject() {
      return new AttributeEnrichmentInfo(url, httpMethod, jsonBody, responsePropertyPathSelector);
    }
  }

  static class AttributePredefinedEnrichmentInfoResource extends AttributeEnrichmentInfoResource {

    public Map<String, String> arrayItemStructure;

    @Override
    AttributePredefinedEnrichmentInfo toDomainObject() {

      Map<String, String> itemStructure = new HashMap<>();
      if (arrayItemStructure != null) {
        itemStructure = arrayItemStructure;
      }

      return new AttributePredefinedEnrichmentInfo(
          url, httpMethod, jsonBody, responsePropertyPathSelector, itemStructure);
    }
  }






}
