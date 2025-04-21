package dev.rikthipranadhik.storemanagementsystembackend.service.customer.impl;

import dev.rikthipranadhik.storemanagementsystembackend.entity.Customer.Customer;
import dev.rikthipranadhik.storemanagementsystembackend.entity.Customer.Receipt;
import dev.rikthipranadhik.storemanagementsystembackend.entity.store.Store;
import dev.rikthipranadhik.storemanagementsystembackend.repository.customer.CustomerRepository;
import dev.rikthipranadhik.storemanagementsystembackend.repository.customer.ReceiptRepository;
import dev.rikthipranadhik.storemanagementsystembackend.repository.store.StoreRepository;
import dev.rikthipranadhik.storemanagementsystembackend.service.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private StoreRepository storeRepository;
    private ReceiptRepository receiptRepository;

    @Override
    public Customer createCustomer(Customer customer, Long storeId) {
        if (customer.getId() != null){
            throw new IllegalArgumentException("Customer ID must be null");
        }

        Store store = storeRepository.findById(storeId).orElseThrow(()-> new IllegalArgumentException("Store ID not found"));
        customer.setStore(store);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {

    }

    @Override
    public List<Customer> listAllCustomers(Long storeId) {
        return List.of();
    }

    @Override
    public Receipt createReceipt(Receipt receipt, Long customerId) {
        return null;
    }

    @Override
    public Receipt updateReceipt(Receipt receipt) {
        return null;
    }

    @Override
    public void deleteReceipt(Long customerId) {

    }

    @Override
    public List<Receipt> listAllReceipts(Long storeId) {
        return List.of();
    }

    @Override
    public List<Receipt> listReceiptsByCustomerId(Long customerId) {
        return List.of();
    }
}
