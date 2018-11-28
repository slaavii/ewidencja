package pl.sda.ewidencja.domain.dto;
import pl.sda.ewidencja.domain.entity.Printer;

public class PrinterDTO {
    private Long id;
    private String marka;
    private String serialNumber;
    private EmployeeDTO employee;

    public PrinterDTO(Printer printer) {
        this(printer.getId(),
                printer.getMarka(),
                printer.getSerialNumber(),
                printer.getEmployee() == null ? null : new EmployeeDTO(printer.getEmployee()));
    }

    public PrinterDTO() {
    }

    public PrinterDTO(Long id, String marka, String serialNumber) {
        this.id = id;
        this.marka = marka;
        this.serialNumber = serialNumber;
    }

    public PrinterDTO(Long id, String marka, String serialNumber, EmployeeDTO employee) {
        this.id = id;
        this.marka = marka;
        this.serialNumber = serialNumber;
        this.employee = employee;
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
