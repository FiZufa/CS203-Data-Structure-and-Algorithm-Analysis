import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;

public class A {
    static int cnt=0;
    static int num=0;
    public static void main(String[] args) {

        QReader in = new QReader();
        QWriter out = new QWriter();

        int n=in.nextInt(); //how many nodes
        num=in.nextInt(); //weight
        node[] tree=new node[n]; //initialize array of nodes

        for (int i = 0; i < n; i++) {
            tree[i]=new node(); // fill the array with nodes
        }

        for (int i = 0; i < n-1; i++) {
            int a=in.nextInt()-1; //start
            int b=in.nextInt()-1; // end
            int ww=in.nextInt(); //weight
            //we don't know who is the parent node, so build a bidirectional edge
            tree[a].child.add(tree[b]);
            tree[a].w.add(ww);
            tree[b].child.add(tree[a]);
            tree[b].w.add(ww);
        }

        tree[0].isvisited=true;
        dfs(tree[0]);
   /*     node[] q=new node[n];  //bfs
        int front=0,rear=0;
        q[rear++]=tree[0];
        tree[0].path=0;
        tree[0].isvisited=true;
        int cnt=0;
        while(front!=rear){
            node head=q[front++];
            if(head.child.size()==1)
                if(head.path==num) cnt++;

            for (int i = 0; i < head.child.size(); i++) {

                if(head.child.get(i).isvisited!=true) {//the child who has been visited is the parent
                    q[rear++] = head.child.get(i);
                    head.child.get(i).path=head.path+head.w.get(i);
                    head.child.get(i).isvisited = true;
                }
            }
        }*/
        out.println(cnt);

        out.close();
    }

    static void dfs(node temp){   //dfs
        if(temp.child.size()==1)
            if(temp.path==num) cnt++;
        for (int i = 0; i < temp.child.size(); i++) {
            if(temp.child.get(i).isvisited!=true) {
                temp.child.get(i).path=temp.path+temp.w.get(i);
                temp.child.get(i).isvisited = true;
                dfs(temp.child.get(i));
            }
        }
    }

    static class node{
        boolean isvisited;
        int path;
        ArrayList<Integer> w=new ArrayList<>();
        ArrayList<node> child=new ArrayList<>();

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
