/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.service;

import com.gruposcrum.grupo8.dao.ClientRepository;
import com.gruposcrum.grupo8.dao.MotorbikesRepository;
import com.gruposcrum.grupo8.entities.Client;
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
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    
  public List<Client> getAll() {return (List<Client>) clientRepository.getAll();};
  
  public Optional<Client> getClient(int id) {return clientRepository.getClient(id);};
  
  public Client save(Client client) { 
       if (client.getIdClient()== null){
           return clientRepository.save(client);
       }
       else
       {
          Optional<Client> co =  clientRepository.getClient(client.getIdClient());
          if (co.isEmpty()){
              return clientRepository.save(client);
          }
          else
          {
              return client;
          }
       }
 
    }
  
  
   public Client update (Client client){
        if (client.getIdClient() != null){
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (!e.isEmpty()){
                if (client.getName()!= null){
                    e.get().setName(client.getName());
                }
                if (client.getAge()!= null){
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword()!= null){
                    e.get().setPassword(client.getPassword());
                }
                
                clientRepository.save(e.get());
                return e.get();
            }
            else
            {
                return client;
            }
        }
        else
        {
            return client;
        }
    }
  
  public boolean deleteClient (int id){
   

      
      Boolean aBoolean = getClient(id).map(
              client->{
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
   
  }
  
  
}
