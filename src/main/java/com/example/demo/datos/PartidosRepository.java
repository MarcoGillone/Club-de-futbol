package com.example.demo.datos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Partidos;

public interface PartidosRepository extends JpaRepository<Partidos, Integer> {
	List<Partidos> findByClubL_id(int id); 
	List<Partidos> findByClubV_id(int id);

}
