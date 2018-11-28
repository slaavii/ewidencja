package pl.sda.ewidencja.domain.entity;

import pl.sda.ewidencja.domain.dto.PrinterDTO;
import pl.sda.ewidencja.domain.enums.Type;

import javax.persistence.*;

@Entity
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String marka;
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Printer(Long id, String marka, String serialNumber, Employee employee) {
        this.id = id;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.employee = employee;
    }

    public Printer() {
    }

    public Printer(PrinterDTO dto) {
        this(dto.getId(),dto.getMarka(),dto.getSerialNumber(),null);
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
