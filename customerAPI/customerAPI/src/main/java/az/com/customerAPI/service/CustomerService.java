package az.com.customerAPI.service;


import az.com.customerAPI.dto.CustomerDto;
import az.com.customerAPI.request.CustomerRequest;

import java.util.List;


public interface CustomerService {
    String create(CustomerRequest customerRequest);

    CustomerDto findById(Long id);

    List<CustomerDto> findAll();

}
