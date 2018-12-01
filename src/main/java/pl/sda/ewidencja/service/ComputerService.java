package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.EmployeeDTO;
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
                .map(ComputerDTO::new)
                .collect(Collectors.toList());
    }

    public List<ComputerDTO> getOne(Long empId) {
        Employee employeeRepositoryOne = employeeRepository.getOne(empId);
        return employeeRepositoryOne
                .getComputers()
                .stream()
                .map(computer -> new ComputerDTO(
                        computer.getId(),
                        computer.getTyp(),
                        computer.getMarka(),
                        computer.getSerialNumber(),
                        computer.getOperatingSystem(),
                        computer.getIpAddress()))
                .collect(Collectors.toList());
    }

    public ComputerDTO editOne(Long compId) {
        return computerRepository
                .findById(compId)
                .map(computer -> new ComputerDTO(
                        computer.getId(),
                        computer.getTyp(),
                        computer.getMarka(),
                        computer.getSerialNumber(),
                        computer.getOperatingSystem(),
                        computer.getIpAddress(),
                        new EmployeeDTO(computer.getEmployee())))
                .orElse(null);
    }

    public ComputerDTO getComputerBySerialNumber(String serialNumber) {
        return computerRepository.findBySerialNumber(serialNumber)
                .map(ComputerDTO::new)
                .orElse(null);
    }

    //@Transactional
    public void addComp(ComputerDTO computerDTO_form, Long employeeId) {
        Employee employeeRepositoryById = employeeRepository.findById(employeeId).orElse(null);

        Computer computer = new Computer(computerDTO_form);
        computer.setEmployee(employeeRepositoryById);
        Long existId = computer.getId();
        if(computerRepository.existsById(existId)) {
            deleteComp(existId);
        }
        computerRepository.save(computer);
    }

    public void deleteComp(Long compId) {
        computerRepository.deleteById(compId);
    }

}

