package pl.sda.ewidencja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.EmployeeDTO;
import pl.sda.ewidencja.service.EmployeeService;

import javax.annotation.PostConstruct;
import java.util.List;
@PreAuthorize("isAuthenticated()")
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/listAll")
    @ResponseBody
    public List<EmployeeDTO> list() {
        return service.getAll();
    }

    @GetMapping("/list")
    public ModelAndView employeeList() {
        ModelAndView mav = new ModelAndView("employee");
        mav.addObject("employee", service.getAll());
        return mav;
    }
}
