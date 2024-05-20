package com.thedrugapi.thedrugapi.drugs;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public interface DrugsService {
    ArrayList<DrugDTO> getDrugsByMoa(String moa, String generic_name, String brand_name);
}
