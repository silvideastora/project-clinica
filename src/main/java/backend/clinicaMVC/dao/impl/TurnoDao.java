package backend.clinicaMVC.dao.impl;

import backend.clinicaMVC.dao.IDao;
import backend.clinicaMVC.model.Turno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurnoDao implements IDao<Turno> {

    private List<Turno> turnos;
    private static Logger LOGGER = LoggerFactory.getLogger(TurnoDao.class);


    //Para la inyeccion de dependecias se le genera un constructor
    public TurnoDao(List<Turno> turnos) {
        this.turnos = turnos;
    }

    //Todos sus metodos implementados del DAO
    @Override
    public Turno registrar(Turno turno) {
        Integer id = turnos.size() + 1;
        turno.setId(id);
        turnos.add(turno);
        LOGGER.info("Turno creado!" + turno);
        return turno;
    }

    @Override
    public Turno buscarPorId(Integer id) {

        for (Turno turno : turnos) {
            if(turno.getId().equals(id)){
                LOGGER.info("Turno encontrado!"+ turno);
                return turno;
            } else {
                LOGGER.info("Turno no encontrado");
                return null;
            }
        }
        return null;
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }

    @Override
    public void actualizar(Turno turno) {
        for (Turno t : turnos) {
            if(t.getId().equals(turno.getId())){
                t.setPaciente(turno.getPaciente());
                t.setOdontologo(turno.getOdontologo());
                t.setFecha(turno.getFecha());
                LOGGER.info("Turno actualizado" + turno);

            }
        }
        LOGGER.info("Turno no actualizado");
    }

    @Override
    public void eliminar(Integer id) {
        //GEnero mi instancias de turno en null
        Turno turnoAEliminar = null;
        for (Turno turno : turnos) {
            if(turno.getId().equals(id)){
                turnoAEliminar = turno;
                break;
            }
        }
        turnos.remove(turnoAEliminar);
        LOGGER.info("El Turno ha sido eliminado!");
    }
}
