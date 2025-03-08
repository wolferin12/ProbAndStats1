import java.util.ArrayList;

public class SetOperations
{
    public static ArrayList<Integer> intersection (int[]list1, int[]list2){
        ArrayList<Integer>outcome= new ArrayList<>();
        int i=0;
        int b=0;

        while (i<list1.length&&b<list2.length){
            if (list1[i] == list2[b]) {
                outcome.add(list1[i]);
                i++;
                b++;
            } else if (list1[i]<list2[b]){
                i++;
            }else {
                b++;
            }
        }
        return outcome;
    }
    public static void getUnion(int [] list1, int [] list2, int v, int x){
        int i=0;
        int b=0;

        while(i<v && b<x){
            if (list1[i] < list2[b]) {
                System.out.print(list1[i++]+", ");
            } else if (list1[i] > list2[b]) {
                System.out.print(list2[b++]+", ");
            }else{
                System.out.print(list1[i++]+", ");
                b++;
            }
        }
        while(i<v){
            System.out.print(list1[i++]+", ");
        }
        while (b<x){
            System.out.print(list2[b++]+", ");
        }
    }
    static void Complement (int [] list1, int [] list2, int z, int q ){
       int y=0;
       int w=0;

       while(y<z&&w<q){
           if(list1[y]<list2[w]){
               System.out.print(list1[y]+", ");
               y++;
           }else if (list1[y]>list2[w]){
               w++;
           } else if (list1[y]==list2[w]){
               y++;
               w++;
           }
       }
       while(y<q){
           System.out.print(list1[y]+" ");
           y++;
       }
    }
    public static void main(String[] args) {
        int [] list1={2,4,5,6,9,10};
        int [] list2={3,4,5,7,9,20};
       ArrayList<Integer>intersection=intersection(list1,list2);
       System.out.println("Intersections of the arrays: "+intersection);

       int v=list1.length;
       int x=list2.length;
       int z=list1.length;
       int q=list2.length;

       System.out.print("Union of the arrays: ");
       getUnion(list1,list2,v,x);

       System.out.print("\n"+"Complement of the arrays: ");
       Complement(list1,list2,z,q);
    }

}
