package backend.clinicaMVC.service.impl;


import backend.clinicaMVC.entity.Odontologo;

import backend.clinicaMVC.exception.ResourceNotFoundException;
import backend.clinicaMVC.repository.IOdontologoRepository;
import backend.clinicaMVC.service.IOdontologoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository odontologoRepository;
    private static Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo agregarOdontologo(Odontologo odontologo){
        Odontologo odontologo1 = odontologoRepository.save(odontologo);
        if(odontologo1 != null){
            LOGGER.info("odontologo agregado" + odontologo1);
        }
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> buscarUnOdontologo(Integer id){
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id);
        if(odontologoOptional.isPresent()){
            LOGGER.info("ID del odontologo encontrada" + odontologoOptional);
        }
        return odontologoOptional;
    }
    public List<Odontologo> buscarTodosOdontologos(){
        List<Odontologo> odontologoList = odontologoRepository.findAll();
        LOGGER.info("Lista de Odontologos" + odontologoList);
        return odontologoList;
    }

    @Override
    public void modificarOdontologo(Odontologo odontologo) {
        odontologoRepository.save(odontologo);
        LOGGER.info("Odontologo modificado");
    }

    @Override
    public void eliminarOdontologo(Integer id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoOptional = buscarUnOdontologo(id);
        if(odontologoOptional.isPresent()){
            odontologoRepository.deleteById(id);
            LOGGER.info("Odontologo eliminado");
        } else {
            throw new ResourceNotFoundException("{\"message\": \"odontologo no encontrado\"}");
        }

    }

    @Override
    public List<Odontologo> buscarPorApellido(String apellido) {
        List<Odontologo> listaOdontologos= odontologoRepository.buscarPorApellido(apellido);
        LOGGER.info("Lista de odontologos por apellido" + listaOdontologos);
        return listaOdontologos;
    }

    @Override
    public List<Odontologo> buscarPorNombre(String nombre) {
        List<Odontologo> odontologosLista= odontologoRepository.findByNombreLike(nombre);
        LOGGER.info("Lista de odontologos por nombre" + odontologosLista);
        return odontologosLista;
    }
}