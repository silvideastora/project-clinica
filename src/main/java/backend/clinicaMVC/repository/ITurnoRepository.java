package backend.clinicaMVC.repository;

import backend.clinicaMVC.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
