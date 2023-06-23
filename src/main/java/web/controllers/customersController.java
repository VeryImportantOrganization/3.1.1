package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Customer;
import web.service.CustomersService;

@Controller
@RequestMapping("/customers")
public class customersController {
    private final CustomersService customersService;

    public customersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public String usersList(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("userList", this.customersService.usersList());
        return "customers";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("customer") Customer customer) {
        customersService.addUser(customer);
        return null;
    }
}
