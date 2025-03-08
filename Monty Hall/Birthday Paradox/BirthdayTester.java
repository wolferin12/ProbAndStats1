

public class BirthdayTester{
    private static boolean hasBirthdayMatch(int classNumber){
        Person[] room = new Person[classNumber];
        boolean [] birthday= new boolean[365];

        for (int i=0; i<classNumber; i++){
            room [i]= new Person();
            int birth= room[i].birthday;

            if (birthday[birth-1]){
                return true;
            }else {
                birthday[birth-1]=true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
      int classNumber= 35;
      int trial= 10;

      int collection=0;
      for (int i=0; i<trial; i++){
          if(hasBirthdayMatch(classNumber)){
              collection++;
          }
      }
      double prob = (double) collection/trial;

      System.out.println("The Probability of two people sharing a birthday in a room of "+classNumber+": ");
      System.out.println(prob*100+ "%");

    }

}
