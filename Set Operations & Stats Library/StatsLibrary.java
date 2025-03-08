import java.util.ArrayList;
import java.util.Arrays;


public class StatsLibrary {

    static int getMode(int[] m, int v){
        int valueMax=0;
        int countMax=0;

        for (int i=0; i<v; i++){
            int counter=0;
            for (int j=0; j<v; j++){
                if (m[j]==m[i])
                    counter++;
            }
           if (counter>countMax){
               countMax=counter;
               valueMax=m[i];
           }
        }
        return valueMax;
    }
    static int getMedian(int[] math ){
        if (math.length%2==0){
            int middle=math.length/2;
            return (math[middle]+math[middle-1])/2;
        }
        return math[math.length/2];
    }
    static double getStandardDeviation(double[]fun){
        double total=0.0;
        for(double i: fun){
            total+=i;
        }
        int length = fun.length;
        double mean= total/length;

        double standardDeviation =0.0;
        for (double var: fun){
            standardDeviation += Math.pow(var - mean, 2);
        }
        return Math.sqrt(standardDeviation/length);
    }
    static int Factorial(int b){
        int factorial=1;
        int e=1;
        while (e <= b){
            factorial *=e;
            e++;
        }
        return factorial;
    }

    public static void main(String[] args) {

        ArrayList<Integer> listOfNumbers= new ArrayList<>();
        for (int i=0; i<100; i++){
            listOfNumbers.add(i);
        }
        int sum=0;
        for (int singleNumber : listOfNumbers){
            sum=sum+singleNumber;
        }
        System.out.println("Mean: "+sum/(double)listOfNumbers.size());

        double mean= sum/(double)listOfNumbers.size();
        
        int[] math= {2,10,20,28,30,32,45};
        System.out.println("Median: "+getMedian(math));

        int[] vam= {0,29,29,73,89};
        int v=5 ;
        System.out.println("Mode: "+getMode(vam,v));

        double [] fun={34, 5, 6, 90, 30, 45, 39,29};
        System.out.println("Standard Deviation:" + getStandardDeviation(fun));

        int b= 7;
        int y= 3;
        int combination;
        int permutation;
        permutation= Factorial(b)/Factorial(b-y);
        System.out.println("Permutation: "+permutation);
        combination= Factorial(b)/(Factorial(y)*Factorial(b-y));
        System.out.println("Combination: "+combination);
        double p= .30;
        double q= 1-p;
        double biDistribution= combination*Math.pow(p,y)*Math.pow(q,n-y);
        double geoDistribution= Math.pow(q, y-1)*p;
        System.out.println("Binomial Distribution: "+String.format("%.3f",biDistribution));
        System.out.println("Geometric Probability Distribution: "+String.format("%.3f",geoDistribution));

    }
}
