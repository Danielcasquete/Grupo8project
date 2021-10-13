/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.dao;

import com.gruposcrum.grupo8.entities.Client;
import com.gruposcrum.grupo8.entities.ClientCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danic
 */
@Repository
public class ClientRepository {
    @Autowired
  private ClientCrud clientCrudRepository;
  
  public List<Client> getAll(){return (List<Client>) clientCrudRepository.findAll();};
  
  public Optional<Client> getClient(int id) {return clientCrudRepository.findById(id);};
  
  public Client save(Client client){ return clientCrudRepository.save(client);};
    
}
