import java.util.Random;
import java.util.Scanner;

public class Main {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 100;

	public static void main(String[] args)  {
		try (Scanner sc = new Scanner(System.in)){
			int randNum = new Random().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
			System.out.println("Game is started! Try to guess the number or type 'exit' to quit.");
			playGame(randNum, sc);
		}
	}

	public static void playGame(int guessingNumber,Scanner sc) {
		while(true){
			String command = getNextCommand(sc);
			if (command.equals("exit")){ System.out.println("Goodbye! The correct number was: " + guessingNumber); break; }
			try {
				int numberOfPlayer = Integer.parseInt(command);
				if (guessingNumber == numberOfPlayer) { System.out.println("Congratulations! You win!"); break; }
				if (guessingNumber > numberOfPlayer) { System.out.println("Too low");}
				if (guessingNumber < numberOfPlayer) { System.out.println("Too high");}
			}catch (NumberFormatException e){
				System.out.println("Invalid command");
			}
		}
	}

	public static String getNextCommand(Scanner sc){
		return sc.nextLine();
	}
}
