package com.stackroute.movie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.respository.MovieRespository;


@Configuration
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {
	private MovieRespository movieRepo;
	private Movie movie;
	@Autowired
	public void setMovieRepo(MovieRespository movieRepo) {
		this.movieRepo = movieRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieTitle("Taare Zameen Par");
		movie.setRating(4);
		movie.setYearOfRelease(2015);
		movieRepo.save(movie);
		
		Movie testWidget = Movie.builder().movieId(2).movieTitle("foo").rating(3).build();
		movieRepo.save(testWidget);

	}

}
