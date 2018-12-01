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