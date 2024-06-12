package backend.clinicaMVC.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nroMatricula;
    private String nombre;
    private String apellido;
    @OneToMany(mappedBy = "odontologo")
    private List<Turno> turnos = new ArrayList<>();
 }
