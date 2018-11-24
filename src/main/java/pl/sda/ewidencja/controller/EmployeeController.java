package pl.sda.ewidencja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.domain.dto.EmployeeDTO;
import pl.sda.ewidencja.service.EmployeeService;

import javax.annotation.PostConstruct;
import java.util.List;

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
    @PostMapping("/add")
    public void employeeAdd()

}
