package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Employee;

public class ComputerDTO {
    private Long id;
    private String typ;
    private String marka;
    private String serialNumber;
    private String operatingSystem;
    private String ipAddress;
    private Employee employee;

    public ComputerDTO(Computer computer) {
        this(computer.getId(),computer.getTyp().name(),computer.getMarka(),computer.getSerialNumber(),
                computer.getOperatingSystem(),computer.getIpAddress(),computer.getEmployee());
    }

    public ComputerDTO() {
    }

    public ComputerDTO(Long id, String typ, String marka, String serialNumber, String operatingSystem, String ipAddress, Employee employee) {
        this.id = id;
        this.typ = typ;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.operatingSystem = operatingSystem;
        this.ipAddress = ipAddress;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
