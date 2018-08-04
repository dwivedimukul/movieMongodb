package com.stackroute.movie.services;

import java.util.List;
import java.util.Optional;

import com.stackroute.movie.domain.Movie;

public interface MovieService {

	public Movie saveMovie(Movie movie);

	public List<Movie> getAllMovie();

	public boolean deleteById(int movieId);

	public Optional<Movie> findById(int movieId);

	public Movie updateMovie(int movieId, Movie movie);

	//public List<Movie> getMovieByName(String movieTitle);
	
	

}
