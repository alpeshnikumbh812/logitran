//package com.example.logitran.security;
//
//import com.example.logitran.dao.AccountDAO;
//import com.example.logitran.dao.CompanyDAO;
//import com.example.logitran.dao.CustomerDAO;
//import com.example.logitran.dao.RoleDAO;
//import com.example.logitran.entity.Account;
//import com.example.logitran.entity.Company;
//import com.example.logitran.entity.Customer;
//import com.example.logitran.entity.Role;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.*;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private CustomerDAO customerDAO;
//
//    @Autowired
//    private CompanyDAO companyDAO;
//
//    @Autowired
//    private AccountDAO accountDAO;
//
//    @Autowired
//    private RoleDAO roleDAO;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        System.out.println(username);
//        System.out.println("UserDetails");
//
//        Account account = accountDAO.getAccountByEmail(username);
//        System.out.println("Account : "+ account);
//
//
//        if(account!=null){
//            String password = account.getPassword();
//            Role role = account.getRole();
//            String roleName = role.getName();
//
//            Collection<SimpleGrantedAuthority> roles = new HashSet<>();
//            roles.add(new SimpleGrantedAuthority(roleName.toUpperCase()));
//
//            return new User(username,password, roles);
//        }
//        else{
//            System.out.println("Exception");
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }
//
////    private static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Set<Role> roles) {
////        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
////        for (Role role : roles) {
////            authorities.add(new SimpleGrantedAuthority(role.getName()));
////        }
////        return authorities;
////    }
//}
