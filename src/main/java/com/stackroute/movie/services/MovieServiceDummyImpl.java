package com.stackroute.movie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;

import com.stackroute.movie.domain.Movie;

@Qualifier
public class MovieServiceDummyImpl implements MovieService{

	@Override
	public Movie saveMovie(Movie movie) {
		System.out.println("saving Movie");
		return null;
	}

	@Override
	public List<Movie> getAllMovie() {
		System.out.println("getting Movie");
		return null;
	}

	@Override
	public boolean deleteById(int movieId) {
		System.out.println("deleting by id");
		return false;
	}

	@Override
	public Optional<Movie> findById(int movieId) {
		System.out.println("finding by id");
		return null;
	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {
		System.out.println("updating movie");
		return null;
	}

//	@Override
//	public List<Movie> getMovieByName(String movieTitle) {
//		System.out.println("getting movie by name");
//		return null;
//	}

}
