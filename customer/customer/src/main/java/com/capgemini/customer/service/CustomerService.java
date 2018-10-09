package com.capgemini.customer.service;

import java.util.List;

import com.capgemini.customer.entity.Customer;
import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.exception.FailedtoAuthenticateException;

public interface CustomerService {

	public Customer AuthenticateCustomer(Customer customer)
			throws CustomerNotFoundException, FailedtoAuthenticateException;

	public Customer addCustomer(Customer customer);

	public Customer findCustomerById(int customerId) throws CustomerNotFoundException;

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

	public List<Customer> getAllCustomers();

}
