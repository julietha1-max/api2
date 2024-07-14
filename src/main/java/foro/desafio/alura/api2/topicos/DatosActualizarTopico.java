package foro.desafio.alura.api2.topicos;

import org.antlr.v4.runtime.misc.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String mensaje, String nombreCurso, String titulo) {


}
