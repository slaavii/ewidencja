package pl.sda.ewidencja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

    @GetMapping("/listAll")
    @ResponseBody
    public List<ComputerDTO> list() {
        return computerService.getAll();
    }

    @GetMapping("/list")
    public ModelAndView computerList(){
        ModelAndView mav = new ModelAndView("computer");
        mav.addObject("computer",computerService.getAll());
        return mav;
    }
    @GetMapping(value = "computer/add")
    public String addComp(Model model) {
        model.addAttribute("newComp", new ComputerDTO());
        return "addComputer";
    }

    @GetMapping("/add")
    public String addCost(Model model) {
        model.addAttribute("newComputer", new ComputerDTO());
        return "computerEdit";
    }

    @PostMapping("/add")
    public String saveCost(@ModelAttribute("newComputer") ComputerDTO form,
                           BindingResult result, Model model) {

        if (!result.hasErrors()) {
            computerService.addComp(form);
        }

        return "redirect:../employee";
    }
}