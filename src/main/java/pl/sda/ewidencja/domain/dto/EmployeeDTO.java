package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Employee;
import pl.sda.ewidencja.domain.entity.Phone;
import pl.sda.ewidencja.domain.entity.Printer;
import java.util.Set;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String surname;
    private String position;
    private Set<Computer> computers;
    private Set<Phone> phones;
    private Set<Printer> printers;
    private String location;

    public EmployeeDTO(Employee employee) {
        this(   employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getPosition(),
                employee.getComputers(),
                employee.getPhones(),
                employee.getPrinters(),
                employee.getLocation());
    }

    public EmployeeDTO(Long id,String name, String surname, String position, Set<Computer> computers, Set<Phone> phones, Set<Printer> printers, String location) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.computers = computers;
        this.phones = phones;
        this.printers = printers;
        this.location = location;
    }

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Computer> getComputers() {
        return computers;
    }

    public void setComputers(Set<Computer> computers) {
        this.computers = computers;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public Set<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(Set<Printer> printers) {
        this.printers = printers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
