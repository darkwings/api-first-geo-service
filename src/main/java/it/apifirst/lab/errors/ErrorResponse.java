package it.apifirst.lab.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ErrorResponse(@JsonProperty String title,
                            @JsonProperty String detail,
                            @JsonProperty String code,
                            @JsonProperty Integer status,
                            @JsonProperty("invalid_params") List<InvalidParam> invalidParams,
                            @JsonProperty String instance) {}
