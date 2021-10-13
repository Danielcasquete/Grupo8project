/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.dao;

import com.gruposcrum.grupo8.entities.Client;
import com.gruposcrum.grupo8.entities.ClientCrud;
import com.gruposcrum.grupo8.entities.Message;
import com.gruposcrum.grupo8.entities.MessageCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danic
 */
@Repository
public class MessageRepository {
    @Autowired
  private MessageCrud messageCrudRepository;
  
  public List<Message> getAll(){return (List<Message>) messageCrudRepository.findAll();};
  
  public Optional<Message> getMessage(int id) {return messageCrudRepository.findById(id);};
  
  public Message save(Message message){ return messageCrudRepository.save(message);};
    
}