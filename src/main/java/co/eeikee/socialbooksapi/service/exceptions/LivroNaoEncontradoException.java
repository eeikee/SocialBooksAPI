package co.eeikee.socialbooksapi.service.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8617109729692442744L;

	public LivroNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException (String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
