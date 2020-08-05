package onlineShop.service;

import onlineShop.model.Customer;
import onlineShop.model.CustomerRepository;
import onlineShop.model.User;
import onlineShop.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerByUserName(String userName) {
        User user = userRepository.getByEmailId(userName);
        return customerRepository.getCustomerByUser(user);
    }

}
