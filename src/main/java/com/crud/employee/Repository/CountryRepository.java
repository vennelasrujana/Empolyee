package com.crud.employee.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.employee.Entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {
    public Country getByCode(String code);
}
