package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.datos.JugadoresRepository;
import com.example.demo.modelo.Jugadores;

import jakarta.transaction.Transactional;
@Service
public class ServicioJugadores {
	private final JugadoresRepository jugadoresrepository;
	
	public ServicioJugadores (JugadoresRepository jugadoresrepository) {
		this.jugadoresrepository = jugadoresrepository;
	}
	@Transactional
	public List<Jugadores> findAll(){
		return jugadoresrepository.findAll();
	}
	@Transactional
	public Jugadores findById(int nroDoc) {
		return jugadoresrepository.findById(nroDoc).orElseThrow(()-> new RuntimeException("No se encontro el jugador"));
	}
	@Transactional 
	public Jugadores save (Jugadores jugador) {
		return jugadoresrepository.save(jugador);
	}
	@Transactional
	public void deleteById(int nroDoc) {
		jugadoresrepository.deleteById(nroDoc);
	}
}
