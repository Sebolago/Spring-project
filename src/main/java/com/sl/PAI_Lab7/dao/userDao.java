/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sl.PAI_Lab7.dao;

/**
 *
 * @author sebol
 */
import com.sl.PAI_Lab7.entity.User; 
import org.springframework.data.repository.CrudRepository; 
 
public interface userDao extends CrudRepository<User, Integer> { 
    public User findByLogin(String login);
    public User findByUserid(int id);
} 