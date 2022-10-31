import java.util.Scanner;

public class B {
    static class Node{
        long price ;
        Node next ;
        Node(long price){
            this.price = price;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long m = in.nextLong();
        long sum = 0 ;
        Node head = new Node(0);
        Node cur = head ;
        for(int i=0 ; i<n ; i++){
            Node node = new Node(in.nextLong());
            sum += node.price;
            cur.next = node ;
            cur = cur.next;
        }
        cur.next = head.next ;

        long multi = m/sum;
        m = m%sum ;
        long count = multi*n ;

        while(m>0 && sum!=0){
            if(cur.next.price > m){
                sum = sum - cur.next.price ;
                cur.next = cur.next.next ; //delete
                n-- ;
                if(sum==0){
                    break;
                }
                multi = m/sum;
                m = m % sum ;
                count += multi*n ;
            }
            else {
                m -= cur.next.price;
                count++ ;
                cur = cur.next;
            }
        }

    System.out.print(count);

    }
}
