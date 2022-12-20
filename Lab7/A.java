import java.util.*;
import java.io.*;

public class A {
    static class Node{
        int i, j ;
        long ab ;
        Node(long ab, int i, int j){
            this.ab = ab ;
            this.i = i ;
            this.j = j ;
        }
    }
    static Node[] heap = new Node[100000000] ;
    static int size = 0;
    public static void main(String[] args) {

        QReader in = new QReader() ;
        QWriter out = new QWriter() ;

        int a = in.nextInt() + 1 ;
        int b = in.nextInt() + 1;
        int k = in.nextInt() ;

        long[] A = new long[a];
        long[] B = new long[b];
        for(int i=1 ; i<a ; i++){
            A[i] = in.nextLong() ;
        }
        for (int i=1 ; i<b ; i++){
            B[i] = in.nextLong();
        }

        long[] sortedA = new long[a];
        sortedA = sort(1,a-1,A,sortedA);

        for(int j=1 ; j<b ; j++){
            Node nodes = new Node(sortedA[1]*B[j],1,j);
            insert(nodes);
        }

        for(int i=0 ; i<k ; i++){
           Node remove = delete();
           out.print(remove.ab + " ");
           int l = remove.i + 1 ;
           if(l<a){
               Node next = new Node(sortedA[l]*B[remove.j], l, remove.j) ; //Index 4 out of bounds for length 4
               insert(next);
           }
        }


        out.close();
    }

    static void insert(Node x){
        heap[size+1] = x ;
        size++ ;
        int cur = size ;
        while(cur>1){
            if(heap[cur].ab < heap[cur/2].ab){
                Node temp = heap[cur] ;
                heap[cur] = heap[cur/2] ;
                heap[cur/2] = temp ;
                cur = cur/2 ;
            } else {
                break;
            }
        }
    }

    static Node delete(){
        Node temp = heap[1];
        heap[1] = heap[size];
        size-- ;
        int cur = 1 ;
        while(2*cur<=size || 2*cur+1 <=size){ //has child
            if(2*cur+1<=size){ //has 2 children
                if(heap[2*cur].ab > heap[2*cur+1].ab && heap[cur].ab > heap[2*cur+1].ab){
                    Node smaller = heap[2*cur+1];
                    heap[2*cur+1] = heap[cur];
                    heap[cur] = smaller ;
                    cur = 2*cur+1 ;
                } else if(heap[2*cur].ab <= heap[2*cur+1].ab && heap[cur].ab > heap[2*cur].ab) {
                    Node smaller = heap[2*cur];
                    heap[2*cur] = heap[cur];
                    heap[cur] = smaller;
                    cur = 2*cur;
                } else{
                    break;
                }

            } else if (cur*2==size && heap[cur].ab > heap[2*cur].ab){ //has only 1 child
                Node smaller = heap[2*cur]; //update left
                heap[2*cur] = heap[cur];
                heap[cur] = smaller ;
                cur = 2*cur ;
            } else {
                break;
            }
        }

        return temp ;
    }

    static long[] sort(int left, int right, long[] a, long[] b)//merge sort
    {
        if (right - left >= 2) {
            a = sort(left, (left + right) / 2, a, b);
            a = sort((left + right) / 2 + 1, right, a, b);
        }
        int mid = (left + right) / 2 + 1;
        int num1 = left, num2 = mid, num3 = left;
        for (int i = 0; i < right - left + 1; i++) {
            if (num1 != mid && (num2 == right + 1 || a[num1] <= a[num2])) {
                b[num3] = a[num1];
                num3++;
                num1++;
            } else {
                b[num3] = a[num2];
                num3++;
                num2++;
            }
        }
        for (int i = left; i <= right; i++)
            a[i] = b[i];
        return a;
    }


}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
