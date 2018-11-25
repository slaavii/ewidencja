package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Employee;
import pl.sda.ewidencja.domain.entity.Printer;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PrinterDTO {
    private String marka;
    private String serialNumber;
    private Employee employee;

    public PrinterDTO(Printer printer) {
        this(printer.getMarka(),printer.getSerialNumber(),printer.getEmployee());
    }

    public PrinterDTO(String marka, String serialNumber, Employee employee) {
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.employee = employee;
    }

    public PrinterDTO() {

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
