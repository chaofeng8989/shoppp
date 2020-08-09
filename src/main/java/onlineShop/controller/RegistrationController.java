package onlineShop.controller;

import onlineShop.model.BillingAddress;
import onlineShop.model.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import onlineShop.model.Customer;
import onlineShop.service.CustomerService;

@Controller
public class RegistrationController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/registration", method = RequestMethod.GET)
    public ModelAndView getRegistrationForm() {
        Customer customer = new Customer();
        return new ModelAndView("register", "customer", customer);
    }

    @RequestMapping(value = "/customer/registration", method = RequestMethod.POST)
    public ModelAndView registerCustomer(@ModelAttribute(value = "customer") Customer customer,
                                         BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("register");
            return modelAndView;
        }

        customerService.addCustomer(customer);
        modelAndView.setViewName("login");
        modelAndView.addObject("registrationSuccess", "Registered Successfully. Login using username and password");
        return modelAndView;
    }

    @PostMapping(value = "login_rest", consumes = "application/json")
    public ResponseEntity login_rest() {
        return ResponseEntity.ok("ok");
    }

    @PostMapping(value = "register_rest", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity restRegister(@RequestBody Customer customer) {
        System.out.println(customer);
        customerService.addCustomer(customer);
        return ResponseEntity.ok("ok");
    }
}
