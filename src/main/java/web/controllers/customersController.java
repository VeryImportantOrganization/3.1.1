package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Customer;
import web.service.CustomersService;

@Controller
@RequestMapping("/customers")
public class customersController {
    private final CustomersService customersService;

    public customersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping()
    public String usersList(Model model) {
        model.addAttribute("customer", customersService.usersList());
        return "start";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("customer", customersService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String creationUser(@ModelAttribute("customer") Customer customer) {
        return "new";
    }

    @PostMapping
    public String addUser(@ModelAttribute("customer") Customer customer) {
        customersService.addUser(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String editionUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("customer", customersService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("customer") Customer customer) {
        customersService.editUser(customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}/delete")
    public String removeUser(@PathVariable("id") long id) {
        customersService.removeUser(id);
        return "redirect:/customers";
    }
}
