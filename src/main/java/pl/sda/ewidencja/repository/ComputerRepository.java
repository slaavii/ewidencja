package pl.sda.ewidencja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.ewidencja.domain.entity.Computer;

import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

    Optional<Computer> findBySerialNumber(String serialNumber);
}
