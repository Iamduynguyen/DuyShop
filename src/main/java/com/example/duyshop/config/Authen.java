package com.example.duyshop.config;

import com.example.duyshop.entity.StaffEntity;
import com.example.duyshop.reponsitory.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class Authen implements UserDetailsService {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    HttpSession session;
    @Autowired
    StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("alo"+s);
        String user="";
        String password="";
        StaffEntity staffEntity = staffRepository.findByEmail(s);
        if (staffEntity ==null){
//            Customer customer = customerDAO.findByEmail(s);
//            if (customer!=null){
//                session.setAttribute("customer",customer);
//                user = customer.getEmail();
//                password = customer.getPassword();
//            }
        }else {
//            session.setAttribute("staff",staff);
            user = staffEntity.getEmail();
            password = staffEntity.getPassword();
        }
        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_MANAGER");
        grantList.add(authority);
//        for (Roles roles:roleDao.findAll()){
//            GrantedAuthority authority = new SimpleGrantedAuthority(roles.getName());
//            grantList.add(authority);
//        }
        UserDetails userDetails = new User(user, encoder.encode(password), grantList);
        return userDetails;
    }
}
