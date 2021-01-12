package co.eeikee.socialbooksapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.eeikee.socialbooksapi.domain.DetalhesErro;
import co.eeikee.socialbooksapi.service.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException(LivroNaoEncontradoException e,HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DetalhesErro(404l,"O livro não pôde ser encontrado", "http://erros.socialbooks.com/404"));
	}
}
