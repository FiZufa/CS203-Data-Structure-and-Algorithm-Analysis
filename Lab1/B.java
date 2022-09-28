import java.util.Scanner;

public class B {
    public static void main(String[] args){
    // binary search problem
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        long sum = in.nextInt();
        long[] a = new long[size];
        for(int i=0 ; i<size ; i++){
            a[i] = in.nextInt();
        }
        System.out.print(result(a,sum));
    }

    public static long result(long[] a, long S){
        long count=0;
        for(int i=0 ; i<a.length-2 ; i++){
            for(int j=i+1 ; j<a.length-1 ; j++){
                long ak = S - a[i] - a[j] ;
                long index2 = left(a, ak, j+1) ;
                long index1 = right(a, ak, j+1);
                long plus = index2-index1-1;
                if(index1 <= index2){
                    count += plus ;
                }
            }
        }
        return count;
    }
    public static long left(long[] a, long x, int start){
        int l=start,r=a.length-1;
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(a[mid]>x){
                r=mid-1;
            }else l=mid+1;
        }
        return l;
    }
    public static long right(long[] a, long x, int start){
        int l=start,r=a.length-1;
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(a[mid]<x){
                l=mid+1;
            }else r=mid-1;
        }
        return r;
    }
}
