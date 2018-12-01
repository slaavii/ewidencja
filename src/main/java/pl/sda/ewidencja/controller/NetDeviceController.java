package pl.sda.ewidencja.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.domain.dto.NetDeviceDTO;
import pl.sda.ewidencja.service.NetDeviceService;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@Controller
@RequestMapping("/netdevice")

public class NetDeviceController {

    private final NetDeviceService netDeviceService;

    public NetDeviceController(NetDeviceService netDeviceService){
        this.netDeviceService = netDeviceService;
    }

    @GetMapping("/listAll")
    @ResponseBody
    public List<NetDeviceDTO>list(){
        return netDeviceService.getAll();
    }

    @GetMapping("/list")
    public ModelAndView netDeviceList() {
        ModelAndView mav = new ModelAndView("netdevice");
        mav.addObject("netdevice", netDeviceService.getAll());
        return mav;
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
