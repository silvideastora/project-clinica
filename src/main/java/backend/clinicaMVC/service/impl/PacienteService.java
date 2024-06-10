package backend.clinicaMVC.service.impl;

import backend.clinicaMVC.dao.IDao;
import backend.clinicaMVC.model.Paciente;
import backend.clinicaMVC.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService implements IPacienteService {
    private IDao<Paciente> pacienteIDao;



    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente registrarPaciente(Paciente paciente){
        return pacienteIDao.registrar(paciente);
    }

    public Paciente buscarPorId(Integer id){
        return pacienteIDao.buscarPorId(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }
    @Override
    public void actualizarPaciente(Paciente paciente) {
        pacienteIDao.actualizar(paciente);
    }

    @Override
    public void eliminarPaciente(Integer id) {
        pacienteIDao.eliminar(id);
    }
}
