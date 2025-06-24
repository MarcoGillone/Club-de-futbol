package com.example.demo.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Clubes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clubes {
	@Id
	@Column(name = "Id_Club")
	private int id;
	@Column(name = "Nombre", length = 30)
	private String nombre;
	@Column(name = "Nrozona")
	private int Nrozona;
	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Jugadores>jugadores;
	@OneToMany(mappedBy = "clubL", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Partidos> partidosL;
	@OneToMany(mappedBy = "clubV", cascade= CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Partidos> partidosV;

	
	
	
	

	
	
}
