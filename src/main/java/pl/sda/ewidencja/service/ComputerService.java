package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Employee;
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

    public List<ComputerDTO> getAll() {
        return computerRepository.findAll().stream()
                .map(com->new ComputerDTO(
                        com.getTyp(),com.getMarka(),
                        com.getSerialNumber(),
                        com.getOperatingSystem(),
                        com.getIpAddress()))
                .collect(Collectors.toList());
    }

    public ComputerDTO getComputerBySerialNumber(String serialNumber) {
        return computerRepository.findBySerialNumber(serialNumber)
                .map(com->new ComputerDTO(
                        com.getTyp(),com.getMarka(),
                        com.getSerialNumber(),
                        com.getOperatingSystem(),
                        com.getIpAddress()))
                .orElse(null);
    }

    //@Transactional
    public void addComp(ComputerDTO computerDTO_form, Long employeeId) {
        Employee employeeRepositoryById = employeeRepository.findById(employeeId).orElse(null);

        Computer computer = new Computer(computerDTO_form);
        computer.setEmployee(employeeRepositoryById);
        computerRepository.save(computer);
    }

}

