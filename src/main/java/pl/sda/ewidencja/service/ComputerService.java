package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.repository.ComputerRepository;
import pl.sda.ewidencja.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerService {
    private final ComputerRepository computerRepository;
    private final EmployeeRepository employeeRepository;

    public ComputerService(ComputerRepository computerRepository, EmployeeRepository employeeRepository) {
        this.computerRepository = computerRepository;
        this.employeeRepository = employeeRepository;
    }

  /*  public List<ComputerDTO> list() {
        return computerRepository.findAll().stream()
                .map(ComputerDTO::new)
                .collect(Collectors.toList());
    }*/

    public List<ComputerDTO> getAll() {
        return computerRepository.findAll().stream()
                .map(ComputerDTO::new)
                .collect(Collectors.toList());
    }

     /*public ComputerDTO getComputerBySerialNumber(String serialNumber){
        return computerRepository.findBySerialNumber(serialNumber).map(a-> new ComputerDTO(a.getTyp().name(),
                a.getMarka(),a.getSerialNumber(),a.getOperatingSystem(),a.getIpAddress(),
                a.getEmployee())).orElse(null);*/

    public ComputerDTO getComputerBySerialNumber(String serialNumber) {
        return computerRepository.findBySerialNumber(serialNumber)
                .map(ComputerDTO::new).orElse(null);
    }
}

