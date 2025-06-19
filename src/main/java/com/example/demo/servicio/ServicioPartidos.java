package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.datos.PartidosRepository;
import com.example.demo.modelo.Partidos;

import jakarta.transaction.Transactional;
@Service
public class ServicioPartidos {
	private final PartidosRepository partidosrepository;
	
	public ServicioPartidos(PartidosRepository partidosrepository) {
		this.partidosrepository = partidosrepository;
	}

	
	@Transactional 
	public List<Partidos> findAll(){
		return partidosrepository.findAll();
	}
	@Transactional
	public Partidos findById(int id) {
		return partidosrepository.findById(id).orElseThrow(()-> new RuntimeException("Partido no encontrado"));
	}
	
	@Transactional
	public Partidos save (Partidos partido) {
		return partidosrepository.save(partido);
	}
	@Transactional
	public void deleteById (int id) {
		partidosrepository.deleteById(id);
	}
}
