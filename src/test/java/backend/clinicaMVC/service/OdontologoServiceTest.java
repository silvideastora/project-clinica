package backend.clinicaMVC.service;


import backend.clinicaMVC.entity.Odontologo;
import backend.clinicaMVC.entity.Paciente;
import backend.clinicaMVC.service.impl.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OdontologoServiceTest {
    private static Logger LOGGER = LoggerFactory.getLogger(OdontologoServiceTest.class);
    @Autowired
    private OdontologoService odontologoService;
    private Odontologo odontologo;
    private Paciente paciente;

    @BeforeEach
    void setUp(){
        odontologo = new Odontologo();
        odontologo.setNombre("Abba");
        odontologo.setApellido("Wong");
        odontologo.setNroMatricula("2345");
        odontologo.setTurnoSet(null);
        odontologo = odontologoService.agregarOdontologo(odontologo);

    }

    @Test
    @DisplayName("Se agrega un odontólogo")
    void ingreso(){
        Assertions.assertNotNull(odontologoService.agregarOdontologo(odontologo));
    }

    @Test
    @DisplayName("Listar todos los odontologos")
    void testListar(){
        List<Odontologo> listar = odontologoService.buscarTodosOdontologos();
        assertTrue(listar.size() != 0);
    }
    @Test
    @DisplayName("Testear busqueda Odontologo por id")
    void testOdontologoPorId() {
        Integer id = odontologo.getId();

        Optional<Odontologo> odontologoOptional = odontologoService.buscarUnOdontologo(id);

        Odontologo odontologoEncontrado= odontologoOptional.get();

        assertEquals(id, odontologoEncontrado.getId());
    }

}
