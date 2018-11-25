package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.dto.PhoneDTO;
import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Phone;
import pl.sda.ewidencja.repository.EmployeeRepository;
import pl.sda.ewidencja.repository.PhoneRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository, EmployeeRepository employeeRepository) {
        this.phoneRepository = phoneRepository;
        this.employeeRepository = employeeRepository;
    }

    private final EmployeeRepository employeeRepository;

    public List<PhoneDTO>getAll(){
        return phoneRepository.findAll().stream()
                .map(PhoneDTO::new)
                .collect(Collectors.toList());
    }

    public PhoneDTO getPhoneBySerialNumber(String serialNumber){
        return phoneRepository.findBySerialNumber(serialNumber)
                .map(PhoneDTO::new)
                .orElse(null);
    }

    public void addPhone(PhoneDTO phoneDTO_form){
        this.phoneRepository.save(new Phone(phoneDTO_form));
    }
}
