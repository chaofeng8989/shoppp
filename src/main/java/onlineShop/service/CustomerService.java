package onlineShop.service;

import onlineShop.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Transactional
    public void addCustomer(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(customer.getUser().getEmailId());


        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);
        customer.getUser().setEnabled(true);


        customerRepository.save(customer);
        authoritiesRepository.save(authorities);
        cartRepository.save(cart);
        // no need to save user/cart, (cascade = CascadeType.ALL)
        //userRepository.save(user);
        //cartRepository.save(cart);
    }

    public Customer getCustomerByUserName(String userName) {
        User user = userRepository.getByEmailId(userName);
        Customer customer = customerRepository.getCustomerByUser(user);



        return customer;
    }

}
