import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardGame2 {
    //Deck and hands for player and AI
    private ArrayList<Card> deck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> aiHand;
    private ArrayList<Card> playerBench;
    private ArrayList<Card> aiBench;
    private ArrayList<Card> aiPrizePile;
    private ArrayList<Card> playerPrizePile;
    private boolean player1;
    private Scanner in;

    public CardGame2() {
        //Initializes collections and game state
        deck = new ArrayList<>();
        playerHand = new ArrayList<>();
        playerBench =new ArrayList<>();
        playerPrizePile= new ArrayList<>();
        aiHand=new ArrayList<>();
        aiBench= new ArrayList<>();
        aiPrizePile= new ArrayList<>();
        player1=true;
        in= new Scanner(System.in);
    }

    public void fillDeck() {
        // Add 15 Energy cards
        for (int i = 0; i < 15; i++) {
            deck.add(new Energy());
        }
        // Add Pokémon cards (3-5)
        deck.add(new Charmander());
        deck.add(new MagiKarp());
        deck.add(new Pikachu());
        deck.add(new Mimikyu());
        deck.add(new Ditto());

        // Add Trainer cards
        for (int i = 0; i < 10; i++) {
            deck.add(new TrainerCard("Bill"));
            deck.add(new TrainerCard("Disadvantage"));
        }

    }
    //Draws the initial hand
    public void drawHand(ArrayList<Card> hand) {
        Random rng = new Random();
        hand.clear();
        for (int i = 0; i < 7; i++) {
            if(deck.isEmpty()) break;
            int cardToTakeIndex = rng.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }
    //Draw prize pile
    public void drawPrizePile(ArrayList<Card> prizePile){
        Random rand=new Random();
        prizePile.clear();
        for (int i=0; i< 6; i++){
           if (deck.isEmpty()) break;
           int cardTakeIndex= rand.nextInt(deck.size());
           prizePile.add(deck.get(cardTakeIndex));
           deck.remove(cardTakeIndex);
        }
    }
   //Checks hand to see if it contains at least one Pokemon
    public boolean cardChecker(ArrayList<Card> hand) {
        for (Card singleCard : hand) {
            if (singleCard instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }
   //Reshuffle and redraw hand until a pokemon is found
    public void reshuffleCards(ArrayList<Card> hand) {
        while (!cardChecker(hand)) {
            deck.addAll(hand);
            hand.clear();
            drawHand(hand);
        }
    }
    //Players turn with available actions
public void playerTurn(){
       System.out.println("Your Turn!");
       for (int i=0; i<playerHand.size();i++){
           System.out.println(i+1+". "+playerHand.get(i));
       }
       System.out.println("Choose action: 1) Draw card 2) Play Card 3) Bench 4) Pass");
       int choice = in.nextInt();
       in.nextLine();

       switch (choice){
           case 1:
               drawCard(playerHand);
               break;
           case 2:
               System.out.println("Choose a card to play: ");
               int cardIndex=in.nextInt()-1;
               if (cardIndex>=0&&cardIndex<playerHand.size()){
                   Card played= playerHand.remove(cardIndex);
                   System.out.println("You played: "+played);
                   if (played instanceof TrainerCard && ((TrainerCard)played).getAbility().equals("Disadvantage")){
                       disrupt();
                   }
               }else {
                   System.out.println("Invalid choice.");
               }
               break;
           case 3:
              System.out.println("Choose a card to bench: ");
              int benchIndex= in.nextInt()-1;
              if (benchIndex >=0 && benchIndex<playerHand.size()){
                  playerBench.add(playerHand.remove(benchIndex));
                  System.out.println("Card Benched");
              }else {
                  System.out.println("Invalid choice");
              }break;
           case 4:
               System.out.println("You passed your turn.");

           default:
               System.out.println("invalid action.");
       }
}
//Forces opponent to draw or reshuffle based on the trainer card
public void disrupt(){
        ArrayList<Card> opponent=player1 ? aiHand: playerHand;
        System.out.println("Opponent must choose: 1. Bill 2. Professor Sycamore");
        int choice= new Random().nextInt(2)+1;
        if (!player1){
            System.out.println("AI chooses option: "+choice);
        }
        if (choice == 1){
            drawCard(opponent);
            drawCard(opponent);
        }else {
            deck.addAll(opponent);
            opponent.clear();
            drawHand(opponent);
        }
}
//Ai logic
public void aiTurn(){
        System.out.println("AI's turn");
        if (deck.size()>0){
            drawHand(aiHand);
        System.out.println("AI drew a card.");
        }else {
            System.out.println("Deck is empty");
            endGame();
        }
}
//Draws a single card from the deck
public void drawCard(ArrayList<Card>hand){
        if (!deck.isEmpty()){
            hand.add(deck.remove(0));
        }else {
            endGame();
        }
}
//ends the game when the deck is empty
public void endGame(){
        System.out.println("There are no more cards in the deck. Game over!");
        System.exit(0);
}

//Runs the game
    public void run() {
        fillDeck();
        drawHand(playerHand);
        reshuffleCards(playerHand);
        drawHand(aiHand);
        reshuffleCards(aiHand);

        while (true){
            if (player1){
                playerTurn();
            }else{
                aiTurn();
            }
            player1= !player1;
        }
    }

    public static void main(String[] args) {
        CardGame2 game = new CardGame2();
        game.run();
    }
}
