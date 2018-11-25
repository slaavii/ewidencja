package pl.sda.ewidencja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.enums.Type;
import pl.sda.ewidencja.service.ComputerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/computer")
public class ComputerController {
    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<ComputerDTO> list() {
        return computerService.getAll();
    }


    @GetMapping("/add/{id}")
    public String addComp(Model model, @PathVariable("id") Long employeeId) {
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
}