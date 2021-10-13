/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.dao;

import com.gruposcrum.grupo8.entities.Motorbikes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gruposcrum.grupo8.entities.MotorbikesCrud;

/**
 *
 * @author danic
 */

@Repository
public class MotorbikesRepository {
    @Autowired
  private MotorbikesCrud motorbikesCrudRepository;
  
  public List<Motorbikes> getAll(){return (List<Motorbikes>) motorbikesCrudRepository.findAll();};
  
  public Optional<Motorbikes> getMotorbikes(int id) {return motorbikesCrudRepository.findById(id);};
  
  public Motorbikes save(Motorbikes motorbikes){ return motorbikesCrudRepository.save(motorbikes);};
    
}
