package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.enums.Type;

public class ComputerDTO {
    private Long id;
    private Type typ;
    private String marka;
    private String serialNumber;
    private String operatingSystem;
    private String ipAddress;
    private EmployeeDTO employee;

    public ComputerDTO(Computer computer) {
        this(computer.getId(),computer.getTyp(),computer.getMarka(),computer.getSerialNumber(),
                computer.getOperatingSystem(),computer.getIpAddress(),
                computer.getEmployee() == null ? null : new EmployeeDTO(computer.getEmployee()));
    }

    public ComputerDTO() {
    }

    public ComputerDTO(Long id, Type typ, String marka, String serialNumber, String operatingSystem, String ipAddress) {
        this.id = id;
        this.typ = typ;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.operatingSystem = operatingSystem;
        this.ipAddress = ipAddress;
    }

    public ComputerDTO(Long id, Type typ, String marka, String serialNumber, String operatingSystem, String ipAddress, EmployeeDTO employee) {
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

    public Type getTyp() {
        return typ;
    }

    public void setTyp(Type typ) {
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

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

}
