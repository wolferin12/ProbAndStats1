import java.util.Random;
/*
  Created by Erin Wolf
 */
public class MontyHall {
    private Random byron = new Random();
    private int gameTotal;

    public MontyHall(int gameTotal){
        this.gameTotal=gameTotal;
    }
    public double simulation(boolean doorChange){
        //Counter for the game wins
        int wins=0;
        for (int i=0; i<gameTotal; i++){
            //initializes the 3 door, one of which will have a prize
            Door[]doors= {new Door(false), new Door(false), new Door(false)};
            int winnerDoor= byron.nextInt(3);
            doors[winnerDoor]= new Door(true);
            //Contestant chooses a door from 1-3
            int doorChosen= byron.nextInt(3);
            //The reveal of a non winning door by the host
            int doorRevealed;
            do {
                doorRevealed= byron.nextInt(3);
            } while (doorRevealed == doorChosen || doors[doorRevealed].Prize());

            //Contestant switches to the remaining door if allowed
            if (doorChange){
                for (int j=0; j<3; j++){
                    if (j != doorChosen && j != doorRevealed){
                        doorChosen =j;
                        break;
                    }
                }
            }
            //Checks to see if the final door choice for the contestant is the winning door
            if (doors[doorChosen].Prize()){
                wins++;
            }
        }
        //Returns the Percentage of game wins
        return (double) wins/gameTotal *100;
    }
}
