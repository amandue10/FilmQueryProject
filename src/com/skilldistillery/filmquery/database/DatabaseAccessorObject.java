package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";

	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading database driver:");
			System.err.println(e);
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, "
					+ " rental_rate, length, replacement_cost, rating, special_features " + " FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				film = new Film();
				film.setid(rs.getInt(1));
				film.setTitle(rs.getString(2));
				film.setDescription(rs.getString("description"));
				film.setreleaseYear(rs.getInt("release_year"));
				film.setlanguageId(rs.getInt("language_id"));
				film.setrentalDuration(rs.getInt("rental_duration"));
				film.setrentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setreplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setspecialFeatures(rs.getString("special_features"));

//				call findActorByFIlmId(filmId)
//				

			}
		} catch (SQLException e) {
			System.err.println("Database error:");
			System.err.println(e);
		}

		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

}