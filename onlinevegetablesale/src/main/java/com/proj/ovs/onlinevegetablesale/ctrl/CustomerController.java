package com.proj.ovs.onlinevegetablesale.ctrl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.proj.ovs.onlinevegetablesale.entity.Address;
import com.proj.ovs.onlinevegetablesale.entity.Customer;
import com.proj.ovs.onlinevegetablesale.service.CustomerService;

@RestController
public class CustomerController {
@Autowired
	CustomerService customerService;
    @PostMapping("/customers")
    public Customer createCustomer(@Valid@RequestBody Customer customer)
    {
    	return customerService.createCustomer(customer);
    }
    @GetMapping("/customers")
    public List<Customer> getCustomer()
    {
    	return customerService.getCustomer();
    }
    @DeleteMapping("/customers")
    public boolean deleteAllCustomer()
    {
    	return customerService.deleteAllCustomer();
    }
    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer obj)
    {
    	return customerService.updateCustomer(customerId,obj);
    }
   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
    }*/
	}

   



