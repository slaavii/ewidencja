package pl.sda.ewidencja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(value = "/employee")
    public ModelAndView costsPage() {
        ModelAndView mav = new ModelAndView("employee");
        mav.addObject("employee", service.getAll());
        return mav;
    }

}
