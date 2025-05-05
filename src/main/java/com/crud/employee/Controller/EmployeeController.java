package com.crud.employee.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.employee.Entity.City;
import com.crud.employee.Entity.Country;
import com.crud.employee.Entity.Employee;
import com.crud.employee.Repository.EmployeeRepository;
import com.crud.employee.Service.CityService;
import com.crud.employee.Service.CountryService;
import com.crud.employee.Service.EmployeeService;

@Controller
public class EmployeeController {

    Employee employee=new Employee();

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CountryService countryService;

    @Autowired
    CityService cityService;

    Country country=new Country();

    List<String> profession=new ArrayList<>(Arrays.asList("Developer","Tester","Architect"));
    @GetMapping("/")
    public String getHome(Model model,@ModelAttribute("employee") Employee employee){
        List<Country> CountryName=countryService.getCountries();
        List<City> cities=cityService.findCitiesByCode(employee.getCountry());
        model.addAttribute("employee", employee);
        model.addAttribute("profession", profession);
        model.addAttribute("countries", CountryName);
        model.addAttribute("cities", cities);
        return "index";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("employee") Employee employee ){
        employeeService.saveEmployee(employee);
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee", employee);
        return "login";
    }

    @PostMapping("/login")
    public String postlogin(Model model,@ModelAttribute("employee") Employee emp){
        Employee employee=employeeRepository.findFirstByEmail(emp.getEmail());
        if(employee!=null && employee.getPassword().equals(emp.getPassword())){
            model.addAttribute("Success", "Login Successful");
            return "redirect:/login/details";
        }
        else{
            model.addAttribute("error", "Email or password is incorrect");
        }
        return "login";
    }

    @GetMapping("/login/details")
    public String getDetails(Model model){
        List<Employee> employees=employeeService.getAll();

        model.addAttribute("employees", employees);
        return "table";
    }

    @GetMapping("/login/details/update/{id}")
    public String getEmployee(Model model,@PathVariable("id") Long id){
        Optional<Employee> employeeById=employeeService.getById(id);
        List<Country> CountryName=countryService.getCountries();
        if(employeeById.isPresent()){
            Employee employee= employeeById.get();
            model.addAttribute("employee", employee);
            model.addAttribute("profession", profession);
            model.addAttribute("countries", CountryName);
        }
        return "index";
    }

    @PostMapping("/login/details/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id,@ModelAttribute("employee") Employee employee){
        Optional<Employee> employeeById=employeeService.getById(id);
        if(employeeById.isPresent()){
            Employee updateEmployee= employeeById.get();
            updateEmployee.setName(employee.getName());
            updateEmployee.setAddress(employee.getAddress());
            updateEmployee.setEmail(employee.getEmail());
            updateEmployee.setProfession(employee.getProfession());
            updateEmployee.setGender(employee.getGender());
            updateEmployee.setPassword(employee.getPassword());
            updateEmployee.setCountry(employee.getCountry());
            employeeService.saveEmployee(updateEmployee);
        }
        return "redirect:/login/details";
    }

    @GetMapping("/login/details/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id){
        Optional<Employee> employeeById=employeeService.getById(id);
        if(employeeById.isPresent()){
            employeeService.deleteEmployee(id);
        }
        return "redirect:/login/details";
    }

}
