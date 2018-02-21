package warsztaty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Symulator Lotto. \nPodaj 6 liczb z zakresu 1-49. ");
		ArrayList<Integer> userNumbers = new ArrayList<Integer>();
		
		for (int i = 0; i < 6; i++) {
			try {
				int numCount = i+1;
				System.out.println("Podaj "+numCount+" liczbę: ");
				Integer usersChoice = scan.nextInt();
				if(usersChoice < 1 || usersChoice > 49) {
					System.out.println("Liczba spoza zakresu. ");
					i--;
				} else if(userNumbers.contains(usersChoice)){
					System.out.println("Te liczbe już podałeś. ");
					i--;
				} else {
					userNumbers.add(usersChoice);
				}
			} catch (InputMismatchException e) {
				System.err.println("Złe dane wejściowe. Spróbuj jeszcze raz. ");
				scan.next();
				i--;
			}
		}
		Collections.sort(userNumbers);
		System.out.println("Twoje liczby rosnąco: "+Arrays.asList(userNumbers).toString());
		
		Random rand = new Random();
		ArrayList<Integer> randNumbers = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			randNumbers.add(rand.nextInt((49-1)+1)+1);
		}
		System.out.println("Wynik losowania: "+Arrays.asList(randNumbers).toString());
		
		int score = 0;
		for (Integer randNum : randNumbers) {
			for (Integer userNum : userNumbers) {
				if(randNum == userNum) {
					score++;
				}
			}
		}
		
		System.out.println("Zgadłeś "+score+" liczb. ");
		if(score > 2) {
			System.out.println("Udało Ci się. ");
		} else {
			System.out.println("Dupa, nic nie wygrywasz. ");
		}
	}
}
