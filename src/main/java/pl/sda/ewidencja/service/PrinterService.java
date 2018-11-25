package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.PrinterDTO;
import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Employee;
import pl.sda.ewidencja.domain.entity.Printer;
import pl.sda.ewidencja.repository.ComputerRepository;
import pl.sda.ewidencja.repository.EmployeeRepository;
import pl.sda.ewidencja.repository.PrinterRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PrinterService {
    private final PrinterRepository printerRepository;
    private final EmployeeRepository employeeRepository;

    public PrinterService(PrinterRepository printerRepository, EmployeeRepository employeeRepository){
        this.printerRepository = printerRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<PrinterDTO> getAll(){
        return printerRepository.findAll().stream()
                .map(PrinterDTO::new)
                .collect(Collectors.toList());
    }

    public void addPrinter(PrinterDTO printerDTO_form) {
        this.printerRepository.save(new Printer(printerDTO_form));
    }

    /*public void addComp(ComputerDTO computerDTO_form) {
        this.computerRepository.save(new Computer(computerDTO_form));
    }*/
}

