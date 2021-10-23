/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.service;

import com.gruposcrum.grupo8.entities.Category;
import com.gruposcrum.grupo8.entities.Motorbikes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danic
 */
@RestController
@RequestMapping("/api/Motorbike")
public class MotorbikesController {
    @Autowired
    private MotorbikesService motorbikesService;
    
    @GetMapping("/all")
      public List<Motorbikes> getMotorbikes() {return motorbikesService.getAll();};

    @GetMapping("/{id}")
      public Optional<Motorbikes> getMotorbikes(@PathVariable("id") int motorbikesId) {
          return motorbikesService.getMotorbikes(motorbikesId);
      }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbikes save(@RequestBody Motorbikes motorbikes) {return motorbikesService.save(motorbikes);};
      
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
      public Motorbikes update(@RequestBody Motorbikes motorbikes) {return motorbikesService.update(motorbikes);};

    @DeleteMapping("/{id}")
      public void delete(@PathVariable("id") int IdMotorbike) {
          motorbikesService.deleteMotorbike(IdMotorbike);
      }  
    
   
}
