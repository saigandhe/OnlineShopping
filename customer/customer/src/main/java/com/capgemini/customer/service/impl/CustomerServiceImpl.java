package com.capgemini.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.exception.FailedtoAuthenticateException;
import com.capgemini.customer.repository.CustomerRepository;
import com.capgemini.customer.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService   {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer AuthenticateCustomer(Customer customer)throws CustomerNotFoundException, FailedtoAuthenticateException {

		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		
		if (optionalCustomer.isPresent()) {
			
			if (optionalCustomer.get().getPassword().equals(customer.getPassword())) {
				return optionalCustomer.get();
			} else {
				throw new FailedtoAuthenticateException("Authentication Failed");
			}
		}
		throw new CustomerNotFoundException("Customer dosen't exist");
	}
	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}


	@Override
	public Customer findCustomerById(int customerId) throws CustomerNotFoundException {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		
		if (optionalCustomer.isPresent())
			return optionalCustomer.get();
		
		throw new CustomerNotFoundException("Customer Not Found");
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		return customerRepository.save(customer);
	}



	@Override
	public void deleteCustomer(Customer customer) {

		customerRepository.delete(customer);
	}


	@Override
	public List<Customer> getAllCustomers() {
	
		return customerRepository.findAll();
	}

	

}
