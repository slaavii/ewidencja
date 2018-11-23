package pl.sda.ewidencja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.ewidencja.domain.entity.NetDevice;

public interface NetDeviceRepository extends JpaRepository<NetDevice, Long> {
}
