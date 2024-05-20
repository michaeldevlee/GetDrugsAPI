package com.thedrugapi.thedrugapi.drugs;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Results {
    private ArrayList<Result> results;
}
