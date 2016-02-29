package br.com.sm.domain;

public class Erro {
	
	private String mensagem;
	
	private Integer codigo;
	
	private long timestamp;
	
	private String documentacao;

	public Erro(String mensagem, Integer codigo, long timestamp, String documentacao) {
		super();
		this.mensagem = mensagem;
		this.codigo = codigo;
		this.timestamp = timestamp;
		this.documentacao = documentacao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDocumentacao() {
		return documentacao;
	}

	public void setDocumentacao(String documentacao) {
		this.documentacao = documentacao;
	}

}
