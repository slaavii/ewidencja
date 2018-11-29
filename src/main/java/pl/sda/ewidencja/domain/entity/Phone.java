package pl.sda.ewidencja.domain.entity;

import pl.sda.ewidencja.domain.dto.PhoneDTO;
import pl.sda.ewidencja.domain.dto.PrinterDTO;

import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String marka;
    private String serialNumber;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Phone(Long id, String marka, String serialNumber, Employee employee) {
        this.id = id;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.employee = employee;
    }

    public Phone() {
    }

    public Phone(PhoneDTO dto) {
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
