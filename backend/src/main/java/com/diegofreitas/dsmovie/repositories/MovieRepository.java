package com.diegofreitas.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegofreitas.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
