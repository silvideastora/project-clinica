package backend.clinicaMVC.service.impl;

import backend.clinicaMVC.entity.Paciente;
import backend.clinicaMVC.exception.ResourceNotFoundException;
import backend.clinicaMVC.repository.IPacienteRepository;
import backend.clinicaMVC.service.IPacienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteService implements IPacienteService {
    private IPacienteRepository pacienteRepository;
    private static Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente registrarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPorId(Integer id){
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if(pacienteOptional.isPresent()){
            LOGGER.info("Paciente encontrado"+ pacienteOptional);
        }
        return pacienteOptional;
    }

    public List<Paciente> buscarTodos(){
        List<Paciente> pacienteList1 = pacienteRepository.findAll();
        LOGGER.info("Lista de pacientes encotrados"+ pacienteList1);
        return pacienteList1;
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
        LOGGER.info("Paciente actualizado");
    }

    @Override
    public void eliminarPaciente(Integer id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteOptional = buscarPorId(id);
        if(pacienteOptional.isPresent()){
            pacienteRepository.deleteById(id);
            LOGGER.info("Paciente eliminado" + pacienteOptional);
        } else {
            throw new ResourceNotFoundException("{\"message\": \"paciente no encontrado\"}");
        }

    }

    @Override
    public Paciente buscarporDni(String dni) {
        Paciente pacienteDni = pacienteRepository.buscarPorDni(dni);
        if(pacienteDni != null){
            LOGGER.info("Dni de paciente encontrada" + pacienteDni);
        }
        return pacienteDni;
    }

    @Override
    public List<Paciente> buscarPorProvincia(String provincia) {
        List<Paciente> pacienteList = pacienteRepository.buscarProvincia(provincia);
        LOGGER.info("Lista de pacientes por provincias" + pacienteList);
        return pacienteList;
    }

}
