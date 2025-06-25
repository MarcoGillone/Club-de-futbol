package com.example.demo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.datos.ClubesRepository;
import com.example.demo.datos.PartidosRepository;
import com.example.demo.modelo.Clubes;
import com.example.demo.modelo.Partidos;

import jakarta.transaction.Transactional;
@Service
public class ServicioPartidos {
	private final PartidosRepository partidosrepository;
	private final ClubesRepository clubesrepository;
	
	public ServicioPartidos(PartidosRepository partidosrepository, ClubesRepository clubesrepository) {
		this.partidosrepository = partidosrepository;
		this.clubesrepository = clubesrepository;
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
	@Transactional 
	public List<Partidos> buscaarPorClubLocal(int id){
		return partidosrepository.findByClubL_id(id);
	}
	@Transactional 
	public List<Partidos> buscaarPorClubVisitante(int id){
		return partidosrepository.findByClubV_id(id);
	}
	@Transactional 
	public List<Partidos> buscaarPorClubTodos(int id){
		List<Partidos> local = partidosrepository.findByClubL_id(id);
		List<Partidos> visitante = partidosrepository.findByClubV_id(id);
		local.addAll(visitante);
		return local;
	}
	
	@Transactional
	public Partidos agregarPartidoValidado(Partidos partido) {
	    Integer idL = (partido.getClubL() != null) ? partido.getClubL().getId() : null;
	    Integer idV = (partido.getClubV() != null) ? partido.getClubV().getId() : null;

	    if (idL == null || idV == null) {
	        throw new RuntimeException("Debes especificar ambos clubes.");
	    }

	    Clubes local = clubesrepository.findById(idL).orElseThrow(() -> new RuntimeException("Club local no existe"));
	    Clubes visita = clubesrepository.findById(idV) .orElseThrow(() -> new RuntimeException("Club visitante no existe"));

	    if (local.getNrozona() != visita.getNrozona()) {
	        throw new RuntimeException("Los clubes deben ser de la misma zona.");
	    }

	    partido.setClubL(local);
	    partido.setClubV(visita);
	    return partidosrepository.save(partido);
	}
	
	@Transactional
	public Partidos actualizarResultado(int id, int golV, int golL) {
		Partidos partido = findById(id);
		partido.setGolesL(golL);
		partido.setGolesV(golV);
		return partidosrepository.save(partido);
		
	}




}
