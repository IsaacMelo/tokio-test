package com.example.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.api.domain.Address;
import com.example.api.domain.Customer;
import com.example.api.repository.AddessRepository;
import com.example.api.repository.CustomerRepository;
import com.example.api.service.exception.CustomerNotFoundException;

@Service
public class CustomerService {

	private CustomerRepository repository;
	private AddessRepository addressRepository;

	@Autowired
	public CustomerService(CustomerRepository repository, AddessRepository addressRepository) {
		this.repository = repository;
		this.addressRepository = addressRepository;
	}

	public Page<Customer> findAll(int pageNo, int pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		return repository.findAll(paging);
	}

	public Customer findById(Long id) throws CustomerNotFoundException {
		return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException());
	}

	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	public Customer update(Customer customer) throws CustomerNotFoundException {
		checkExistence(customer);
		return repository.save(customer);
	}

	public void remove(Long id) throws CustomerNotFoundException {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new CustomerNotFoundException();
		}
	}

	private void checkExistence(Customer customer) throws CustomerNotFoundException {
		findById(customer.getId());
	}

	public Address saveAddress(Long customerId, Address address) throws CustomerNotFoundException {
		Customer customer = findById(customerId);
		address.setCustomer(customer);

		return addressRepository.save(address);
	}

}
