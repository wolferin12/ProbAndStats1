import java.util.Random;

public class RareCandy {
    private static final int cardTotal = 60;
    private static final int sizeOfHand= 7;
    private static final int cardPrize = 6;
    private static final int  simulator= 10000;

    public static void main(String[] args) {
        System.out.println("Rare Candies\tProbability All in Prize Pile (%)");
       //loop to calculate and display the probability for 1 to 4 rare candy cards
        for (int rareCandy = 1; rareCandy <= 4; rareCandy++) {
            //Calculate the probability for the current number of rare candies
            double probability = simulateRareCandyProbability(rareCandy);
            System.out.printf("%d\t\t\t%.2f%%\n", rareCandy, probability);
        }
    }
   //Simulates the probability of all rare candies being in the prize pile
    private static double simulateRareCandyProbability(int rareCandy) {
        int allInPrizeCount = 0;
        Random random = new Random();
        int[] deck = new int[cardTotal];

        for (int i = 0; i < simulator; i++) {
            initializeDeck(deck, rareCandy);
            shuffleDeck(deck, random);

            if (!containsPokemon(deck, 0, sizeOfHand)) continue; // Ensure at least one Pokémon in hand

            if (containsAllRareCandies(deck, sizeOfHand, sizeOfHand + cardPrize, rareCandy)) {
                allInPrizeCount++;
            }
        }

        return (allInPrizeCount / (double) simulator) * 100;
    }
    //Initializes deck with specified number of rare candy cards 
    private static void initializeDeck(int[] deck, int rareCandy) {
        for (int i = 0; i < cardTotal; i++) {
            deck[i] = 0; // Default all cards to non-Pokémon and non-Rare Candy
        }

        for (int i = 0; i < 10; i++) {
            deck[i] = 1; // Assign at least 10 Pokémon
        }

        for (int i = 0; i < rareCandy; i++) {
            deck[10 + i] = 2; // Assign Rare Candy cards
        }
    }
    //Shuffles deck
    private static void shuffleDeck(int[] deck, Random random) {
        for (int i = cardTotal - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
   //Checks to see if the deck contains at least one pokemon
    private static boolean containsPokemon(int[] deck, int start, int end) {
        for (int i = start; i < end; i++) {
            if (deck[i] == 1) return true;
        }
        return false;
    }
    //Checks is the specified range of the deck contains all rare candies
    private static boolean containsAllRareCandies(int[] deck, int start, int end, int rareCandy) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (deck[i] == 2) count++;
        }
        return count == rareCandy;
    }
}

