package com.thedrugapi.thedrugapi.drugs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Result {
    @JsonProperty("openfda")
    private OpenFDA openfda;
}
