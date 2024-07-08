package com.pinoypliks.co.animalkingdom.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;


import com.pinoypliks.co.animalkingdom.DTO.RegistrationRequest;
import com.pinoypliks.co.animalkingdom.Model.Role;
import com.pinoypliks.co.animalkingdom.Repository.RoleRepository;
import com.pinoypliks.co.animalkingdom.Repository.UserauthRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class UserauthController {

    @Autowired
    UserauthRepository UserAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){

        if(UserAuthRepository.existByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("This Username is Already Taken!!!!", HttpStatus.BAD_REQUEST);
        }

        if(UserAuthRepository.existByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("This Email is Already Taken!!!!", HttpStatus.BAD_REQUEST);
        }

        Userauth UserAuth = new Userauth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        UserAuth.setRoles(Collections.singleton(role));

        UserAuthRepository.save(UserAuth);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }

}
