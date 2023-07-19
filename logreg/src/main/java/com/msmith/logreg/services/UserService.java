package com.msmith.logreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.msmith.logreg.models.Login;
import com.msmith.logreg.models.User;
import com.msmith.logreg.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;
    
    public User register(User newUser, BindingResult result) {
        Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
        
        if(optionalUser.isPresent()) {
        	result.rejectValue("email", "unique", "Already registered.");
        }
        
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("password", "matches", "Password does not match.");
        }
        
        if(result.hasErrors()) {
        	return null;
        }
        
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
    }
    
    public User login(Login newLogin, BindingResult result) {
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
    	
    	if(!optionalUser.isPresent()) {
        	result.rejectValue("email", "unique", "Email not registered");
        	return null; // if optional user empty can't get user so we must leave
        }
    	
    	User user = optionalUser.get();
    	
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
        	return null;
        }
    	
    	return user;
    }
}
