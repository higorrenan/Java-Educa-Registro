package model;

public class JavaBeans {
	
	private String id_contato;
	private String nome_contato;
	private String fone_contato;
	private String email_contato;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String id_contato, String nome_contato, String fone_contato, String email_contato) {
		super();
		this.id_contato = id_contato;
		this.nome_contato = nome_contato;
		this.fone_contato = fone_contato;
		this.email_contato = email_contato;
	}

	public String getId_contato() {
		return id_contato;
	}
	public void setId_contato(String id_contato) {
		this.id_contato = id_contato;
	}
	public String getNome_contato() {
		return nome_contato;
	}
	public void setNome_contato(String nome_contato) {
		this.nome_contato = nome_contato;
	}
	public String getFone_contato() {
		return fone_contato;
	}
	public void setFone_contato(String fone_contato) {
		this.fone_contato = fone_contato;
	}
	public String getEmail_contato() {
		return email_contato;
	}
	public void setEmail_contato(String email_contato) {
		this.email_contato = email_contato;
	}
	
	
}
