package co.eeikee.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.eeikee.socialbooksapi.domain.Livro;

public interface LivroRepostirory extends JpaRepository<Livro, Long> {

}
