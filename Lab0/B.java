import java.util.Scanner;

public class B {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String dealer = in.next();
        String[] hand = new String[5];

        for(int i=0 ; i<hand.length ; i++){
            hand[i] = in.next();
        }
        boolean isFold = false ;
        for(int i=0 ; i< hand.length ; i++){
            if(hand[i] == dealer || hand[i].charAt(0) == dealer.charAt(0) || hand[i].charAt(1) == dealer.charAt(1)){
                isFold = true;
                break;
            }
        }

        if(isFold){
            System.out.print("All in");
        } else {
            System.out.print("Fold");
        }
    }
}
