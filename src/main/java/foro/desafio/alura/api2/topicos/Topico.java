package foro.desafio.alura.api2.topicos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @Column(name = "nombre_curso")
    private String nombreCurso;
    private String titulo;
    @Column(name = "fecha_creacion")
    private String fechaCreacion;
    private String autor;


    public Topico(DatosTopico datosTopico) {
        this.mensaje=datosTopico.mensaje();
        this.nombreCurso=datosTopico.nombreCurso();
        this.titulo= datosTopico.titulo();
        this.fechaCreacion= datosTopico.fechaCreacion();
        this.autor= datosTopico.autor();



    }

    public String getMensaje() {
        return mensaje;
    }

    public Long getId() {
        return id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getAutor() {
        return autor;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if (datosActualizarTopico.mensaje()!= null){
            this.mensaje=datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.nombreCurso()!=null){
            this.nombreCurso=datosActualizarTopico.nombreCurso();
        }
        if (datosActualizarTopico.titulo()!=null){
            this.titulo=datosActualizarTopico.titulo();
        }

    }
}



