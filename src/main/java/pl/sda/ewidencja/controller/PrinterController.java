package pl.sda.ewidencja.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.PhoneDTO;
import pl.sda.ewidencja.domain.dto.PrinterDTO;
import pl.sda.ewidencja.service.ComputerService;
import pl.sda.ewidencja.service.EmployeeService;
import pl.sda.ewidencja.service.PrinterService;

import java.util.List;
import java.util.Set;
@PreAuthorize("isAuthenticated()")
@Controller
@RequestMapping("/printer")
public class PrinterController {

    private final PrinterService printerService;
    private final EmployeeService employeeService;

    public PrinterController(PrinterService printerService, EmployeeService employeeService) {
        this.printerService = printerService;
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public ModelAndView printerList(){
        ModelAndView mav = new ModelAndView("printer");
        mav.addObject("printer", printerService.getAll());
        return mav;
    }

    @GetMapping("/list/{employeeId}")
    public ModelAndView printerListOne(@PathVariable("employeeId") Long empId) {
        ModelAndView mav = new ModelAndView("printerEmployee");
        mav.addObject("printer", printerService.getOne(empId));
        mav.addObject("employee", employeeService.getOne(empId));
        return mav;
    }

    @GetMapping("/add/{id}")
    public String addPrinterOne(Model model, @PathVariable("id") Long employeeId) {
        PrinterDTO printerDTO = new PrinterDTO();
        printerDTO.setId(employeeId);
        model.addAttribute("newPrinter", printerDTO);
        model.addAttribute("employeeId", employeeId);
        return "printerEdit";
    }

    @PostMapping("/edited/{employeeId}")
    public String saveComp(@PathVariable("employeeId") Long employeeId, @ModelAttribute("newPrinter") PrinterDTO form,
                           BindingResult result, Model model) {
        printerService.addPrinter(form, employeeId);
        return "redirect:/employee/list";
    }

    @PostMapping("/edited")
    public String saveCompEdited(@ModelAttribute("newPrinter") PrinterDTO form,
                                 BindingResult result, Model model) {
            printerService.addPrinter(form, form.getEmployee().getId());
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/delete")
    public String deleteComp(@RequestParam(name = "printerId") Long id) {
        printerService.deletePrinter(id);
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editComp(@RequestParam(name = "printerId") Long compId) {
        ModelAndView mav = new ModelAndView("printerEdit");
        mav.addObject("newPrinter", printerService.editOne(compId));
        return mav;
    }
}


