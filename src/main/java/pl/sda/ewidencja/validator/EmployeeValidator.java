package pl.sda.ewidencja.validator;

import pl.sda.ewidencja.domain.entity.Employee;

public class EmployeeValidator {
    public void validate(Employee employee) {
        if (employee.getName().isEmpty() || employee.getName() == null || employee.getName().length() < 2) {
            throw new IllegalArgumentException("Imie nie moze byc puste i krotsze niz 2 znaki");
        }
        if (employee.getSurname().isEmpty() || employee.getName() == null || employee.getSurname().length() < 2) {
            throw new IllegalArgumentException("Nazwisko nie moze byc puste i krotsze niz 2 znaki");
        }
        if (employee.getPosition().isEmpty() || employee.getPosition() == null || employee.getPosition().length() < 5) ;
        throw new IllegalArgumentException("Stanowisko nie moze byc puste i krotsze niz 5 znakow");
    }
}
