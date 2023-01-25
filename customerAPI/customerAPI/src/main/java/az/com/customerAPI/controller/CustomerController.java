package az.com.customerAPI.controller;

import az.com.customerAPI.dto.CustomerDto;
import az.com.customerAPI.request.CustomerRequest;
import az.com.customerAPI.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public void save(@RequestBody @Valid CustomerRequest customerRequest) {
        customerService.create(customerRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

}
