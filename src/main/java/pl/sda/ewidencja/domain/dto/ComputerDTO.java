package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Employee;
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ComputerDTO{" +
                "id=" + id +
                ", typ=" + typ +
                ", marka='" + marka + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", employee=" + employee +
                '}';
    }
}
