package co.eeikee.socialbooksapi.domain;

public class DetalhesErro {
	private String titulo;
	private Long status;
	private Long time;
	private String mensagemDesenvolvedor;
	
	public DetalhesErro() {}
	
	public DetalhesErro(Long status,String titulo, String mensagemDesenvolvedor) {
		this.titulo = titulo;
		this.status = status;
		this.time = System.currentTimeMillis();
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Long getTime() {
		return time;
	}
	
	public void setTime() {
		this.time = System.currentTimeMillis();
	}
	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
	
}
