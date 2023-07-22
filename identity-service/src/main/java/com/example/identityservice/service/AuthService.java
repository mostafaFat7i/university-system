package com.example.identityservice.service;


import com.example.identityservice.entity.UserCredential;
import com.example.identityservice.repository.UserCredentialRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    private static final Logger infoLogger = LoggerFactory.getLogger("infoLogger");
    private static final Logger errorLogger = LoggerFactory.getLogger("errorLogger");
    private static final Logger debugLogger = LoggerFactory.getLogger("debugLogger");

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        repository.save(credential);
        infoLogger.info("New user added with id: " + credential.getId());
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}
