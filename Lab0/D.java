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
        int[][] m = new int[4][10]; // (1)

        for(int i=0 ; i < 14 ; i++){ // (2)
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

    public static boolean checkQuetou(int[][] m){
        for(int i=0 ; i<4 ; i++){
            for(int j=1 ; j<10 ; j++){
                if(m[i][j] >= 2){
                    m[i][j] -= 2 ;
                    m[i][0] -= 2 ;
                    if(checkKeziShunzi(m)){ return true ;} //WIN
                    m[i][j] += 2 ;
                    m[i][0] += 2 ;
                }
            }
        }
        return false ;
    }

    public static boolean checkKeziShunzi(int[][] m){
        for(int i=1 ; i<10 ; i++){ //check zi
            if(m[3][i]%3 != 0) {
                return false ;
            }
        }
        for(int i=0 ; i<3 ; i++){ //check w b z
            if(!checkWBZ(m[i])){
                return false ;
            }
        }
        return true;
    }

    public static boolean checkWBZ(int[] wbz){
        if(wbz[0] == 0){ //base case
            return true;
        }
        for(int i=0 ; i<10 ; i++){
            if(wbz[i] >= 3){
                wbz[i] -= 3 ;
                wbz[0] -= 3 ;
                if (checkWBZ(wbz)){return true ;}
                wbz[i] += 3 ;
                wbz[0] += 3 ;
            }
            if(wbz[i]>=1 && i<=7 && wbz[i+1]>=1 && wbz[i+2]>=1){
                wbz[i] -= 1 ;
                wbz[i+1] -= 1 ;
                wbz[i+2] -= 1 ;
                if (checkWBZ(wbz)){return true ;}
                wbz[i] += 1 ;
                wbz[i+1] += 1 ;
                wbz[i+2] += 1 ;
            }
        }
        return false ;
    }

}
