import java.util.Scanner;

public class C {
    public static void main(String[] args){
        // binary search problem
        Scanner in = new Scanner(System.in);
        int std = in.nextInt();
        int cake = in.nextInt();
        int[] r = new int[cake];

        for(int i=0 ; i<cake ; i++){
            r[i] = in.nextInt();
        }
        System.out.println(maxCake(r,cake,std));
    }

    public static boolean isPossible(double mid, int[] a, int cake, int std){
        for(int i=cake-1 ; i>=0 ;i--){
            int p=(int)Math.floor((a[i]*a[i])/mid) ;
            std -= p ;

            if (std<=0){
                return true;
            }

        }
        if (std<=0){
            return true;
        }
        return false;
    }

    public static double maxCake(int[] a, int cake, int std){
        double l=0, r=1000*1000;

        double res = 0 ;
        while(r-l>0.000001){
            double mid = (l+r)/2.0000;
            if(isPossible(mid,a,cake,std)){
                res=mid;
                l=mid;
            }
            else {
                r=mid;
            }
        }
        double c1 = res*Math.PI;
        return c1;
    }

}
