package pl.sda.ewidencja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.ewidencja.domain.entity.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
