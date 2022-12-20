import java.util.*;
import java.io.*;

public class B {

    static int[] heap ;
    static int size ;
    public static void main(String[] args) {

        QReader in = new QReader() ;
        QWriter out = new QWriter() ;

        int T = in.nextInt() ;

        int[] result = new int[T] ;
        for(int i=0 ; i<T ; i++){
            int N = in.nextInt() ;
            heap = new int[N+1];
            size = 0 ;
            for(int j=1 ; j<N+1 ; j++){
                insert(in.nextInt());
            }

            result[i] = operate();
        }

        for(int i=0 ; i<T ; i++){
            out.println(result[i]);
        }

        out.close();
    }

    static int operate(){
        int sum = 0 ;
        while(size>1){
            int remove = delete() + delete() ;
            sum = sum + remove ;
            insert(remove);

        }
        return sum;

    }

    static void insert(int x){
        heap[size+1] = x ;
        size++ ;
        int cur = size ;
        while(cur>1){
            if(heap[cur] < heap[cur/2]){
                int temp = heap[cur] ;
                heap[cur] = heap[cur/2] ;
                heap[cur/2] = temp ;
                cur = cur/2 ;
            } else {
                break;
            }
        }
    }

    static int delete(){
        int temp = heap[1];
        heap[1] = heap[size];
        size-- ;
        int cur = 1 ;
        while(2*cur<=size || 2*cur+1 <=size){ //has child
            if(2*cur+1<=size){ //has 2 children
                if(heap[2*cur] > heap[2*cur+1] && heap[cur] > heap[2*cur+1]){
                    int smaller = heap[2*cur+1];
                    heap[2*cur+1] = heap[cur];
                    heap[cur] = smaller ;
                    cur = 2*cur+1 ;
                } else if(heap[2*cur] <= heap[2*cur+1] && heap[cur] > heap[2*cur]) {
                    int smaller = heap[2*cur];
                    heap[2*cur] = heap[cur];
                    heap[cur] = smaller;
                    cur = 2*cur;
                } else{
                    break;
                }

            } else if (cur*2==size && heap[cur]>heap[2*cur]){ //has only 1 child
                int smaller = heap[2*cur]; //update left
                heap[2*cur] = heap[cur];
                heap[cur] = smaller ;
                cur = 2*cur ;
            } else {
                break;
            }
        }

        return temp ;
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
