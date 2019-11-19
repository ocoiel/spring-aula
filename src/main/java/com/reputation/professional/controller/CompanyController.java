/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reputation.professional.controller;

import com.reputation.professional.model.Company;
import com.reputation.professional.repository.CompanyRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aluno
 */
@RestController
public class CompanyController {
   
    @Autowired
    CompanyRepository repository;
    
    @GetMapping("/companies")
    public List<Company> getAllCompanies()
    {
        return repository.findAll();
    }
    
    @PostMapping("/companies")
    public Company createCompany
        (@Valid @RequestBody Company company)
    {
       return repository.save(company);
    }
}
