package com.stackroute.movie.respository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.movie.domain.Movie;

public interface MovieRespository extends CrudRepository<Movie, Integer> {

	
//	@Query("SELECT m FROM Movie m WHERE m.movieTitle LIKE :movieTitle%")
//    public List<Movie> getByMovieName(@Param("movieTitle") String movieTitle);
}
