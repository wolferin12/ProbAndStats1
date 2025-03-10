import java.sql.Statement;

public class PokemonTester {
    public static void main(String[] args) {
        Charmander Steve = new Charmander();
        Pikachu bill = new Pikachu();
        Stadium tester = new Stadium();
        Ditto Byron = new Ditto();
        Mimikyu Mim = new Mimikyu();
        //MagiKarp fish= new MagiKarp();

       tester.battle(bill, Steve);

    }
}
