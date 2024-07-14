package foro.desafio.alura.api2.topicos;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
