package com.pinoypliks.co.animalkingdom.Controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pinoypliks.co.animalkingdom.DTO.LoginRequest;
import com.pinoypliks.co.animalkingdom.DTO.RegistrationRequest;
import com.pinoypliks.co.animalkingdom.Model.Role;
import com.pinoypliks.co.animalkingdom.Model.Userauth;
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

        if(UserAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("This username is Already Taken!!!!", HttpStatus.BAD_REQUEST);
        }

        if(UserAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("This email is Already Taken!!!!", HttpStatus.BAD_REQUEST);
        }

        Userauth User = new Userauth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        User.setRoles(Collections.singleton(role));

        UserAuthRepository.save(User);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }

    @PostMapping("/register/user")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest){
        
        if (UserAuthRepository.existsByUsername(registrationRequest.getUsername())) {
            return new ResponseEntity<>("username Is Already Taken", HttpStatus.BAD_REQUEST);
        }

        if (UserAuthRepository.existsByEmail(registrationRequest.getEmail())) {
            return new ResponseEntity<>("An Account Is Already Registered In This email", HttpStatus.BAD_REQUEST);
        }

        Userauth user = new Userauth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_USER").get();
        user .setRoles(Collections.singleton(role));

        UserAuthRepository.save(user);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsernameorEmail(),
                    loginRequest.getPassword()
                )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User Logged In Successfully", HttpStatus.OK);
        }catch(Exception e){
            System.err.println(e.toString());
            return new ResponseEntity<>("Invalid Username or Password", HttpStatus.UNAUTHORIZED);
        }
    }

    

}
