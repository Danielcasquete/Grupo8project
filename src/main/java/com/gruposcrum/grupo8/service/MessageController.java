/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.service;

import com.gruposcrum.grupo8.entities.Client;
import com.gruposcrum.grupo8.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danic
 */
@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
      public List<Message> getMessage() {return messageService.getAll();};

    @GetMapping("/{id}")
      public Optional<Message> getMessage(@PathVariable("id") int messageId) {
          return messageService.getMessage(messageId);
      }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
      public Message save(@RequestBody Message message) {return messageService.save(message);};
      
   
}