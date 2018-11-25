package pl.sda.ewidencja.service;

import org.springframework.stereotype.Service;
import pl.sda.ewidencja.domain.dto.NetDeviceDTO;
import pl.sda.ewidencja.domain.entity.NetDevice;
import pl.sda.ewidencja.repository.EmployeeRepository;
import pl.sda.ewidencja.repository.NetDeviceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NetDeviceService {
    private final NetDeviceRepository netDeviceRepository;
    private final EmployeeRepository employeeRepository;

    public NetDeviceService(NetDeviceRepository netDeviceRepository, EmployeeRepository employeeRepository){
        this.netDeviceRepository = netDeviceRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<NetDeviceDTO> getAll() {
        return netDeviceRepository.findAll().stream()
                .map(NetDeviceDTO::new)
                .collect(Collectors.toList());

    }

    public void addNetDevice(NetDeviceDTO form) {
    }
}
/*@Service
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
}*/
