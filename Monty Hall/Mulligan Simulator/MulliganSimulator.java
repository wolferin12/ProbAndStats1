import java.util.Random;

public class MulliganSimulator {
    private static int cardTotal=60;
    private static int sizeOfHand=7;
    private static int simulator=10000;

    public static void main(String[] args) {
        System.out.println("" +
                "Pokemon \tMulligan Probability (%)");
        for (int countofPokemon=1; countofPokemon <= cardTotal; countofPokemon++){
            double mulliganProb= mulliganSimulator(countofPokemon);
            System.out.printf("%d\t\t\t%.2f%%\n", countofPokemon, mulliganProb);
        }
    }
    private static double mulliganSimulator(int countOfPokemon){
        int mulliganCount=0;
        Random variable= new Random();
        for (int i=0; i<simulator; i++){
            int inHandPokemon =0;
            for (int j=0; j<sizeOfHand; j++){
                if (variable.nextInt(cardTotal)<countOfPokemon){
                    inHandPokemon++;
                }
            }
            if (inHandPokemon ==0){
                mulliganCount++;
            }
        }
        return (mulliganCount/((double)simulator)*100);
    }

}
