package az.com.customerAPI.service.impl;

import az.com.customerAPI.dto.CustomerDto;
import az.com.customerAPI.exception.CustomerAlreadyExistsException;
import az.com.customerAPI.exception.CustomerNotFoundException;
import az.com.customerAPI.mapper.CustomerMapper;
import az.com.customerAPI.repository.CustomerRepository;
import az.com.customerAPI.request.CustomerRequest;
import az.com.customerAPI.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;
@Transactional
    @Override
    public String create(CustomerRequest customerRequest) {
        try {
            customerRepository.saveAndFlush(customerMapper.requestToModel(customerRequest));
            return "Customer was created successfully.";
        } catch (Exception e) {
            log.error("Exception caught");
            e.printStackTrace();
            throw new CustomerAlreadyExistsException("Customer already exists!");
        }
    }
    @Transactional
    @Override
    public CustomerDto findById(Long id) {
        var customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customerMapper.entityToDto(customer.get());
        } else {
            throw new CustomerNotFoundException("No customer present with id= " + id);
        }
    }
    @Transactional
    @Override
    public List<CustomerDto> findAll() {
        var customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::entityToDto).collect(Collectors.toList());
    }
}