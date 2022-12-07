import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) {

        QReader in = new QReader();
        QWriter out = new QWriter();

        int n = in.nextInt() ;

        node[] tree = new node[n] ;

        //create node
        for(int i=0 ; i<n ; i++){
            tree[i] = new node();
        }

        //build bidirectional tree
        for(int i=0 ; i<n-1; i++){
            int a = in.nextInt()-1 ;
            int b = in.nextInt()-1;

            tree[a].child.add(tree[b]) ;
            tree[a].path.add(1) ;
            tree[b].child.add(tree[a]) ;
            tree[b].path.add(1) ;
        }

        //assign the filled giant node -> has giant isPresent is true
        int g = in.nextInt();
        for (int i=0 ; i<g ; i++){
            int loc = in.nextInt()-1 ;
            tree[loc].isPresent = true ;
        }

        tree[0].isvisited = true ;

        // find max each sub-tree[0].child


        ArrayList<Integer> store = new ArrayList<>() ;
        for(int i=0 ; i<tree[0].child.size() ; i++){

            node[] q = new node[n] ;
            int front = 0, rear=0;
            q[rear++] = tree[0].child.get(i);
            tree[0].child.get(i).level = 1 ;
            tree[0].child.get(i).isvisited = true ;
            ArrayList<Integer> t = new ArrayList<>() ;

            while (front != rear){
                node head = q[front++] ;

                if(head.isPresent){
                    t.add(head.level) ;
                }

                for (int j=0 ; j<head.child.size() ; j++){
                    if (!head.child.get(j).isvisited){
                        q[rear++] = head.child.get(j) ;
                        head.child.get(j).level = head.level + head.path.get(j);
                        head.child.get(j).isvisited = true ;
                    }
                }
            }

            if(t.isEmpty()){
                store.add(0) ;
            } else {
                int[] arr = new int[t.size()];
                for(int j=0 ; j<t.size() ; j++){
                    arr[j] = t.get(j);
                }

                if(arr.length != 1){
                    for (int j=1 ; j<arr.length ; j++){
                        if(arr[j] <= arr[j-1]){
                            arr[j] = arr[j-1] + 1 ;
                        }else {
                            arr[j] = arr[j] ;
                        }
                        store.add(arr[arr.length-1]) ; //jiohilhih
                    }
                }
                else {
                    store.add(arr[0]);
                }
            }
        }

        store.sort(Comparator.naturalOrder());
        out.println(store.get(store.size()-1));

        out.close();
    }

    class node{
        int value;
        Integer maxNode;
        boolean isVisited;
        ArrayList<node> neighbors = new ArrayList<>();
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
