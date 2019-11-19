/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reputation.professional.controller;

import com.reputation.professional.model.Professional;
import com.reputation.professional.repository.ProfessionalRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aluno
 */
@RestController
public class ProfessionalController {
    
    @Autowired
    ProfessionalRepository repository;
    
    @GetMapping("/professionals")
    public List<Professional> getAllProfessionals()
    {
        return repository.findAll();
    }
    
    @PostMapping("/professionals")
    public Professional createProfessional
        (@Valid @RequestBody Professional professional)
    {
       return repository.save(professional);
    }
    
    @GetMapping("/professional/{id}")   
    public Optional<Professional> findById(@PathVariable(value ="id") Long professionalId)
    {
        return repository.findById(professionalId);
    }
    
    @DeleteMapping("/professional/{id}")   
    public Optional<Professional> deleteProfessional(@PathVariable(value ="id") Long professionalId)
    {
        //procura o id na tabela
        Optional<Professional> professional 
                = repository.findById(professionalId);
        if( professional != null )
        {
            //encontrou esse id na tabela, entao deleta a linha
            repository.delete(professional.get());
        }
       
        return professional;
    }
    
    @PutMapping("/professional/{id}")
    public Optional<Professional> updateProfessional
        (@Valid @RequestBody Professional professional,
                @PathVariable(value ="id") Long professionalId)
    {
       //procura o id na tabela
        Optional<Professional> professionalFounded 
                = repository.findById(professionalId);
        if( professionalFounded != null )
        {
            //se achou o id, atualiza o objeto
            professionalFounded.get().setName(professional.getName());
            professionalFounded.get().setPosition(professional.getPosition());
            professionalFounded.get().setRating(professional.getRating());
            professionalFounded.get().setAppraisers(professional.getAppraisers());
            //salva na tabela
            repository.save(professionalFounded.get());
        }
        
        return professionalFounded;
    }
    
}
