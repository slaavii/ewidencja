package pl.sda.ewidencja.domain.entity;

import pl.sda.ewidencja.domain.dto.ComputerDTO;
import pl.sda.ewidencja.domain.enums.Type;
import javax.persistence.*;

@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type typ;
    private String marka;
    private String serialNumber;
    private String operatingSystem;
    private String ipAddress;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Computer(ComputerDTO dto) {
        this(dto.getId(),
                dto.getTyp(),
                dto.getMarka(),
                dto.getSerialNumber(),
                dto.getOperatingSystem(),
                dto.getIpAddress(),
                new Employee(dto.getEmployee()));
    }

    public Computer(Long id, Type typ, String marka, String serialNumber, String operatingSystem, String ipAddress, Employee employee) {
        this.id = id;
        this.typ = typ;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.operatingSystem = operatingSystem;
        this.ipAddress = ipAddress;
        this.employee = employee;
    }

    public Computer() {
    }

    public Long getId() {
        return id;
    }

    public Type getTyp() {
        return typ;
    }

    public String getMarka() {
        return marka;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTyp(Type typ) {
        this.typ = typ;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
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


