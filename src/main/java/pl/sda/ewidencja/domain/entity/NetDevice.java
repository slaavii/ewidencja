package pl.sda.ewidencja.domain.entity;

import javax.persistence.*;

@Entity
public class NetDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Enum typ;
    private String marka;
    private String serialNumber;
    private int numberOfPorts;
    private String localization;

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

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public String getLocalization() {
        return localization;
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

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }
}