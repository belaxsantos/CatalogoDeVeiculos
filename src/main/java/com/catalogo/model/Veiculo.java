package com.catalogo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 2)
	private String marca;
	
	@NotBlank
	@Size(min = 2)
	private String nomme;
	
	@NotNull
	private Long referencia;
	
	//@JsonFormat(shape = JasonFormat.Shape.STRING)
	@NotNull
	@Positive(message = "O preço deve ser maior que zero!")
	private BigDecimal valor;
	
	@UpdateTimestamp
	private LocalDate data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNomme() {
		return nomme;
	}

	public void setNomme(String nomme) {
		this.nomme = nomme;
	}

	public Long getReferencia() {
		return referencia;
	}

	public void setReferencia(Long referencia) {
		this.referencia = referencia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	
	

}
