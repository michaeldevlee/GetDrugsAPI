package com.thedrugapi.thedrugapi.drugs;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)

public class OpenFDA {
    @JsonProperty("generic_name")
    private ArrayList<String> generic_name;

    @JsonProperty("pharm_class_moa")
    private ArrayList<String> pharm_class_moa;

    @JsonProperty("pharm_class_cs")
    private ArrayList<String> pharm_class_cs;
}
