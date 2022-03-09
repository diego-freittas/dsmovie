package com.diegofreitas.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diegofreitas.dsmovie.dto.MovieDTO;
import com.diegofreitas.dsmovie.dto.ScoreDTO;
import com.diegofreitas.dsmovie.entities.Movie;
import com.diegofreitas.dsmovie.entities.Score;
import com.diegofreitas.dsmovie.entities.User;
import com.diegofreitas.dsmovie.repositories.MovieRepository;
import com.diegofreitas.dsmovie.repositories.ScoreRepository;
import com.diegofreitas.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	public MovieRepository movieRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
	
}
