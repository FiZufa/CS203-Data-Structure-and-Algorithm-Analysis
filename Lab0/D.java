import java.util.Scanner;

public class D {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        String[] m = new String[cases] ;
        String[] answer = new String[cases];
        for(int i=0 ; i<cases ; i++){
            m[i] = in.next();
        }

        for(int i=0 ; i<cases ; i++){
            answer[i] = mahjongArr(m[i]);
            System.out.println(answer[i]);
        }


    }
    public static String mahjongArr(String str){
        int[][] m = new int[4][10]; // (1) create an array

        for(int i=0 ; i < 14 ; i++){ // (2) store to the value according to the number and suit
            switch (str.charAt(i*2+1)){  
                case 'w' :
                    m[0][str.charAt(i*2) - 48]++ ;
                    m[0][0]++ ;
                    break;
                case 'b' :
                    m[1][str.charAt(i*2) - 48]++ ;
                    m[1][0]++ ;
                    break;
                case 's' :
                    m[2][str.charAt(i*2) - 48]++ ;
                    m[2][0]++ ;
                    break;
                case 'z' :
                    m[3][str.charAt(i*2) - 48]++ ;
                    m[3][0]++ ;
                    break;
            }

        }
       if(checkQuetou(m)){ 
           return "Blessing of Heaven";
       } else {
           return "Bad Luck" ;
       }
    }

    public static boolean checkQuetou(int[][] m){ // function to remove possible Quetou, connected with checkKeziShunzi(m)
        for(int i=0 ; i<4 ; i++){
            for(int j=1 ; j<10 ; j++){
                if(m[i][j] >= 2){ // (3)-(4) if possible Quetou exist, remove them
                    m[i][j] -= 2 ;
                    m[i][0] -= 2 ;
                    if(checkKeziShunzi(m)){ return true ;} //WIN
                    m[i][j] += 2 ; // if checkKeziShunzi(m) false, get the Quetou back to the original position -> do next iteration
                    m[i][0] += 2 ;
                }
            }
        }
        return false ; // there's no possible Quetou anymore
    }

    public static boolean checkKeziShunzi(int[][] m){ // (5) - (6)
        for(int i=1 ; i<10 ; i++){ //check zi
            if(m[3][i]%3 != 0) {
                return false ; // Zi doesn't satisfy Shunzi, return false
            }
        }
        for(int i=0 ; i<3 ; i++){ //check w b z
            if(!checkWBS(m[i])){
                return false ; // w b s doen't satisfy Kezi and Shunzi, return false
            }
        }
        return true; // w b s doesn't satisfy
    }

    public static boolean checkWBS(int[] wbs){ // (7) check w b s
        if(wbs[0] == 0){ //base case
            return true;
        }
        for(int i=0 ; i<10 ; i++){ 
            if(wbs[i] >= 3){    // check Kezi
                wbs[i] -= 3 ;
                wbs[0] -= 3 ;
                if (checkWBS(wbs)){return true ;}
                wbs[i] += 3 ; // if false get shunzi back
                wbs[0] += 3 ;
            }
            if(wbs[i]>=1 && i<=7 && wbs[i+1]>=1 && wbs[i+2]>=1){ // check Shunzi
                wbs[i] -= 1 ;
                wbs[i+1] -= 1 ;
                wbs[i+2] -= 1 ;
                if (checkWBS(wbs)){return true ;}
                wbs[i] += 1 ; // if false get shunzi back
                wbs[i+1] += 1 ;
                wbs[i+2] += 1 ;
            }
        }
        return false ; // false if the array still has tiles  
    }

}
