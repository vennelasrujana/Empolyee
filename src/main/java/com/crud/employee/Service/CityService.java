package com.crud.employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.employee.Entity.City;
import com.crud.employee.Entity.Country;
import com.crud.employee.Repository.CityRepository;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    

    public List<City> findCitiesByCode(Country country) {
       return cityRepository.getCityByCountryCode(country);
    }


   
}
