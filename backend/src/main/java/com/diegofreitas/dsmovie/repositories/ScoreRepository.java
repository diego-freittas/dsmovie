package com.diegofreitas.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegofreitas.dsmovie.entities.Score;
import com.diegofreitas.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
