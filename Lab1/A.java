import java.util.Scanner;

public class A {
    public static void main(String[] args){
    //binary search problem

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();

        int[] a = new int[N];
        int[][] q = new int[Q][2];

        for(int i=0 ; i<a.length ; i++){
            a[i] = in.nextInt();
        }
        for(int i=0 ; i<q.length ; i++){
            for(int j=0 ; j<2 ; j++){
                q[i][j] = in.nextInt();
            }
        }
        for(int i=0 ; i<q.length ; i++){
            print(left(a,q[i][0]), right(a,q[i][1]));
        }
    }

    public static int left(int[] a, int x){
        int l=0,r=a.length-1;
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(a[mid]>x){
                r=mid-1;
            }else l=mid+1;
        }
        return l;
    }
    public static int right(int[] a, int x){
        int l=0,r=a.length-1;
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(a[mid]<x){
                l=mid+1;
            }else r=mid-1;
        }
        return r;
    }
    public static void print(int left,int right){
        int range = right-left+1;
        if(range < 1){
            System.out.println("NO");
        } else {
            System.out.println("YES "+ range);
        }
    }
}
