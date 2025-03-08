/*
  Created by Erin Wolf
 */
public class MontyHallTester {
    public static void main(String[] args) {
        MontyHall game = new MontyHall(10000);
        System.out.println("Win rate without switching:"+ (double)game.simulation(false)+"%");
        System.out.println("Win rate with switching:"+ (double)game.simulation(true)+"%");
    }
}

