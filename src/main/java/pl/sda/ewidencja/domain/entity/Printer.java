package pl.sda.ewidencja.domain.entity;

import javax.persistence.*;

@Entity
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marka;
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name="printer_id")
    private Employee employee;


    public Printer(String marka, String serialNumber, Employee employee) {
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.employee = employee;
    }

    public Printer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
