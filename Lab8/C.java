import java.util.*;
import java.io.*;

public class C {
    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        Boolean isCyclicUtil(int v, Boolean visited[],
                             int parent) {

            visited[v] = true;
            Integer i;

            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext()) {
                i = it.next();

                if (!visited[i]) {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                } else if (i != parent)
                    return true;
            }
            return false;
        }

        Boolean isCyclic() {

            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            for (int u = 0; u < V; u++) {

                if (!visited[u])
                    if (isCyclicUtil(u, visited, -1))
                        return true;
            }

            return false;
        }

    }

    public static void main(String[] args) {

        QReader in = new QReader() ;
        QWriter out = new QWriter() ;

        int n = in.nextInt() ;
        int m = in.nextInt() ;

        Graph node = new Graph(n) ;
        for(int i=0 ; i<m ; i++){
            int u = in.nextInt()-1 ;
            int v = in.nextInt()-1 ;
            node.addEdge(u,v) ;
        }

        if(node.isCyclic())
            System.out.print("Bad");
        else
            System.out.print("Good");

        out.close();
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
