import java.io.*;
import java.util.StringTokenizer;


public class A {
    // this solution is 100% my TA's (Shen Yun) work.
    static class node{
        long coef;
        long power;
        node next;
        node(long coef, long power){
            this.coef = coef;
            this.power = power;
        }
    }
    public static void main(String[] args) {
        QReader in = new QReader(); //0541678 --> 0145678
        QWriter out = new QWriter();

        int n=in.nextInt();
        int m=in.nextInt();
        node head = new node(-1000000001,-1000000001);

        node cur = head;
        for(int i=0 ; i<n ; i++){
            node temp = new node(in.nextLong(), in.nextInt()); //create new node
            cur.next = temp; //connect the node
            cur=cur.next;
        }

        node tail = new node(1000000001,1000000001);
        cur.next=tail;// the last chain is the tail
        cur=head; // ????

        for(int i=0 ; i<m ; i++){
            long coef = in.nextLong();
            long power = in.nextInt();

            while(power>=cur.next.power){ //
                cur=cur.next;
            }
            if(cur.power==power){
                cur.coef += coef;
            } else {
                node temp = new node(coef,power);
                temp.next = cur.next;
                cur.next = temp ;
            }
        }
        cur=head.next;
        int cnt = 0 ;

        while(cur != tail){
            if(cur.coef != 0){
                cnt++;
            }
            cur=cur.next;
        }

        out.println(cnt);
        cur = head.next;

        while(cur != tail){
            if(cur.coef != 0){
                out.println(cur.coef+" "+ cur.power);
            }
            cur = cur.next;
        }
        out.close();
    }
}
/*
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
        private  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

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

 */
