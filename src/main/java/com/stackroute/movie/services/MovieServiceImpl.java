package com.stackroute.movie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.respository.MovieRespository;

@Service
public class MovieServiceImpl implements MovieService {
	private MovieRespository movieRepo;

	@Autowired
	public MovieServiceImpl(MovieRespository movieRepo) {
		this.movieRepo = movieRepo;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		Movie result = movieRepo.save(movie);
		return result;

	}

	@Override
	public List<Movie> getAllMovie() {
		List<Movie> list = (List<Movie>) movieRepo.findAll();
		return list;

	}

	@Override
	public boolean deleteById(int movieId) {
		movieRepo.deleteById(movieId);
		return true;
	}

	@Override
	public Optional<Movie> findById(int movieId) {
		return movieRepo.findById(movieId);

	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {
		movie.setMovieId(movieId);
		movieRepo.save(movie);
		return movieRepo.save(movie);
	}

//	@Override
//	   public List<Movie> getMovieByName(String movieTitle) {
//	       List<Movie> movieList = movieRepo.getByMovieName(movieTitle);
//	       return movieList;
//	   }
	

}
