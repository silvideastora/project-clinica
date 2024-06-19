package backend.clinicaMVC.service;

import backend.clinicaMVC.Dto.request.TurnoRequestDto;
import backend.clinicaMVC.Dto.response.TurnoResponseDto;
import backend.clinicaMVC.entity.Odontologo;
import backend.clinicaMVC.entity.Paciente;
import backend.clinicaMVC.exception.BadRequestException;
import backend.clinicaMVC.service.impl.OdontologoService;
import backend.clinicaMVC.service.impl.PacienteService;
import backend.clinicaMVC.service.impl.TurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TurnoServiceTest {

    private static Logger LOGGER = LoggerFactory.getLogger(TurnoServiceTest.class);

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;

    private TurnoResponseDto turnoResponseDto;
    private TurnoRequestDto turnoRequestDto;
    private Odontologo odontologo;
    private Paciente paciente;

    @BeforeEach
    void setUp(){
        odontologo = new Odontologo();
        odontologo.setNroMatricula("5164721");
        odontologo.setNombre("juliana");
        odontologo.setApellido("vargas");
        odontologoService.agregarOdontologo(odontologo);

        paciente = new Paciente();
        paciente.setNombre("Menganito");
        paciente.setApellido("Cosme");
        paciente.setDni("464646");
        pacienteService.registrarPaciente(paciente);

        turnoRequestDto= new TurnoRequestDto();
        turnoRequestDto.setOdontologo_id(odontologo.getId());
        turnoRequestDto.setPaciente_id(paciente.getId());
        turnoRequestDto.setFecha("2024-02-21");
    }
    @Test
    @DisplayName("Testear que un turno fue guardado")
    void testTurnoGuardado() throws BadRequestException {
        TurnoResponseDto turnoResponseDto= turnoService.registrar(turnoRequestDto);
        assertNotNull(turnoResponseDto);
    }


}
