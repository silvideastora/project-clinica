package backend.clinicaMVC.service;

import backend.clinicaMVC.model.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo agregarOdontologo(Odontologo odontologo);

    Odontologo buscarUnOdontologo(int id);
    List<Odontologo> buscarTodosOdontologos();
}
