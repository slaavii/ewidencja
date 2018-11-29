package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Employee;
import pl.sda.ewidencja.domain.entity.Phone;
import pl.sda.ewidencja.domain.entity.Printer;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PhoneDTO {
    private Long id;
    private String marka;
    private String serialNumber;
    private EmployeeDTO employee;

    public PhoneDTO(Phone phone) {
        this(phone.getId(),
                phone.getMarka(),
                phone.getSerialNumber(),
                phone.getEmployee() == null ? null : new EmployeeDTO(phone.getEmployee()));
    }

    public PhoneDTO(Long id, String marka, String serialNumber, EmployeeDTO employee) {
        this.id = id;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.employee = employee;
    }

    public PhoneDTO() {
    }

    public PhoneDTO(Long id, String marka, String serialNumber) {
        this.id = id;
        this.marka = marka;
        this.serialNumber = serialNumber;
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

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
