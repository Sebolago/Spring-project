package com.sl.PAI_Lab7.entity;
/**
 *
 * @author sebol
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity 
@Table(name = "Pets") 
public class Pet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer petid;
   
    
    
    @NotNull
    @Pattern(regexp = "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,30}", message="Podaj poprawnie imię")
    private String name;
    
    @NotNull
    private String type ;
    
    @NotNull
    @Pattern(regexp = "[^*]{1,30}", message="Podaj poprawny wiek")
    private String age;
    
    @NotNull
    @Pattern(regexp = "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,30}", message="Podaj poprawny kolor umaszczenia")
    private String color ;
    
    @NotNull
    @Pattern(regexp = "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,30}", message="Podaj poprawny opis")
    private String about ;
    
    @NotNull
    @Pattern(regexp = "[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]{2,30}",message = "Podaj miejsce zamieszkania zwierzaka")
    private String city;
    
    private Integer userid;

    public Pet(){    
    }
    
    public Pet(Integer userid, String name, String type, String age, String color, String about, String city) {
        this.userid = userid;
        this.name = name;
        this.type = type;
        this.age = age;
        this.color = color;
        this.about = about;
        this.city = city;
    }

    public Integer getPetid() {
        return petid;
    }

    public void setPetid(Integer petid) {
        this.petid = petid;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    


    
     
}
