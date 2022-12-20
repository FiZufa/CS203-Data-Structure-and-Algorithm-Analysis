import java.util.*;
import java.io.*;

public class B {

    static class node{
        boolean isVisited = false;
        ArrayList<node> child = new ArrayList<>() ;
        int idx  ;
    }

    public static void main(String[] args) {

        QReader in = new QReader() ;
        QWriter out = new QWriter() ;

        int n = in.nextInt() ;
        int m = in.nextInt() ;

        node[] graph = new node[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new node();
            graph[i].idx = i+1;
        }

        for(int i=0 ; i<m ; i++){
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;

            graph[b].child.add(graph[a]);

        }

        for(int i=n-1 ; i>=0 ; i--){
            //graph[i].isVisited = true;
            if(!graph[i].isVisited){
                dfs(graph[i]);
            }
        }
        dfs(graph[0]);
        for (int i=0 ; i<n ; i++){
            System.out.print(graph[i].idx + " ");
        }

        out.close();
    }

    static void dfs(node temp){   //dfs
        temp.isVisited = true ;
        for (int i = 0; i < temp.child.size(); i++) {
            if(!temp.child.get(i).isVisited) {
                temp.child.get(i).isVisited = true;
                temp.child.get(i).idx = temp.idx;
                dfs(temp.child.get(i));
            }
        }
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
