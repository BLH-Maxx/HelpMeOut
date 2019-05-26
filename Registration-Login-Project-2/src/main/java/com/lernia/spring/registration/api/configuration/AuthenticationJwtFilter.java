package com.lernia.spring.registration.api.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lernia.spring.registration.api.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationJwtFilter extends UsernamePasswordAuthenticationFilter{
	
	
	
	private UserDetailsService userDetailService;
	private Environment environment;
	
	public AuthenticationJwtFilter(UserDetailsService userDetailServie, 
			Environment environment, 
			AuthenticationManager authenticationManager) {
		this.userDetailService = userDetailServie;
		this.environment = environment;
		super.setAuthenticationManager(authenticationManager);
	}
	
	/*
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
  
            LoginModel creds = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginModel.class);
            
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUser_id(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
    
    
    
    
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
    	
    
    	
    	
    	String userName = ((User) auth.getPrincipal()).getUsername();
    	
    	// change loaduser 
    	UserDetails userDetails = userDetailService.loadUserByUsername(userName);
    	
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret") )
                .compact();
        
        res.addHeader("token", token);
        res.addHeader("userId", userDetails.getUsername());
        
        System.out.println(token);
        System.out.println(userDetails.getUsername());
        System.out.println("holaaaaaaa");
    } 
    
    

}
