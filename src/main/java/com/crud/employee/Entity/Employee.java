package com.crud.employee.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees") // Explicit table name for clarity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String password;
    private String gender;
    private String profession;
    
    @ManyToOne
    @JoinColumn(name = "country", referencedColumnName="code") 
    private Country country;

    @ManyToOne
    @JoinColumn(name="city", referencedColumnName = "CountryCode")
    private City city;

    private String address;

    
    public Employee() {}

    
    public Employee(Long id, String name, String email, String password, String gender, 
                    String profession, String address, Country country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.profession = profession;
        this.address = address;
        this.country = country;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() { 
        return country;
    }

    public void setCountry(Country country) { 
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + 
               ", gender=" + gender + ", profession=" + profession + 
               ", address=" + address + ", country=" + (country != null ? country.getName() : "null") + "]";
    }
}
