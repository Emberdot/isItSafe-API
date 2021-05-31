package com.isitsafe.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="TABELA_NOME")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "senha", nullable = false, columnDefinition = "TEXT")
	private String senha;
	
	@CreatedDate
	@JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATE")
	private Date createdAt = new Date();

	@LastModifiedDate
	@JsonFormat(timezone = "UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	@Column(name = "updated_at", nullable = false, updatable = true, columnDefinition = "DATE")
	private Date updatedAt = new Date();

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}