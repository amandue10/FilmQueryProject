package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
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
				break;
			case 2:
				break;
			case 3:
				System.out.println("You chose to exit");
				System.out.println("Goodbye");
				continueApp = false;
				break;
			}
		} while (continueApp);

	}

}
