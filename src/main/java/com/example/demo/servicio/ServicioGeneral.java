package com.example.demo.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.datos.ClubesRepository;
import com.example.demo.datos.PartidosRepository;
import com.example.demo.modelo.Clubes;
import com.example.demo.modelo.General;
import com.example.demo.modelo.Partidos;

import jakarta.transaction.Transactional;
@Service
public class ServicioGeneral {
	private final PartidosRepository partidosrepository;
	private final ClubesRepository clubesrepository;	
	
	public ServicioGeneral(PartidosRepository partidosrepository, ClubesRepository clubesrepository) {
		this.clubesrepository = clubesrepository;
		this.partidosrepository = partidosrepository;
	}
	
	
	
	@Transactional
	public List<General> tablaGeneral(){
		List<Partidos> partidos = partidosrepository.findAll();
		List<Clubes> clubes = clubesrepository.findAll();
		int golesL = 0;
		int golesV = 0;
		Map<Integer,General> tabla = new HashMap<>();
		for(Clubes club: clubes) {
			tabla.put(club.getId(),new General(club, club.getNombre(),0,0,0,0,0,0,0,0,0));
		}
		for(Partidos partido: partidos) {
			Clubes visitante = partido.getClubV();
			Clubes local = partido.getClubL();
			if (partido.getGolesL() != 0) {
				golesL = partido.getGolesL();
			}
			if (partido.getGolesV() != 0) {
				golesV = partido.getGolesV();
			}
			
			if(local != null && visitante != null) {
				General gLocal = tabla.get(local.getId());
				gLocal.setCantidad(gLocal.getCantidad()+1);
				gLocal.setGolesF(gLocal.getGolesF() + golesL);
				gLocal.setGolesC(gLocal.getGolesC() + golesV);
				actualizarPartido(gLocal,golesL,golesV);
				
				// visitante
				
				General gVisitante = tabla.get(visitante.getId());
				gVisitante.setCantidad(gVisitante.getCantidad() + 1);
				gVisitante.setGolesF(gVisitante.getGolesF() + golesV);
				gVisitante.setGolesC(gVisitante.getGolesC() + golesL);
				actualizarPartido(gVisitante,golesV,golesL);
			}
			
			
		}
		for (General g : tabla.values()) {
			g.setDiferencia(g.getGolesF() - g.getGolesC());
			g.setPuntos(g.getGanados() * 3 + g.getEmpatados());
			if(g.getCantidad() > 0) {
				g.setPromedio((float)g.getPuntos() / g.getCantidad());
			}
		}
		return new ArrayList<>(tabla.values());
	}
	 	@Transactional
	 	public static void actualizarPartido(General general, int golesF, int golesC) {
	 		if(golesF > golesC) {
	 			general.setGanados(general.getGanados() + 1);
	 		}
	 		else if(golesF == golesC) {
	 			general.setEmpatados(general.getEmpatados() + 1);
	 		}else {
	 			general.setPerdidos(general.getPerdidos() + 1);
	 		}
	 		
	}
}
