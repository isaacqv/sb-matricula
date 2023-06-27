package edu.cibertec.matricula.dao.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name="curso")
@Data
/*@NamedQuery(name="CursoEntity.abiertoIncompleto",
        query = "SELECT c FROM CursoEntity c WHERE c.alumnosMin > c.alumnosAct AND c.estado=1")*/
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
/*    @NotNull*/
    private Integer idCurso;

    @NotNull
    @NotBlank(message = "Curso es obligatorio")
    @Size(min = 3, max = 40)
    @Column(name = "nomcurso")
    private String nomCurso;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd") //Validacion
    @Temporal(TemporalType.DATE)
    @Column(name = "fechainicio")
    private Date fechaInicio;

    @NotNull(message = "{curso.alumnosmin.vacio}")
    @Min(value = 1,message = "{curso.alumnosmin.vacio}")
    @Column(name = "alumnosmin")
    private Integer alumnosMin;
    @Column(name = "alumnosact")
    private Integer alumnosAct;
    @Column(name = "estado")
    private Integer estado;

    /*public CursoEntity() {
        this.alumnosMin = 0;
        this.alumnosAct = 0;
        this.estado = 0;
    }*/
}
