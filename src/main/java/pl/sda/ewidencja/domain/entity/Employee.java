package pl.sda.ewidencja.domain.entity;

import pl.sda.ewidencja.domain.dto.EmployeeDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private String position;
    @OneToMany(mappedBy = "employee")
    private Set<Computer> computers;
    @OneToMany(mappedBy = "employee")
    private Set<Phone> phones;
    @OneToMany(mappedBy = "employee")
    private Set<Printer> printers;
    private String location;

    public Employee(EmployeeDTO employeeDTO) {
        this(employeeDTO.getId(),
                employeeDTO.getName(),
                employeeDTO.getSurname(),
                employeeDTO.getPosition(),
                employeeDTO.getComputers(),
                employeeDTO.getPhones(),
                employeeDTO.getPrinters(),
                employeeDTO.getLocation());
    }
    public Employee(Long id,String name, String surname, String position, Set<Computer> computers, Set<Phone> phones, Set<Printer> printers, String location) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.computers = computers;
        this.phones = phones;
        this.printers = printers;
        this.location = location;
    }
    public Employee() {
    }
    public Employee(String name, String surname, String position, String location) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.location = location;
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
