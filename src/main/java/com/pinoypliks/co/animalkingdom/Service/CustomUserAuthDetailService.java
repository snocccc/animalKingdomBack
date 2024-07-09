package com.pinoypliks.co.animalkingdom.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;



import com.pinoypliks.co.animalkingdom.Model.Userauth;
import com.pinoypliks.co.animalkingdom.Repository.UserauthRepository;

@Service
public class CustomUserAuthDetailService implements UserDetailsService{

    private UserauthRepository repo;

    public CustomUserAuthDetailService(UserauthRepository repo) {
        this.repo = repo;
    }

    public UserDetails loadUserByUsername(String usernameoremail) throws UsernameNotFoundException{
        Userauth UserAuth = repo.findByUsernameOrEmail(usernameoremail, usernameoremail).orElseThrow(
            () -> new UsernameNotFoundException("username Not Found With username or email" + usernameoremail)
        );

        Set<GrantedAuthority> authorities = UserAuth
        .getRoles()
        .stream()
        .map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            UserAuth.getEmail(),
            UserAuth.getPassword(),
            authorities
        );
    }
}