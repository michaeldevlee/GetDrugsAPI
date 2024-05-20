package com.thedrugapi.thedrugapi.drugs;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/drug")
public class DrugsController {

    private final DrugsService drugsService;

    @GetMapping
    public ResponseEntity<Object> getDrugList(
        @RequestParam (value = "moa", defaultValue = "") String moa,
        @RequestParam (value = "generic_name", defaultValue = "") String generic_name,
        @RequestParam (value = "brand_name", defaultValue = "") String brand_name
        ) 
    {
        ArrayList<DrugDTO> drugList = drugsService.getDrugsByMoa(moa, generic_name, brand_name);
        return ResponseEntity.ok(drugList);
    }
    
}
