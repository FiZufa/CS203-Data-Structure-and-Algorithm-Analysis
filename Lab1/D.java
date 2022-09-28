import java.util.Scanner;

public class D {
    public static void main(String[] args){
        //binary search problem
        Scanner in = new Scanner(System.in);
        int xr = in.nextInt();
        int yr = in.nextInt();
        int xc = in.nextInt();
        int yc = in.nextInt();
        int N = in.nextInt();
        String str = in.next();

        long[] x = new long[N+1];
        long[] y = new long[N+1];
        x[0] = 0 ;
        y[0] = 0 ;
        for(int i=1 ; i<N+1 ; i++){
            if(str.charAt(i-1) == 'U'){
                x[i]=x[i-1];
                y[i]=y[i-1]+1;
            } else if(str.charAt(i-1) == 'D'){
                x[i]=x[i-1];
                y[i]=y[i-1]-1;
            } else if(str.charAt(i-1) == 'R'){
                x[i]=x[i-1]+1;
                y[i]=y[i-1];
            } else {
                x[i]=x[i-1]-1;
                y[i]=y[i-1];
            }
        }
        System.out.print(minTime(x,y,xr,yr,xc,yc,N));

    }

    public static boolean check(long[] x, long[] y, long mid, int Xr, int Yr, int Xc, int Yc, int N){
        long multi = mid/N ;
        long rmd = mid%N ;
        long Xrt = Xr + multi*x[N] + x[(int) rmd]; //robot's x coor
        long Yrt = Yr + multi*y[N] + y[(int) rmd]; //robot's y coor
        long dis = Math.abs(Xrt-Xc) + Math.abs(Yrt-Yc);
        if(dis<=mid){
            return true;
        }
        return false ;
    }

    public static long minTime(long[] x, long[] y, int Xr, int Yr, int Xc, int Yc, int N){
        long l=0, r=10000000000000000L ;
        long mid ; //t
        long result=-1 ;
        while(l<=r){
            mid = (l+r)/2;
            if(check(x, y, mid, Xr, Yr, Xc, Yc, N)){
                result=mid ;
                r=mid-1 ;
            } else {
                l=mid+1 ;
            }
        }
        return result ;
    }
}
