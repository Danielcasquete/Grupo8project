/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gruposcrum.grupo8.service;

import com.gruposcrum.grupo8.dao.ReservationRepository;
import com.gruposcrum.grupo8.entities.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danic
 */
/**
* clase para los sergvicios de reservation
*/
@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
/**
* metodo obtener todas las reservaciones
*/ 
  public List<Reservation> getAll() {return (List<Reservation>) reservationRepository.getAll();};
/**
* metodo obtener reservacion por id
*/  
  public Optional<Reservation> getReservation(int id) {return reservationRepository.getReservation(id);};
 /**
* metodo guardar reservacion
*/ 
  public Reservation save(Reservation reservation) { 
       if (reservation.getIdReservation()== null){
           return reservationRepository.save(reservation);
       }
       else
       {
          Optional<Reservation> co =  reservationRepository.getReservation(reservation.getIdReservation());
          if (co.isEmpty()){
              return reservationRepository.save(reservation);
          }
          else
          {
              return reservation;
          }
       }
 
    }
  
/**
* metodo actualizar reservacion
*/  
      public Reservation update (Reservation reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()){
                if (reservation.getStartDate()!= null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!= null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!= null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }
            else
            {
                return reservation;
            }
        }
        else
        {
            return reservation;
        }
    }

/**
* metodo borrar reservacion
*/  
      
      
  public boolean deleteReservation (int id){
   

      
      Boolean aBoolean = getReservation(id).map(
              reservation->{
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
   
  }
  
  
  
}