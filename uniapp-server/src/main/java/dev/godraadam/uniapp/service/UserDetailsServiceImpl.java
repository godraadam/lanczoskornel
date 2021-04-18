package dev.godraadam.uniapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import dev.godraadam.uniapp.model.ApplicationUser;
import dev.godraadam.uniapp.repo.UserRepo;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return User.builder().
            username(user.getUsername()).
            password(user.getPassword()).
            roles(user.getRole().name()).
            build();
    }
    
}
