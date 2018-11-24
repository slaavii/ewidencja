package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Employee;

public class ComputerDTO {
    private Long id;
    private Enum typ;
    private String marka;
    private String serialNumber;
    private String operatingSystem;
    private String ipAddress;
    private EmployeeDTO employee;

//    public ComputerDTO(Computer computer) {
//        this(computer.getId(),computer.getTyp(),computer.getMarka(),computer.getSerialNumber(),
//                computer.getOperatingSystem(),computer.getIpAddress(),computer.getEmployee());
//    }

    public ComputerDTO() {
    }

    public ComputerDTO(Long id, Enum typ, String marka, String serialNumber, String operatingSystem, String ipAddress, EmployeeDTO employee) {
        this.id = id;
        this.typ = typ;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.operatingSystem = operatingSystem;
        this.ipAddress = ipAddress;
        this.employee = employee;
    }

    public ComputerDTO(Long id, Enum typ, String marka, String serialNumber, String operatingSystem, String ipAddress) {
        this.id = id;
        this.typ = typ;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.operatingSystem = operatingSystem;
        this.ipAddress = ipAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum getTyp() {
        return typ;
    }

    public void setTyp(Enum typ) {
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
