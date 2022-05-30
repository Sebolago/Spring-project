package com.sl.PAI_Lab7.entity;
/**
 *
 * @author sebol
 */
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Table; 
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
 
@Entity 
@Table(name = "Users") 
public class User {   
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;
    
    @NotNull
    @Pattern(regexp = "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,30}", message="Podaj poprawnie imię")
    private String name;
    
    @NotNull
    @Pattern(regexp = "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,30}", message="Podaj poprawnie nazwisko")
    private String surname;
    
    @NotNull
    @Pattern(regexp="[^*]{9}" )
    private String phone;
    
    @NotNull
    @Column(unique=true)
    @Pattern(regexp = "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,30}", message="Podaj poprawny login")
    private String login;

    
    @NotBlank(message = "Podaj haslo")
    private String password;
    
    
    
    public User() { 
    } 
 
    public User(String name, String surname, String login, String password, String phone) { 
        this.name = name; 
        this.surname = surname; 
        this.login = login; 
        this.password = password; 
        this.phone= phone;
    } 

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
   
}