/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reputation.professional.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "companies")
public class Company {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    private String name;
    
    @ManyToMany(mappedBy = "company_list")
    private List<Professional> professional_list;

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

    public List<Professional> getProfessional_list() {
        return professional_list;
    }

    public void setProfessional_list(List<Professional> professional_list) {
        this.professional_list = professional_list;
    }
    
    
}
