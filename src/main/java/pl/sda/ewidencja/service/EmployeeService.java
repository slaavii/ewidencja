package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.EmployeeDTO;
import java.util.List;
import java.util.stream.Collectors;

import pl.sda.ewidencja.domain.entity.Employee;
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

    public EmployeeDTO getOne(Long id) {
        return employeeRepository.findById(id)
                .map(EmployeeDTO::new)
                .orElse(null);
    }

    public EmployeeDTO getByLocation(String location) {
        return employeeRepository.findByLocation(location)
                .map(EmployeeDTO::new)
                .orElse(null);
    }

    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(),employeeDTO.getSurname(),employeeDTO.getPosition(),
                employeeDTO.getLocation());
        employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
