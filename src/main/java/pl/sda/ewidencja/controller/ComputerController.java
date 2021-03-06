package pl.sda.ewidencja.controller;

import org.springframework.http.HttpMethod;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.service.ComputerService;
import pl.sda.ewidencja.service.EmployeeService;

import java.util.List;
@PreAuthorize("isAuthenticated()")
@Controller
@RequestMapping("/computer")

public class ComputerController {
    private final ComputerService computerService;
    private final EmployeeService employeeService;

    public ComputerController(ComputerService computerService, EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.computerService = computerService;
    }

    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
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

//    @GetMapping(value = "/computer/add")
//    public String addComp(Model model) {
//        model.addAttribute("newComp", new ComputerDTO());
//        return "addComputer";
//    }

    @GetMapping("/add/{id}")
    public String addCompOne(Model model, @PathVariable("id") Long employeeId) {
        ComputerDTO computerDTO = new ComputerDTO();
        computerDTO.setId(employeeId);
        model.addAttribute("newComputer", computerDTO);
        model.addAttribute("employeeId", employeeId);
        return "computerEdit";
    }

    @PostMapping("/edited/{employeeId}")
    public String saveComp(@PathVariable("employeeId") Long employeeId, @ModelAttribute("newComputer") ComputerDTO form,
                           BindingResult result, Model model) {
            computerService.addComp(form, employeeId);
            return "redirect:/employee/list";
    }

    @PostMapping("/edited")
    public String saveCompEdited(@ModelAttribute("newComputer") ComputerDTO form,
                           BindingResult result, Model model) {
        if (!result.hasErrors()) {
            computerService.addComp(form, form.getEmployee().getId());
        }
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/delete")
    public String deleteComp(@RequestParam(name = "computerId") Long id) {
        computerService.deleteComp(id);
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editComp(@RequestParam(name = "computerId") Long compId) {
        ModelAndView mav = new ModelAndView("computerEdit");
        mav.addObject("newComputer", computerService.editOne(compId));
        return mav;
    }
}