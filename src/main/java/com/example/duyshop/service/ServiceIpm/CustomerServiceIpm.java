package com.example.duyshop.service.ServiceIpm;

import com.example.duyshop.dto.CustomerDto;
import com.example.duyshop.entity.CustomerEntity;
import com.example.duyshop.reponsitory.CustomerReponsitory;
import com.example.duyshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIpm extends AstractService implements CustomerService {
    @Autowired
    CustomerReponsitory customerReponsitory;

    @Override
    public CustomerEntity findEntityById(Integer id) {
        return customerReponsitory.findById(id).get();
    }

    @Override
    public CustomerDto findDtoBybyid(Integer id) {
        return (CustomerDto) map(findEntityById(id));
    }
}
