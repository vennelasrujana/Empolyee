package com.crud.employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.employee.Entity.Country;
import com.crud.employee.Repository.CountryRepository;

@Service
public class CountryService {
    
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public Country findByCode(String code) {
        
       return countryRepository.getByCode(code);
    }
}
