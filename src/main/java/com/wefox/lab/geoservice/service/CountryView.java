package com.wefox.lab.geoservice.service;

import com.fasterxml.jackson.annotation.JsonProperty;


public record CountryView(@JsonProperty("country_id") String countryId,
                          @JsonProperty String name,
                          @JsonProperty("phone_code") String phoneCode,
                          @JsonProperty boolean deleted) {
}
