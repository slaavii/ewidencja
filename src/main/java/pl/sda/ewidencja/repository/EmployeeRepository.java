package pl.sda.ewidencja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.ewidencja.domain.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findBySurname(String surname);
    Optional<Employee> findByLocation(String location);
}
