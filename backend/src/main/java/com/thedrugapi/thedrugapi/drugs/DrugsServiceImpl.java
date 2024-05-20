package com.thedrugapi.thedrugapi.drugs;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DrugsServiceImpl implements DrugsService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ArrayList<DrugDTO> getDrugsByMoa(String moa, String generic_name, String brand_name){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");

        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

        ParameterizedTypeReference<Results> beanType = new ParameterizedTypeReference<Results>() {};

        String base_url = "https://api.fda.gov/drug/drugsfda.json?search=";

        String formattedURL = constructQuery(base_url, moa, generic_name, brand_name);
        System.out.println(formattedURL);
        ArrayList<DrugDTO> drugList = new ArrayList<DrugDTO>();

        try {
            ResponseEntity<Results> response = restTemplate.exchange(formattedURL, HttpMethod.GET, httpEntity, beanType);
            ArrayList<Result> result = response.getBody().getResults();
    
            for (int i = 0; i < result.size(); i++) {
                DrugDTO drugDTO = new DrugDTO();
                OpenFDA openFDA = result.get(i).getOpenfda();
    
                if (openFDA.getGeneric_name() != null){
                    drugDTO.setName(openFDA.getGeneric_name().get(0));
                }
    
                if (openFDA.getPharm_class_moa() != null){
                    drugDTO.setMoa(openFDA.getPharm_class_moa().get(0));
                }
    
                if (openFDA.getPharm_class_cs() != null){
                    drugDTO.setDrugClass(openFDA.getPharm_class_cs().get(0));
                }

                drugList.add(drugDTO);

                
            } 
            return drugList;
        }
        catch (Exception e) {
            //TODO: implement error handling
            return null;
        }
    
        
    } 

// helpers

    public String constructQuery(String base_url, String moa, String generic_name, String brand_name){

        StringBuilder queryBuilder = new StringBuilder();

        String moa_query = !moa.equals("") ? "openfda.pharm_class_moa:" + moa : "";
        String generic_name_query = !generic_name.equals("") ? ("openfda.generic_name:" + generic_name) : "";
        String brand_name_query = !brand_name.equals("") ? "openfda.brand_name:" + brand_name : "";
        
        System.out.println(generic_name_query);

        ArrayList<String> query_strings = new ArrayList<String>();

        query_strings.add(moa_query);
        query_strings.add(generic_name_query);
        query_strings.add(brand_name_query);

        for (int i = 0; i < query_strings.size(); i++) {
            if (!query_strings.get(i).equals("")){
                queryBuilder.append(query_strings.get(i));
            }
            else{
                continue;
            }

            
            if (i < query_strings.size() - 1 && !query_strings.get(i+1).equals("") ){
                queryBuilder.append("+AND+");
            }
        }

        String constructedQuery = base_url + queryBuilder.toString() + "&limit=99";

        return constructedQuery;

    }

}
