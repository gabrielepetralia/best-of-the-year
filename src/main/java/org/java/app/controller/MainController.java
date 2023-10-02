package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.app.pojo.Movie;
import org.java.app.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		final String name = "Gabriele Petralia";
		model.addAttribute("name", name);
		
		return "index";
	}
	
	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();
		
        movies.add(new Movie(1, "The Notebook"));
        movies.add(new Movie(2, "Forrest Gump"));
        movies.add(new Movie(3, "Interstellar"));
        movies.add(new Movie(4, "Titanic"));
        movies.add(new Movie(5, "Avengers"));
		
		return movies;
	}
	
	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();
		 
        songs.add(new Song(1, "Bohemian Rhapsody"));
        songs.add(new Song(2, "Imagine"));
        songs.add(new Song(3, "Can't Help Falling in Love"));
        songs.add(new Song(4, "Let It Be"));
        songs.add(new Song(5, "Sweet Child O'Mine"));
	        
		return songs;
	}
	
	@GetMapping("/movies")
	public String movies(Model model) {
		final String movies = getBestMovies().stream()
	            .map(Movie::getTitle)
	            .reduce((s1, s2) -> s1 + ", " + s2)
	            .orElse("");
		
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String songs(Model model) {
		final String songs = getBestSongs().stream()
	            .map(Song::getTitle)
	            .reduce((s1, s2) -> s1 + ", " + s2)
	            .orElse("");
		
		model.addAttribute("songs", songs);
		
		return "songs";
	}
}
