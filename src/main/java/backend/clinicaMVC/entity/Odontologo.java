package backend.clinicaMVC.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnoSet = new HashSet<>();
 }
