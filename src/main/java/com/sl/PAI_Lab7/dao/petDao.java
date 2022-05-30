/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sl.PAI_Lab7.dao;

/**
 *
 * @author sebol
 */
import com.sl.PAI_Lab7.entity.Pet; 
import org.springframework.data.repository.CrudRepository; 

public interface petDao extends CrudRepository<Pet, Integer> { 
    public Pet findByName(String name);
    public Iterable<Pet> findByUserid(int iduser);
    public Pet findByPetid(int petid);



} 

