package com.sl.PAI_Lab7;

import com.sl.PAI_Lab7.dao.userDao;
import com.sl.PAI_Lab7.entity.User;
import com.sl.PAI_Lab7.dao.petDao;
import com.sl.PAI_Lab7.entity.Pet;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PaiLab7Application {
    @Autowired 
    private userDao dao; 
    @Autowired 
    private petDao petdao; 
    @Autowired 
    private PasswordEncoder passwordEncoder; 
 
    public static void main(String[] args) { 
        SpringApplication.run(PaiLab7Application.class, args); 
    } 
    @PostConstruct 
    public void init() { 
       // dao.save(new User("Piotr", "Piotrowski","admin",
    //passwordEncoder.encode("admin"))); 
       // dao.save(new User("Ania", "Annowska","ania",  
    //passwordEncoder.encode("ania"))); 
    //petdao.save(new Pet(2, "Latako", "Pies", "2", "Laciaty", "Jestwlaty", "Warszawa"));
    }}