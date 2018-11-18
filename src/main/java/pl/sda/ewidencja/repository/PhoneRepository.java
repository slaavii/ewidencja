package pl.sda.ewidencja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.ewidencja.domain.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
