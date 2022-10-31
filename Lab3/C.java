import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    static class Node{
        int val ;
        Node next;
        Node prev;
        Node(int val){
            this.val = val ;
        }
    }
    public static void main(String[] args){

        QReader in = new QReader();
        QWriter out = new QWriter();

        int n = in.nextInt();
        Node[] arrA = new Node[n] ;
        Node[] arrB = new Node[n] ;

        for(int i=0 ; i<n ; i++){
            Node node = new Node(in.nextInt());
            arrA[i] = node ;
            arrB[i] = arrA[i];
        }
        Node[] arrC = new Node[n];
        arrC = sort(0,n-1,arrB, arrC) ; //sort

        Node head = new Node(0); //connect arrB
        Node cur = head ;
        cur.next = arrC[0];
        cur = cur.next;
        for(int i=1 ; i<n ; i++){
            cur.next = arrC[i] ; //3
            cur = cur.next ; //3
            cur.prev = arrC[i-1];
        }
        cur.next = arrC[0]; // make circle linked list
        cur = cur.next ;
        cur.prev = arrC[n-1];

        for(int i=0 ; i<n-1 ; i++){
            if(Math.abs(arrA[i].next.val - arrA[i].val) < Math.abs(arrA[i].val - arrA[i].prev.val)){
                out.print(Math.abs(arrA[i].next.val - arrA[i].val) + " ");
            } else {
                out.print(Math.abs(arrA[i].val - arrA[i].prev.val) + " ");
            }
            //delete
            arrA[i].prev.next = arrA[i].next;
            arrA[i].next.prev = arrA[i].prev;
        }
        out.close();
    }
    static Node[] sort(int left, int right, Node[] a, Node[] b)//merge sort
    {
        if (right - left >= 2) {
            a = sort(left, (left + right) / 2, a, b);
            a = sort((left + right) / 2 + 1, right, a, b);
        }
        int mid = (left + right) / 2 + 1;
        int num1 = left, num2 = mid, num3 = left;
        for (int i = 0; i < right - left + 1; i++) {
            if (num1 != mid && (num2 == right + 1 || a[num1].val <= a[num2].val)) {
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
