package com.thancute.ShopCarDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

import com.thancute.ShopCarDemo.model.Customer;
import com.thancute.ShopCarDemo.repositories.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService{
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepository.findByUsername(username);
        String password = null;
        List<GrantedAuthority> authorities = null;

        if (customers.isEmpty()) {
            throw new UsernameNotFoundException("UserDetails not found username = " + username);
        }

        username = customers.get(0).getUsername();
        password = customers.get(0).getPasswords();
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customers.get(0).getRoles()));

        return new User(username, password, authorities);
    }

    public void SaveUser(Customer customer){
        String password = passwordEncoder.encode(customer.getPasswords());
        customer.setPasswords(password);
        customerRepository.save(customer);
    }
    
}
