/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author danic
 */

/**
* clase motorbikes
*/
@Entity
@Table (name = "motorbikes")
public class Motorbikes implements Serializable {
/**
* atributo principal o llave principal
*/
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
/**
* atributo nombre
*/
    private String name;
/**
* atributo brand
*/
    private String brand;
/**
* atributo year
*/
    private Integer year;
/**
* atributo descripcion
*/
    private String description;

/**
* atriubto llave foranea ctaegory
*/  
    @ManyToOne
    @JoinColumn(name ="Category")
    @JsonIgnoreProperties("motorbikes")
    private Category category;
    
/**
* lista de mensajes
*/    
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="motorbike")
     @JsonIgnoreProperties({"motorbike","client"})
     private List<Message> messages;
/**
* lista de reervaciones
*/     
     @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="motorbike")
     @JsonIgnoreProperties({"motorbike","client"})
     private List<Reservation> reservations;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
     
     

     
     
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    

    
}
