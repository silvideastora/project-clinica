package backend.clinicaMVC.controller;

import backend.clinicaMVC.entity.Odontologo;
import backend.clinicaMVC.entity.Paciente;
import backend.clinicaMVC.service.IOdontologoService;
import backend.clinicaMVC.service.IPacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/vista")
public class VistaController {
    private IPacienteService pacienteService;
    private IOdontologoService odontologoService;

    public VistaController(IPacienteService pacienteService, IOdontologoService odontologoService) {
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @GetMapping("/buscarPaciente")
    public String buscarPacientePorId(Model model, @RequestParam Integer id){
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        Paciente paciente2 = paciente.get();
        model.addAttribute("especialidad", "Paciente");
        model.addAttribute("nombre", paciente2.getNombre());
        model.addAttribute("apellido", paciente2.getApellido());
        return "index";
    }

    @GetMapping("/buscarOdontologo")
    public String buscarOdontologoPorId(Model model, @RequestParam Integer id){
        Optional<Odontologo> odontologo = odontologoService.buscarUnOdontologo(id);
        Odontologo odontologo2 = odontologo.get();
        model.addAttribute("especialidad", "odontologo");
        model.addAttribute("nombre", odontologo2.getNombre());
        model.addAttribute("apellido", odontologo2.getApellido());
        return "index";
    }
}
