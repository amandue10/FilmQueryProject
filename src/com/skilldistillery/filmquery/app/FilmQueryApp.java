package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);

		Actor actor = db.findActorById(1);
		System.out.println(actor);

		List<Actor> findActor = db.findActorsByFilmId(1);
		System.out.println(findActor);

	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean continueApp = true;
		do {

			// todo application logic: menu, user input, etc
			System.out.println("Press 1 to look up a film by it's id");
			System.out.println("Press 2 to look up a film by a search keyword.");
			System.out.println("Press 3 to exit the application");
			int userInput = input.nextInt();

			switch (userInput) {
			case 1:
				searchByFilmId(input);
				break;
			case 2:
				searchByFilmKeyword(input);
				break;
			case 3:
				System.out.println("You chose to exit");
				System.out.println("Goodbye");
				continueApp = false;
				break;
			}
		} while (continueApp);

	}

	private void searchByFilmId(Scanner input) {
		Film searchResult = null;
		System.out.println("-----Search by Film ID----");
		System.out.println("Enter Film ID (ex: 123)");
		System.out.println("Example: 123)");
		System.out.println("-------------------------");

		try {
			searchResult = db.findFilmById(input.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("Invalid entry. Ids are in number format");
		} finally {
			input.nextLine();
		}

		if (searchResult == null)
			System.out.println("No result found");
		else
			System.out.println(searchResult);
	}

	private void searchByFilmKeyword(Scanner input) {
		System.out.println("Enter search keyword: ");

		List<Film> filmsQueryResult = db.findFilmByKeyword(input.next());
		if (!filmsQueryResult.isEmpty()) {

			for (Film film : filmsQueryResult) {
				System.out.println(film);

			}
		} else
			System.out.println("No results found");
	}
}
