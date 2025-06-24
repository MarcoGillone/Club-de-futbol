package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.datos.ClubesRepository;
import com.example.demo.modelo.Clubes;

import jakarta.transaction.Transactional;
@Service
public class ServicioClubes {
	private final ClubesRepository clubesrepository;
	
	public ServicioClubes (ClubesRepository clubesrepository) {
		this.clubesrepository = clubesrepository;
	}
	@Transactional
	public List<Clubes> findAll(){
		return clubesrepository.findAll();
	}
	@Transactional
	public Clubes findById(int id) {
		return clubesrepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el club"));
		
	}
	@Transactional
	public Clubes save(Clubes club) {
		if(clubesrepository.existsById(club.getId())) {
			throw new RuntimeException("ya existe un club con ese id"); 
		}
		return clubesrepository.save(club);
	}
	@Transactional
	public void deleteById(int id) {
		clubesrepository.deleteById(id);
	}
}
