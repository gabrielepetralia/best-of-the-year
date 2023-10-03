package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.app.pojo.Movie;
import org.java.app.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
//		final String movies = getBestMovies().stream()
//	            .map(Movie::getTitle)
//	            .reduce((s1, s2) -> s1 + ", " + s2)
//	            .orElse("");
//		
//		String indexButtons = "";
//		
//		for(int i=0; i<getBestMovies().size(); i++) {
//			final String button = "<li class='mx-2'><a class='btn btn-danger text-white' href='media/movies/" + i + "'>" + (i + 1) + "</a></li>";
//			indexButtons += button;
//		}
//	
//		model.addAttribute("indexButtons", indexButtons);

		model.addAttribute("movies", getBestMovies());
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String songs(Model model) {
//		final String songs = getBestSongs().stream()
//	            .map(Song::getTitle)
//	            .reduce((s1, s2) -> s1 + ", " + s2)
//	            .orElse("");
//		
//		String indexButtons = "";
//		
//		for(int i=0; i<getBestSongs().size(); i++) {
//			final String button = "<li class='mx-2'><a class='btn btn-danger text-white' href='media/songs/" + i + "'>" + (i + 1) + "</a></li>";
//			indexButtons += button;
//		}
//		
//		model.addAttribute("indexButtons", indexButtons);
		model.addAttribute("songs", getBestSongs());
		
		return "songs";
	}
	
	@GetMapping("/media/{type}/{id}")
	public String getMovieSongById(@PathVariable String type, @PathVariable int id, Model model) {
		final String name = "Gabriele Petralia";
		model.addAttribute("name", name);
		
		if(type.equals("movies")) {
			
			List<Movie> movies = getBestMovies();
			final String title = movies.get(id).getTitle();
			
			final String type2 = "movie";
			
			model.addAttribute("type", type);
			model.addAttribute("type2", type2);
			model.addAttribute("id", id);
			model.addAttribute("title", title);
			
			return "movie-song-by-id";
			
		} 
		
		if(type.equals("songs")) {
			
			List<Song> songs = getBestSongs();
			final String title = songs.get(id).getTitle();
			
			final String type2 = "song";
			
			model.addAttribute("type", type);
			model.addAttribute("type2", type2);
			model.addAttribute("id", id);
			model.addAttribute("title", title);
			
			return "movie-song-by-id";
			
		}
			
		return "index";
	}
}
