package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Employee;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PhoneDTO {
    private String marka;
    private String serialNumber;
    private Employee employee;

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
