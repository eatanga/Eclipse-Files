package dmacc.beans;

import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {
	private String player1;
	private String computerPlayer;
	private String winner;

public Game(String player1) {
	super();
	this.player1 = player1;
	this.setComputerPlayerToRandom();
	this.determineWinner();
		}

public void setComputerPlayerToRandom() {
	Random rand = new Random();
	int n = rand.nextInt(5);

	if(n==0)

		this.setComputerPlayer("rock");

	else if(n==1)

		this.setComputerPlayer("paper");
	
	else if(n==2)
		this.setComputerPlayer("scissors");
	
	else if(n==3)
		
		this.setComputerPlayer("lizard");
		
	else

		this.setComputerPlayer("spock");
	
	
}

public void determineWinner() {
	String winner = "Nobody";
		
	if(player1.equals("rock") && computerPlayer.equals("rock"))
		this.setWinner(winner);
	else if(player1.equals("rock") && computerPlayer.equals("paper"))
		this.setWinner(computerPlayer);
	else if(player1.equals("rock") && computerPlayer.equals("scissors"))
		this.setWinner(player1);
	else if(player1.equals("rock") && computerPlayer.equals("lizard"))
		this.setWinner(player1);
	else if(player1.equals("rock") && computerPlayer.equals("spock"))
		this.setWinner(computerPlayer);
	else if(player1.equals("paper") && computerPlayer.equals("rock"))
		this.setWinner(player1);
	else if(player1.equals("paper") && computerPlayer.equals("paper"))
		this.setWinner(winner);
	else if(player1.equals("paper") && computerPlayer.equals("scissors"))
		this.setWinner(computerPlayer);
	else if(player1.equals("paper") && computerPlayer.equals("lizard"))
		this.setWinner(computerPlayer);
	else if(player1.equals("paper") && computerPlayer.equals("spock"))
		this.setWinner(player1);
	else if(player1.equals("scissors") && computerPlayer.equals("rock"))
		this.setWinner(computerPlayer);
	else if(player1.equals("scissors") && computerPlayer.equals("paper"))
		this.setWinner(player1);
	else if(player1.equals("scissors") && computerPlayer.equals("scissors"))
		this.setWinner(winner);
	else if(player1.equals("scissors") && computerPlayer.equals("lizard"))
		this.setWinner(player1);
	else if(player1.equals("scissors") && computerPlayer.equals("spock"))
		this.setWinner(computerPlayer);
	else if(player1.equals("lizard") && computerPlayer.equals("rock"))
		this.setWinner(computerPlayer);
	else if(player1.equals("lizard") && computerPlayer.equals("paper"))
		this.setWinner(player1);
	else if(player1.equals("lizard") && computerPlayer.equals("scissors"))
		this.setWinner(computerPlayer);
	else if(player1.equals("lizard") && computerPlayer.equals("lizard"))
		this.setWinner(winner);
	else if(player1.equals("lizard") && computerPlayer.equals("spock"))
		this.setWinner(player1);
	else if(player1.equals("spock") && computerPlayer.equals("rock"))
		this.setWinner(player1);
	else if(player1.equals("spock") && computerPlayer.equals("paper"))
		this.setWinner(computerPlayer);
	else if(player1.equals("spock") && computerPlayer.equals("scissors"))
		this.setWinner(player1);
	else if(player1.equals("spock") && computerPlayer.equals("lizard"))
		this.setWinner(computerPlayer);
	else if(player1.equals("spock") && computerPlayer.equals("spock"))
		this.setWinner(winner);

	}
}
