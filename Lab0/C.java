import java.util.Scanner;

public class C {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
           int x1 = in.nextInt();
           int y1 = in.nextInt();
           int x2 = in.nextInt();
           int y2 = in.nextInt();
           int M = in.nextInt();

           System.out.print(ways(x1, y1, x2, y2, M));

    }

    public static long ways(int x1, int y1, int x2, int y2, int M){
        int x = x2-x1; // (1) --> O(1)
        int y = y2-y1; // (1) --> O(1)
        long[][] arr = new long[x+1][y+1]; //(2) --> O(1)

        for(int i=0 ; i<=x ; i++){ // (3) --> O(n)
            arr[i][0] = 1 ;
        }
        for(int i=0 ; i<=y ; i++){ //(4) --> O(n)
            arr[0][i] = 1 ;
        }
        for(int i=1 ; i<=x ; i++){ // (5)&(6) -->O(n^2)
            for(int j=1 ; j<=y ; j++){
                arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % M ; //(7)
            }
        }

        return arr[x][y] ; //(8)
    }

}
