import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args){
    //sorting problem
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i=0 ; i<arr.length ; i++){
            arr[i] = in.nextLong();
        }
        System.out.print(answer(MSA(arr)));
    }

    public static long[] MSA(long[] arr){
        int n = arr.length;
        long[] s = arr ;
        if(n>1){
            int p = n/2 ;
            long[] a = Arrays.copyOfRange(arr, 0, p);
            long[] b = Arrays.copyOfRange(arr, p, n);

            long[] c = MSA(a);
            long[] d = MSA(b);

            s = merge(c,d);
        } else {
            return s;
        }
        return s;
    }

    public static long[] merge(long[] c, long[] d){
        int nL = c.length;
        int nR = d.length;
        long[] returnArr = new long[nL+nR];
        int countC = 0 ;
        int countD = 0 ;
        for(int i=0 ; i<returnArr.length ; i++){
            if((countC <= nL-1) && (countD > nR-1 || c[countC] <= d[countD]) ){
                returnArr[i] = c[countC];
                countC++ ; // 1 2 3 5 7 8 | 2 4 5 8 9
            } else{
                returnArr[i] = d[countD];
                countD++;
            }
        }
        return returnArr;
    }
    public static long answer(long[] arr){
        long min = 0 ;
        int j= arr.length-1 ;
        for(int i=0 ; i<arr.length/2 ; i++){
            min = min + arr[i]*arr[j];
            j-- ;
        }

        return min ;
    }

}
