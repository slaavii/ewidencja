package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.EmployeeDTO;
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
                .map(printer -> new PrinterDTO(
                        printer.getId(),
                        printer.getMarka(),
                        printer.getSerialNumber()))
                .collect(Collectors.toList());
    }

    public List<PrinterDTO> getOne(Long empId) {
        Employee employeeRepositoryOne = employeeRepository.getOne(empId);
        return employeeRepositoryOne
                .getPrinters()
                .stream()
                .map(printer -> new PrinterDTO(
                        printer.getId(),
                        printer.getMarka(),
                        printer.getSerialNumber()))
                .collect(Collectors.toList());
    }

    public void addPrinter(PrinterDTO printerDTO_form, Long employeeId) {
        Employee employeeRepositoryById = employeeRepository.findById(employeeId).orElse(null);

        Printer printer = new Printer(printerDTO_form);
        printer.setEmployee(employeeRepositoryById);
        Long existId = printer.getId();
        if(printerRepository.existsById(existId)) {
            deletePrinter(existId);
        }
        printerRepository.save(printer);
    }
    public void deletePrinter(Long compId) {
        printerRepository.deleteById(compId);
    }
    public PrinterDTO editOne(Long printId) {
        return printerRepository
                .findById(printId)
                .map(printer -> new PrinterDTO(
                        printer.getId(),
                        printer.getMarka(),
                        printer.getSerialNumber(),
                        new EmployeeDTO(printer.getEmployee())))
                .orElse(null);
    }

}

