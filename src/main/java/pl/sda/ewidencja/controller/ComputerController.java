package pl.sda.ewidencja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /*@PutMapping("/create")
    @ResponseBody
    public IdDTO create(@ResponseBody ComputerDTO dto){
    }*/
}