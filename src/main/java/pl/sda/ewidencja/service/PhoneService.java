package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.EmployeeDTO;
import pl.sda.ewidencja.domain.dto.PhoneDTO;
import pl.sda.ewidencja.domain.dto.PrinterDTO;
import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Employee;
import pl.sda.ewidencja.domain.entity.Phone;
import pl.sda.ewidencja.domain.entity.Printer;
import pl.sda.ewidencja.repository.EmployeeRepository;
import pl.sda.ewidencja.repository.PhoneRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;
    private final EmployeeRepository employeeRepository;

    public PhoneService(PhoneRepository phoneRepository, EmployeeRepository employeeRepository) {
        this.phoneRepository = phoneRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<PhoneDTO> getAll(){
        return phoneRepository.findAll().stream()
                .map(phone -> new PhoneDTO(
                        phone.getId(),
                        phone.getMarka(),
                        phone.getSerialNumber()))
                .collect(Collectors.toList());
    }

    public List<PhoneDTO> getOne(Long empId) {
        Employee employeeRepositoryOne = employeeRepository.getOne(empId);
        return employeeRepositoryOne
                .getPhones()
                .stream()
                .map(phone -> new PhoneDTO(
                        phone.getId(),
                        phone.getMarka(),
                        phone.getSerialNumber()))
                .collect(Collectors.toList());
    }

    public void addPhone(PhoneDTO phoneDTO_form, Long employeeId) {
        Employee employeeRepositoryById = employeeRepository.findById(employeeId).orElse(null);

        Phone phone = new Phone(phoneDTO_form);
        phone.setEmployee(employeeRepositoryById);
        Long existId = phone.getId();
        if(phoneRepository.existsById(existId)) {
            deletePhone(existId);
        }
        phoneRepository.save(phone);
    }
    public void deletePhone(Long phoneId) {
        phoneRepository.deleteById(phoneId);
    }
    public PhoneDTO editOne(Long phoneId) {
        return phoneRepository
                .findById(phoneId)
                .map(phone -> new PhoneDTO(
                        phone.getId(),
                        phone.getMarka(),
                        phone.getSerialNumber(),
                        new EmployeeDTO(phone.getEmployee())))
                .orElse(null);
    }
}
