package pl.sda.ewidencja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.ewidencja.domain.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
