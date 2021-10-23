/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.service;


import com.gruposcrum.grupo8.entities.Category;
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
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
      public List<Category> getCategorys() {return categoryService.getAll();};

    @GetMapping("/{id}")
      public Optional<Category> getCategory(@PathVariable("id") int categoryId) {
          return categoryService.getCategory(categoryId);
      }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
      public Category save(@RequestBody Category category) {return categoryService.save(category);};
      
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
      public Category update(@RequestBody Category category) {return categoryService.update(category);};

    @DeleteMapping("/{id}")
      public void delete(@PathVariable("id") int IdCategory) {
          categoryService.deleteCategory(IdCategory);
      }  
      
      
}
