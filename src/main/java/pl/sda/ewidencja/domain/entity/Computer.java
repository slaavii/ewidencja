package pl.sda.ewidencja.domain.entity;

import javax.persistence.*;

@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Enum typ;
    private String marka;
    private String serialNumber;
    private String operatingSystem;
    private String localization;
    private String ipAddress;

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

    public String getLocalization() {
        return localization;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTyp(Enum typ) {
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

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}


