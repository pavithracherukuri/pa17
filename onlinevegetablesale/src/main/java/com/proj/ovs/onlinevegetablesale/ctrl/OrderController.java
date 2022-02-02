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
import com.proj.ovs.onlinevegetablesale.entity.Order;
import com.proj.ovs.onlinevegetablesale.service.OrderService;

@RestController
public class OrderController {
@Autowired
	OrderService orderService;
    @PostMapping("/orders")
    public Order order(@Valid@RequestBody Order order)
    {
    	return orderService.addOrder(order);
    }
    @GetMapping("/orders")
    public List<Order> getOrder()
    {
    	return orderService.getOrder();
    }
    @DeleteMapping("/orders")
    public boolean deleteAllOrder()
    {
    	return orderService.deleteAllOrder();
    }
    @PutMapping("/orders/{orderId}")
    public Order updateOrder(@PathVariable int orderId,@RequestBody Order obj)
    {
    	return orderService.updateOrder(orderId,obj);
    }
    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
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
  

