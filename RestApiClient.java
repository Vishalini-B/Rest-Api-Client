package tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class RestApiClient {

	// ── Fetch JSON from API ──────────────────────────
	public static String getResponse(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);

			int responseCode = conn.getResponseCode();

			if (responseCode == 200) {
				BufferedReader reader = new BufferedReader(
					new InputStreamReader(conn.getInputStream())
				);
				StringBuilder json = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					json.append(line);
				}
				reader.close();
				return json.toString();

			} else if (responseCode == 404) {
				System.out.println("Error: Pokemon not found. Please check the name or ID.");
			} else {
				System.out.println("Error: Server returned code " + responseCode);
			}

		} catch (MalformedURLException e) {
			System.out.println("Error: Invalid URL format.");

		} catch (UnknownHostException e) {
			System.out.println("Error: No internet connection. Please check your network.");

		} catch (Exception e) {
			System.out.println("Error: Something went wrong — " + e.getMessage());
		}

		return null;
	}

	// ── Extract value from JSON ──────────────────────
	public static String extract(String json, String key) {
		try {
			String search = "\"" + key + "\":";
			int i = json.indexOf(search);
			if (i == -1) return "N/A";
			i += search.length();
			if (json.charAt(i) == '"') {
				int end = json.indexOf('"', i + 1);
				return json.substring(i + 1, end);
			}
			int end = i;
			while (end < json.length() && Character.isDigit(json.charAt(end))) end++;
			return json.substring(i, end);

		} catch (Exception e) {
			return "N/A";
		}
	}

	// ── Display Pokemon Details ──────────────────────
	public static void display(String data) {
		try {
			System.out.println("\n--- Pokemon Details ---");
			System.out.println("ID     : " + extract(data, "id"));
			System.out.println("Name   : " + extract(data, "name"));
			System.out.println("Height : " + extract(data, "height") + " dm");
			System.out.println("Weight : " + extract(data, "weight") + " hg");
			System.out.println("Exp    : " + extract(data, "base_experience"));
			System.out.println("-----------------------");

		} catch (Exception e) {
			System.out.println("Error: Could not display Pokemon details.");
		}
	}

	// ── Main Menu ────────────────────────────────────
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice = 0;

		System.out.println("================================");
		System.out.println("   Pokemon REST API Client");
		System.out.println("================================");

		do {
			try {
				System.out.println("\n1. Search Pokemon");
				System.out.println("2. Exit");
				System.out.print("Enter choice: ");

				choice = Integer.parseInt(sc.nextLine().trim());

				if (choice == 1) {
					System.out.print("Enter Pokemon name or ID: ");
					String name = sc.nextLine().trim().toLowerCase();

					if (name.isEmpty()) {
						System.out.println("Error: Input cannot be empty. Try again.");
						continue;
					}

					String url  = "https://pokeapi.co/api/v2/pokemon/" + name;
					String data = getResponse(url);

					if (data != null) {
						display(data);
					}

				} else if (choice == 2) {
					System.out.println("Goodbye!");

				} else {
					System.out.println("Error: Please enter 1 or 2 only.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Error: Invalid input. Please enter a number.");

			} catch (Exception e) {
				System.out.println("Error: Unexpected issue — " + e.getMessage());
			}

		} while (choice != 2);

		sc.close();
	}
}