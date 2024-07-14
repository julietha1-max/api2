package foro.desafio.alura.api2.topicos;

public record DatosListadoTopico(Long id,String mensaje, String nombreCurso, String titulo, String fechaCreacion, String autor) {

public DatosListadoTopico(Topico topico){

    this(topico.getId(),topico.getMensaje(),topico.getNombreCurso(), topico.getTitulo(), topico.getFechaCreacion(), topico.getAutor() );

}



}