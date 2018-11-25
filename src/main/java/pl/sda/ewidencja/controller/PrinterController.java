package pl.sda.ewidencja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.PhoneDTO;
import pl.sda.ewidencja.domain.dto.PrinterDTO;
import pl.sda.ewidencja.service.ComputerService;
import pl.sda.ewidencja.service.PrinterService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/printer")
public class PrinterController {

    private final PrinterService printerService;

    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<PrinterDTO> list() {
        return printerService.getAll();
    }

    @GetMapping(value = "printer/add")
    public String addPhone(Model model) {
        model.addAttribute("newPhone", new PhoneDTO());
        return "addPrinter";
    }

    @GetMapping("/add")
    public String addCost(Model model) {
        model.addAttribute("newPrinter", new PrinterDTO());
        return "printerEdit";
    }

    @PostMapping("/add")
    public String savePrinter(@ModelAttribute("newPrinter") PrinterDTO form,
                              BindingResult result, Model model) {
        if (!result.hasErrors()) {
            printerService.addPrinter(form);
        }
        return "redirect:../employee";
    }
}


