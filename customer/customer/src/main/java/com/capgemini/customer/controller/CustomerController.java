package com.capgemini.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.exception.FailedtoAuthenticateException;
import com.capgemini.customer.service.CustomerService;

@RestController
	public class CustomerController {

		@Autowired
		private CustomerService customerService;
		
		@PostMapping("/Customer")
		public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
		return responseEntity;
		}
		
		@PutMapping("/Customer")
		public ResponseEntity<Customer> upadteCustomer(@RequestBody Customer customer){
			ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(customerService.updateCustomer(customer),HttpStatus.OK);
			return responseEntity;
		}
			
		@GetMapping("/Customers/{customerId}")
		public ResponseEntity<Customer>findCustomerById(@PathVariable int customerId){
			try {
			Customer customerFromDb= customerService.findCustomerById(customerId);
					return new ResponseEntity<Customer>(customerFromDb, HttpStatus.OK);
			}catch(CustomerNotFoundException exception) {
				
			}
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			}
		
		@DeleteMapping("/Customer/{customerId}")
		public ResponseEntity<Customer>deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException{
			Customer customerFromDb= 
					customerService.findCustomerById(customerId);
			if(customerFromDb != null) {
				customerService.deleteCustomer(customerFromDb);
				return new ResponseEntity<Customer>(HttpStatus.OK);
		}
			throw new CustomerNotFoundException("Deletion failed , Customer does not exist");
		}
		
		@PostMapping("/login")
		public ResponseEntity<Customer> authenticateCustomer(@RequestBody Customer customer) throws FailedtoAuthenticateException, CustomerNotFoundException{
			
			Customer customer1 = customerService.AuthenticateCustomer(customer);
			if (customer1 != null)
				return new ResponseEntity<Customer>(customerService.AuthenticateCustomer(customer), HttpStatus.OK);

			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		
		}
	}



