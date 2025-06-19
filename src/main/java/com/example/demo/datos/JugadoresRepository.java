package com.example.demo.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Jugadores;

public interface JugadoresRepository extends JpaRepository<Jugadores, Integer> {

}
