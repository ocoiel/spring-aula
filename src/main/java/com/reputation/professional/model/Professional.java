/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reputation.professional.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "professionals")
public class Professional {
    
    @Id             //chave primária      
    @GeneratedValue //auto_increment
    private Long id; 
    
    @NotNull       // not null
    private String name;
    
    @NotNull 
    private String position; //cargo
    
    @NotNull 
    private Float rating;
    
    @NotNull
    private Long appraisers; //avaliadores
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="companies_professionals",
            joinColumns = @JoinColumn(name="prof_id", referencedColumnName ="id"),
            inverseJoinColumns = @JoinColumn(name ="company_id", referencedColumnName = "id"))
    private List<Company> company_list; 

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Long getAppraisers() {
        return appraisers;
    }

    public void setAppraisers(Long appraisers) {
        this.appraisers = appraisers;
    }
    
    
    
}
