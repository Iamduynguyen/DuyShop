package com.example.duyshop.restcontroller;

import com.example.duyshop.entity.StaffEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
//    @Autowired
//    Staff staff;


    @GetMapping("/api/staffsession")
//    public ResponseEntity<Staff> getstaff(){
//        Staff staff = new Staff();
//        staff.setEmail("abc");
//        staff.setPassword("2333");
//        return ResponseEntity.ok(staff);
//    }
    public String getStaff(){
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setEmail("a");
        staffEntity.setPassword("b");
        return "aa";
    }
}
