
package pl.sda.ewidencja.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.domain.dto.PhoneDTO;
import pl.sda.ewidencja.domain.dto.PrinterDTO;
import pl.sda.ewidencja.service.EmployeeService;
import pl.sda.ewidencja.service.PhoneService;

import java.util.List;

@Controller
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService;
    private final EmployeeService employeeService;

    public PhoneController(PhoneService phoneService, EmployeeService employeeService) {
        this.phoneService = phoneService;
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public ModelAndView phoneList(){
        ModelAndView mav = new ModelAndView("phone");
        mav.addObject("phone", phoneService.getAll());
        return mav;
    }

    @GetMapping("/list/{employeeId}")
    public ModelAndView phoneListOne(@PathVariable("employeeId") Long empId) {
        ModelAndView mav = new ModelAndView("phoneEmployee");
        mav.addObject("phone", phoneService.getOne(empId));
        mav.addObject("employee", employeeService.getOne(empId));
        return mav;
    }

    @GetMapping("/add/{id}")
    public String addPhoneOne(Model model, @PathVariable("id") Long employeeId) {
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(employeeId);
        model.addAttribute("newPhone", phoneDTO);
        model.addAttribute("employeeId", employeeId);
        return "phoneEdit";
    }

    @PostMapping("/edited/{employeeId}")
    public String saveComp(@PathVariable("employeeId") Long employeeId, @ModelAttribute("newPhone") PhoneDTO form,
                           BindingResult result, Model model) {
        phoneService.addPhone(form, employeeId);
        return "redirect:/employee/list";
    }

    @PostMapping("/edited")
    public String saveCompEdited(@ModelAttribute("newPhone") PhoneDTO form,
                                 BindingResult result, Model model) {
        phoneService.addPhone(form, form.getEmployee().getId());
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/delete")
    public String deleteComp(@RequestParam(name = "phoneId") Long id) {
        phoneService.deletePhone(id);
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editComp(@RequestParam(name = "phoneId") Long compId) {
        ModelAndView mav = new ModelAndView("phoneEdit");
        mav.addObject("newPhone", phoneService.editOne(compId));
        return mav;
    }
}

