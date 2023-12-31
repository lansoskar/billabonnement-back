package ita.bilabonemmenteksamenback.api;

import ita.bilabonemmenteksamenback.entity.Customer;
import ita.bilabonemmenteksamenback.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    //gets all customers
    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers(){return customerRepository.findAll(); }

    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    //create customer if requestbody is correct
    @PostMapping("/api/addCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
    return customerRepository.save(customer);
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    //gets customer by id
    @GetMapping("/api/customers/getCustomer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Access-Control-Allow-Origin")
    //checks customer credit
    @GetMapping("/api/customers/checkCredit/{customerId}")
    public ResponseEntity<Boolean> checkCreditApproval(@PathVariable Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            return ResponseEntity.ok(customer.getCreditApproved());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
