package backend.clinicaMVC.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaIngreso;
    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;
    @OneToMany(mappedBy = "paciente")
    private List<Turno> turnos = new ArrayList<>();
}
