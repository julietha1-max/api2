package foro.desafio.alura.api2.controller;


import foro.desafio.alura.api2.topicos.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topico")

public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


@PostMapping
    public ResponseEntity<DatosRespuestaTopicos> registrarTopico(@RequestBody @Validated DatosTopico datosTopico,  UriComponentsBuilder uriComponentsBuilder ){
    Topico topico=topicoRepository.save(new Topico(datosTopico));
    DatosRespuestaTopicos datosRespuestaTopicos = new DatosRespuestaTopicos(topico.getId(),topico.getMensaje(),topico.getNombreCurso(), topico.getTitulo(), topico.getFechaCreacion(), topico.getAutor());
  URI url=uriComponentsBuilder.path("/topico/{id}" ).buildAndExpand(topico.getId()).toUri();
    return ResponseEntity.created(url).body(datosRespuestaTopicos);}


  @GetMapping


 public ResponseEntity<Page<DatosListadoTopico>> listadoTopico( Pageable paginacion){
    return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
  }
@PutMapping
@Transactional
 public ResponseEntity actualizarTopico(@RequestBody @Validated DatosActualizarTopico datosActualizarTopico){
    Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
   topico.actualizarDatos(datosActualizarTopico);
   return  ResponseEntity.ok(new DatosRespuestaTopicos(topico.getId(),topico.getMensaje(),topico.getNombreCurso(), topico.getTitulo(), topico.getFechaCreacion(), topico.getAutor()));

  }

@DeleteMapping("/{id}")
@Transactional
 public ResponseEntity eliminarTopico(@PathVariable Long id){
Topico topico = topicoRepository.getReferenceById(id);
topicoRepository.delete(topico);
return ResponseEntity.noContent().build();
 }

}
