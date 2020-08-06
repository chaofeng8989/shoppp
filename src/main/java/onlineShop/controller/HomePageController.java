
package onlineShop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
    @GetMapping(value = "/test1")

    public ResponseEntity test1() {

        return ResponseEntity.ok("Role + login");
    }

    @GetMapping(value = "/test2")
    public ResponseEntity test2() {

        Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        System.out.println(((UserDetails)principal). getUsername());
        return ResponseEntity.ok("ADMIN _ login");
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResponseEntity sayIndex() {
        System.out.println("in   say index");
        return ResponseEntity.ok("asdfasf");
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        if (error != null) {
            modelAndView.addObject("error", "Invalid username and Password");
        }

        if (logout != null) {
            modelAndView.addObject("logout", "You have logged out successfully");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String sayAbout() {
        return "aboutUs";
    }
}
