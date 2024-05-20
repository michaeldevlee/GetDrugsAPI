package com.thedrugapi.thedrugapi.drugs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class DrugDTO {

    private String name;
    private String drugClass;
    private String moa;

}
