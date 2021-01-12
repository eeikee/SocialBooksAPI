package co.eeikee.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.eeikee.socialbooksapi.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
