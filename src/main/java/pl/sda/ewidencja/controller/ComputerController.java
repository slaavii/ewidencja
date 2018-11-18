package pl.sda.ewidencja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.service.ComputerService;

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

    @GetMapping(value = "computer/add")
    public String addComp(Model model) {
        model.addAttribute("newComp", new ComputerDTO());
        return "addComputer";
    }

    @PostMapping(value = "computer/add")
    public String saveComp(@ModelAttribute("newComp") ComputerDTO form,
                           BindingResult result, Model model) {
        if (!result.hasErrors()) {
            computerService.addComp(form);
        }
        return "redirect:../computer";
    }

    /*@GetMapping(value = "cost/add")
    public String addCost(Model model) {
        model.addAttribute("newCost", new NewCostDto());
        return "edit";
    }

    @PostMapping(value = "cost/add")
    public String saveCost(@ModelAttribute("newCost") NewCostDto form,
                           BindingResult result, Model model) {

        if (!result.hasErrors()) {
            service.addCost(form);
        }

        return "redirect:../costs";
    }*/

    /*@PutMapping("/create")
    @ResponseBody
    public IdDTO create(@ResponseBody ComputerDTO dto){
    }*/


}