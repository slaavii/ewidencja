package pl.sda.ewidencja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.ewidencja.domain.dto.NetDeviceDTO;
import pl.sda.ewidencja.domain.dto.PrinterDTO;
import pl.sda.ewidencja.service.NetDeviceService;

import java.util.List;

@Controller
@RequestMapping("/network")
public class NetDeviceController {

    private final NetDeviceService netDeviceService;

    public NetDeviceController(NetDeviceService netDeviceService){
        this.netDeviceService = netDeviceService;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<NetDeviceDTO>list(){
        return netDeviceService.getAll();
    }

    @GetMapping(value = "phone/add")
    public String addNetDevice(Model model){
        model.addAttribute("newNetDeviceController",new NetDeviceDTO());
        return "addNetDevice";
    }

    @GetMapping("/add")
    public String addCost(Model model){
        model.addAttribute("newNetDevice",new NetDeviceDTO());
        return "NetDeviceEdit";
    }

    @PostMapping("/add")
    public String saveNetDevice(@ModelAttribute("newNetDevice")NetDeviceDTO form,
                                BindingResult result, Model model){
        if(!result.hasErrors()){
            netDeviceService.addNetDevice(form);
        }
        return "redirect:../employee";
    }
}
