package pl.sda.ewidencja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.service.ComputerService;
import pl.sda.ewidencja.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/computer")
public class ComputerController {
    private final ComputerService computerService;
    private final EmployeeService employeeService;

    public ComputerController(ComputerService computerService, EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.computerService = computerService;
    }

    @GetMapping("/listAll")
    @ResponseBody
    public List<ComputerDTO> list() {
        return computerService.getAll();
    }

    @GetMapping("/list")
    public ModelAndView computerListAll() {
        ModelAndView mav = new ModelAndView("computer");
        mav.addObject("computer", computerService.getAll());
        return mav;
    }

    @GetMapping("/list/{employeeId}")
    public ModelAndView computerListOne(@PathVariable("employeeId") Long empId) {
        ModelAndView mav = new ModelAndView("computerEmployee");
        mav.addObject("computer", computerService.getOne(empId));
        mav.addObject("employee", employeeService.getOne(empId));
        return mav;
    }

    @GetMapping(value = "/computer/add")
    public String addComp(Model model) {
        model.addAttribute("newComp", new ComputerDTO());
        return "addComputer";
    }

    @GetMapping("/add/{id}")
    public String addCompOne(Model model, @PathVariable("id") Long employeeId) {
        model.addAttribute("newComputer", new ComputerDTO());
        model.addAttribute("employeeId", employeeId);
        //model.addAttribute("types", Type.values());
        return "computerEdit";
    }

    @PostMapping("/edited/{employeeId}")
    public String saveComp(@PathVariable("employeeId") Long employeeId, @ModelAttribute("newComputer") ComputerDTO form,
                           BindingResult result, Model model) {
        if (!result.hasErrors()) {
            computerService.addComp(form, employeeId);
        }
        return "redirect:/employee/list";
    }
    @GetMapping(value = "/delete")
    public String deleteComp(@RequestParam(name = "computerId") String id) {
        computerService.deleteComp(Long.valueOf(id));
        return "redirect:/employee/list";
    }
}