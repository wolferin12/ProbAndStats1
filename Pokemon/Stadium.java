public class Stadium {
    public void battle(Pokemon p1, Pokemon p2){
     
        //p1 attacks p2 subtract from hp the difference of attack and defense
       

        boolean playersTurn= p1.getSpeed() >= p2.getSpeed();
        while (p1.getHp()>0 && p2.getHp()>0){
            if (playersTurn){
                int damage= Math.max(0, p1.getAttack()- p2.getDefense());
                p2.setHp(p2.getHp() - damage);
                //System.out.println(p2+"HP:"+p2.getHp());

            }else {
                int damage= Math.max(0, p2.getHp()- p1.getDefense());
                p1.setHp(p1.getHp()-damage);
                //System.out.println(p1 +"HP:"+p1.getHp());
            }
        }

        playersTurn= !playersTurn;

        if (p1.getHp() <=0 && p2.getHp() <=0){
            System.out.println("Draw");
        }else if (p1.getHp() <=0){
            System.out.println(p2 + " Wins!");
        }else {
            System.out.println(p1 + " Wins!");
        }

        }
    }

