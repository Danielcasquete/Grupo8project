/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.service;

import com.gruposcrum.grupo8.dao.MotorbikesRepository;
import com.gruposcrum.grupo8.entities.Motorbikes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danic
 */
@Service
public class MotorbikesService {
    @Autowired
    MotorbikesRepository motorbikesRepository;
    
  public List<Motorbikes> getAll() {return (List<Motorbikes>) motorbikesRepository.getAll();};
  
  public Optional<Motorbikes> getMotorbikes(int id) {return motorbikesRepository.getMotorbikes(id);};
  
  public Motorbikes save(Motorbikes motorbikes) { 
       if (motorbikes.getId()== null){
           return motorbikesRepository.save(motorbikes);
       }
       else
       {
          Optional<Motorbikes> co =  motorbikesRepository.getMotorbikes(motorbikes.getId());
          if (co.isEmpty()){
              return motorbikesRepository.save(motorbikes);
          }
          else
          {
              return motorbikes;
          }
       }
 
    }
  
    public Motorbikes update (Motorbikes motorbike){
        if (motorbike.getId() != null){
            Optional<Motorbikes> e = motorbikesRepository.getMotorbikes(motorbike.getId());
            if (!e.isEmpty()){
                if (motorbike.getName()!= null){
                    e.get().setName(motorbike.getName());
                }
                if (motorbike.getBrand()!= null){
                    e.get().setBrand(motorbike.getBrand());
                }
                if (motorbike.getDescription()!= null){
                    e.get().setDescription(motorbike.getDescription());
                }
                if (motorbike.getYear()!= null){
                    e.get().setYear(motorbike.getYear());
                }
                
                motorbikesRepository.save(e.get());
                return e.get();
            }
            else
            {
                return motorbike;
            }
        }
        else
        {
            return motorbike;
        }
    }
  
  public boolean deleteMotorbike (int id){
   

      
      Boolean aBoolean = getMotorbikes(id).map(
              motorbike->{
            motorbikesRepository.delete(motorbike);
            return true;
        }).orElse(false);
        return aBoolean;
   
  }
  
  
}

