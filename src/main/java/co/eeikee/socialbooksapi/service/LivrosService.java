package co.eeikee.socialbooksapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.eeikee.socialbooksapi.domain.Comentario;
import co.eeikee.socialbooksapi.domain.Livro;
import co.eeikee.socialbooksapi.repository.ComentarioRepository;
import co.eeikee.socialbooksapi.repository.LivroRepostirory;
import co.eeikee.socialbooksapi.service.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired		
	private LivroRepostirory lr;
	
	@Autowired		
	private ComentarioRepository cr;
	
	public List<Livro> listar(){
		return lr.findAll();
	}
	
	public Livro buscar(Long id){
		if (lr.findById(id).isEmpty()) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
		return lr.getOne(id);
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return lr.save(livro);
	}
	
	public Livro salvar(Livro livro, Long id) {
		livro.setId(id);
		return lr.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			lr.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Livro livro, Long id) {
		verificarExistencia(id);
		salvar(livro, id);
	}
	
	private void verificarExistencia(Long id) {
		buscar(id);
	}
	
	public Comentario salvarComentario(Long idLivro, Comentario comentario) {
		Livro livro = buscar(idLivro);
		livro.getComentarios().add(comentario);
		return cr.save(comentario);
	}
	
	public List<Comentario> listarComentario(Long idLivro) {
		Livro livro = buscar(idLivro);
		return livro.getComentarios();
	}
}
