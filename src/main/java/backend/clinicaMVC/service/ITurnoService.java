package backend.clinicaMVC.service;

import backend.clinicaMVC.model.Paciente;
import backend.clinicaMVC.model.Turno;

import java.util.List;

public interface ITurnoService {
    Turno registrar(Turno turno);

    Turno buscarPorId(Integer id);

    List<Turno> buscarTodos();
    void actualizarTurno(Turno turno);
    void eliminarTurno(Integer id);
}
