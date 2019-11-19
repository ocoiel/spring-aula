/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reputation.professional.repository;

import com.reputation.professional.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aluno
 */
@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    
}
