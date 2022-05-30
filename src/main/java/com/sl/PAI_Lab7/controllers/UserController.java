package com.sl.PAI_Lab7.controllers;

/**
 *
 * @author sebol
 */
import com.sl.PAI_Lab7.dao.userDao;
import com.sl.PAI_Lab7.entity.User;
import com.sl.PAI_Lab7.dao.petDao;
import com.sl.PAI_Lab7.entity.Pet;
import static java.lang.System.out;
import java.security.Principal; 
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
 
@Controller 
public class UserController { 
    @Autowired 
    private PasswordEncoder passwordEncoder; 
    @Autowired 
    private userDao dao; 
    @Autowired
    private petDao petdao; 
    
   
    
    @GetMapping("/login") 
    public String loginPage() { 
        //zwrócenie nazwy widoku logowania - login.html 
        return "login"; 
    } 
    @GetMapping("/register") 
    public String registerPage(Model m) { 
        //dodanie do modelu nowego użytkownika 
        m.addAttribute("user", new User()); 
        //zwrócenie nazwy widoku rejestracji - register.html 
        return "register"; 
    } 
    @PostMapping("/register") 
    public String registerPagePOST(@ModelAttribute(value = "user") @Valid User user , BindingResult binding) { 
        
        
        if (binding.hasErrors()) {
            return "register"; // powrót do formularza
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword())); 
        dao.save(user); 
        //przekierowanie do adresu url: /login 
        return "redirect:/login"; 
    } 
    @GetMapping("/profile") 
    public String profilePage(Model m, Principal principal) { 
        //dodanie do modelu obiektu user - aktualnie zalogowanego użytkownika: 
        m.addAttribute("user", dao.findByLogin(principal.getName())); 
        //zwrócenie nazwy widoku profilu użytkownika -  profile.html 
        return "profile"; 
    } 
    @GetMapping("/pets")
    public String petsList(Model m) {

        m.addAttribute("pets", petdao.findAll());
        m.addAttribute("users", dao);
        return "pets";
    }
    
     @GetMapping("/mypets")
    public String myPetsList(Model m, Principal principal) {
        m.addAttribute("mypets", petdao.findByUserid(dao.findByLogin(principal.getName()).getUserid()));
        return "mypets";
    }
    
    @GetMapping("/addpet")
    public String addPage(Model m, Principal principal) {
        m.addAttribute("pet", new Pet());
        return "addpet";
    }
    
    @PostMapping("/addpet")
    public String addPagePOST(@ModelAttribute(value = "pet") @Valid Pet pet, BindingResult binding, Principal principal) {

        if (binding.hasErrors()) {
           return "addpet"; // powrót do formularza
        }
        
        pet.setUserid(dao.findByLogin(principal.getName()).getUserid());
        petdao.save(pet);
        
        return "redirect:/mypets";
    }
    
    
    @GetMapping("/editpet/{petid}")
    public String editdescidPage(Model m, Principal principal, @PathVariable("petid") int petid) {
        out.print(petid);
        m.addAttribute( petdao.findByPetid(petid));
        return "editpet";
    }
    @PostMapping("/editpet")
    public String saveEditdescPage(@ModelAttribute(value = "pet") @Valid Pet pet, BindingResult binding, Principal principal) {
        if (binding.hasErrors()) {
            return "editpet"; // powrót do formularza
        }
        pet.setUserid(dao.findByLogin(principal.getName()).getUserid());
        out.print("id: "+pet.getPetid());
        petdao.save(pet);
        
        return "redirect:/mypets";
    }
    
    @GetMapping("/deletepet/{petid}")
    public String deletePet(Principal principal,@PathVariable("petid") int petid) {
        petdao.delete(petdao.findByPetid(petid));
        return "redirect:/mypets";
    }
    
    @GetMapping("/editusr")
    public String editUser(Principal principal, Model m) {
        User user = dao.findByLogin(principal.getName());
        
        m.addAttribute("user", user);
        return "editusr";
    }
    
    @GetMapping("/users") 
    public String usersList(Model m) { 
       
        m.addAttribute("usersList", dao.findAll());
        return "users";
    } 
    
    @GetMapping("/delete")
    public String deleteUser(Principal principal) {
        dao.delete(dao.findByLogin(principal.getName()));
        
       
        Iterable<Pet> pets = petdao.findAll();
        for(Pet pet: pets){
            if(pet.getUserid() == dao.findByLogin(principal.getName()).getUserid()) {
                petdao.delete(pet);
            }
        }
        
        return "redirect:/logout";
    }
    
    
    @PostMapping("/save")
    public String save (@ModelAttribute(value = "user") @Valid User user , BindingResult binding){
        
        if (binding.hasErrors()) {
            return "editusr"; // powrót do formularza
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword())); 
        dao.save(user); 
        return "redirect:profile";
    }
    
}
