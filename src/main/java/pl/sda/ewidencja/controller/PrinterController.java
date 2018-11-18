package pl.sda.ewidencja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.PrinterDTO;
import pl.sda.ewidencja.service.ComputerService;

import java.util.Set;

@Controller
@RequestMapping("/printer")
public class PrinterController {
    private final PrinterController printerController;

    public PrinterController(PrinterController printerController){
    this.printerController=printerController;}
}

