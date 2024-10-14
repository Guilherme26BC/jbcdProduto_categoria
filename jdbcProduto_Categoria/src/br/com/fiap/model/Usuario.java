package br.com.fiap.model;

import br.com.fiap.jdbc.utils.CriptografiaUtils;

public class Usuario {

	private String email;
	private String senha;

	public Usuario() {
		super();
	}

	public Usuario(String nome, String email) {
		super();
		this.email = email;
		setSenha(senha);
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {

		}
	}

}
