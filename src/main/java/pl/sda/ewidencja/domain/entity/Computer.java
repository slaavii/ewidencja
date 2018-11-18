package pl.sda.ewidencja.domain.entity;

import pl.sda.ewidencja.domain.enums.Type;

import javax.persistence.*;

@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type typ;
    private String marka;
    private String serialNumber;
    private String operatingSystem;
    // private String localization;
    private String ipAddress;
    @ManyToOne
    @JoinColumn(name="computer_id")
    private Employee employee;

    public Computer(Type typ, String marka, String serialNumber, String operatingSystem, String ipAddress, Employee employee) {
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

    public Enum getTyp() {
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

    /*public String getLocalization() {
        return localization;
    }*/

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

    /*public void setLocalization(String localization) {
        this.localization = localization;
    }*/

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Employee getEmployee() {
        return employee;
    }
}


