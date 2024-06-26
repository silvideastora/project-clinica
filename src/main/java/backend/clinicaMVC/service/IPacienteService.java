package backend.clinicaMVC.service;


import backend.clinicaMVC.entity.Paciente;
import backend.clinicaMVC.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    Paciente registrarPaciente(Paciente paciente);

    Optional<Paciente> buscarPorId(Integer id);

    List<Paciente> buscarTodos();
    void actualizarPaciente(Paciente paciente);
    void eliminarPaciente(Integer id) throws ResourceNotFoundException;
    Paciente buscarporDni(String dni);
    List<Paciente>  buscarPorProvincia(String provincia);
}
