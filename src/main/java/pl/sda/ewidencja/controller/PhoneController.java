
package pl.sda.ewidencja.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.ewidencja.domain.dto.PhoneDTO;
import pl.sda.ewidencja.service.PhoneService;

import java.util.List;

@Controller
@RequestMapping("/phone")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/listAll")
    @ResponseBody
    public List<PhoneDTO> list(){
        return phoneService.getAll();
    }

    @GetMapping("/list")
    public ModelAndView phoneList(){
        ModelAndView mav = new ModelAndView("phone");
        mav.addObject("phone",phoneService.getAll());
        return mav;
    }


    @GetMapping(value = "phone/add")
    public String addPhone(Model model){
        model.addAttribute("newPhone",new PhoneDTO());
        return "addPhone";
    }

    @GetMapping("/add")
    public String addCost(Model model){
        model.addAttribute("newPhone",new PhoneDTO());
        return "phoneEdit";
    }
    @PostMapping("/add")
    public String savePhone(@ModelAttribute("newPhone") PhoneDTO form,
                            BindingResult result, Model model){
        if (!result.hasErrors()){
            phoneService.addPhone(form);
        }
        return "redirect:../employee";
    }
}

