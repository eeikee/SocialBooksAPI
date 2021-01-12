package co.eeikee.socialbooksapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.eeikee.socialbooksapi.domain.Comentario;
import co.eeikee.socialbooksapi.domain.Livro;
import co.eeikee.socialbooksapi.service.LivrosService;

@RestController
@RequestMapping("/livros")
public class LivrosResources {
	
	@Autowired		
	private LivrosService ls;
	
	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.ok(ls.listar());
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		ls.salvar(livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(livro.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable("id") Long id) {
		Livro livro = ls.buscar(id);
		return ResponseEntity.ok(livro); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		ls.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro) {
		ls.atualizar(livro, id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/{id}/comentarios")
	public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long idLivro, @RequestBody Comentario comentario) {
		ls.salvarComentario(idLivro, comentario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/cometarios").buildAndExpand(idLivro).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}/comentarios")
	public ResponseEntity<List<Comentario>> listarComentario(@PathVariable("id") Long idLivro) {
		return ResponseEntity.ok(ls.listarComentario(idLivro));
	}
	
	
	
}
