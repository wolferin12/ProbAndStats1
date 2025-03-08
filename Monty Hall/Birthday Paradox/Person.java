import java.util.Random;

public class Person  {
    int birthday;


    public Person (){
        Random var = new Random();
        birthday= var.nextInt(365)+1;
    }
}
