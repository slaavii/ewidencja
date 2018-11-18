package pl.sda.ewidencja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.ewidencja.domain.entity.Printer;

public interface PrinterRepository extends JpaRepository<Printer, Long> {
}
