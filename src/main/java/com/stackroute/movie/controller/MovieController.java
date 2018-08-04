package com.stackroute.movie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.services.MovieService;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {
	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		Movie movieSave = movieService.saveMovie(movie);
		return new ResponseEntity<Movie>(movieSave, HttpStatus.OK);

	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAllMovie() {
		List<Movie> list = movieService.getAllMovie();
		return new ResponseEntity<List>(list, HttpStatus.OK);

	}

	@DeleteMapping(value = "movie/{movieId}")
	public ResponseEntity<?> deleteById(@PathVariable int movieId) {
		if (movieService.deleteById(movieId))
			return new ResponseEntity<String>("{ \"message\": \"" + "deleted" + "\"}", HttpStatus.OK);
		else
			return new ResponseEntity<String>("{ \"message\": \"" + "notdeletes" + "\"}", HttpStatus.CONFLICT);
	}

	@GetMapping(value = "/movie/{movieId}", produces = "application/json")
	public ResponseEntity<?> GetById(@PathVariable int movieId) {
		Optional<Movie> movie = movieService.findById(movieId);
		return new ResponseEntity<Optional<Movie>>(movie, HttpStatus.OK);

	}

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Movie> updateById(@PathVariable int movieId, @RequestBody Movie movie) {
		Movie movieObj = movieService.updateMovie(movieId, movie);
		return new ResponseEntity<Movie>(movieObj, HttpStatus.OK);

	}
//	@RequestMapping(value="searchName/movie/{mname}" , method=RequestMethod.GET , produces="application/json")
//	   public ResponseEntity<?> getMovieByName(@PathVariable String mname){
//	       List<Movie> movieList = movieService.getMovieByName(mname);
//	       return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
//	   }
}
