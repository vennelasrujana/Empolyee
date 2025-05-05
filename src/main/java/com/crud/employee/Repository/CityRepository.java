package com.crud.employee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.employee.Entity.City;
import com.crud.employee.Entity.Country;

public interface CityRepository extends JpaRepository<City,Long>{
    public List<City> getCityByCountryCode(Country country);
}
