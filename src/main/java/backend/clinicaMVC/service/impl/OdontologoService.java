package backend.clinicaMVC.service.impl;

import backend.clinicaMVC.dao.IDao;
import backend.clinicaMVC.model.Odontologo;
import backend.clinicaMVC.model.Paciente;
import backend.clinicaMVC.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public IDao<Odontologo> getOdontologoIDao() {
        return odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo agregarOdontologo(Odontologo odontologo){
        return odontologoIDao.registrar(odontologo);
    }

    public Odontologo buscarUnOdontologo(int id){
        return odontologoIDao.buscarPorId(id);
    }
    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoIDao.buscarTodos();
    }

    public void actualizarOdontologo(Odontologo odontologo) {
        odontologoIDao.actualizar(odontologo);
    }


    public void eliminarOdontologo(Integer id) {
        odontologoIDao.eliminar(id);
    }
}
