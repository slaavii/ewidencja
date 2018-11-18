package pl.sda.ewidencja.domain.dto;

import pl.sda.ewidencja.domain.entity.Computer;
import pl.sda.ewidencja.domain.entity.Phone;
import pl.sda.ewidencja.domain.entity.Printer;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

public class EmployeeDTO {
    private String name;
    private String surname;
    private String position;
    private List<Computer> computers;
    private List<Phone> phones;
    private List<Printer> printers;
    private String location;

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

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(List<Printer> printers) {
        this.printers = printers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
