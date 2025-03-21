package com.practise.service;

import com.practise.model.UserPrincipal;
import com.practise.model.Users;
import com.practise.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDataService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user =userRepo.findByUsername(username);
        if(user==null){
            System.out.println("User Not found");
            throw new UsernameNotFoundException("user not found");

        }
        return new UserPrincipal(user);

    }
}
