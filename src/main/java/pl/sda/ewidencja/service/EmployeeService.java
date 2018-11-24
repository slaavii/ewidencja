package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.EmployeeDTO;
import pl.sda.ewidencja.domain.entity.Employee;
import java.util.List;
import java.util.stream.Collectors;
import pl.sda.ewidencja.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getBySurname(String surname) {
        return employeeRepository.findBySurname(surname)
                .map(EmployeeDTO::new)
                .orElse(null);
    }

    public EmployeeDTO getByLocation(String location) {
        return employeeRepository.findByLocation(location)
                .map(EmployeeDTO::new)
                .orElse(null);
    }

//    public void addEmployee(EmployeeDTO employeeDTO) {
//        Employee employee = new Employee(employeeDTO.getName(),
//                employeeDTO.getSurname(),
//                employeeDTO.getPosition(),
//                null,
//                null,
//                null,
//                employeeDTO.getLocation());
//        employeeRepository.save(employee);
//
//    }

}
