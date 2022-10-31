import java.util.Scanner;

public class B {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        Queue que = new Queue();
        int[] output = new int[100000];
        int i=0 ;
        int D=0 ;
        while(i < size){
            char c = in.next().charAt(0);
            int n = in.nextInt();
            if(c == 'D'){
                int j=0;
                while (j<n){
                    que.deQueue();
                    j++;
                }
                output[D] = que.showFront();
                D++ ;
            } else {
                que.enQueue(n);
            }
            i++ ;
        }

        for (int k=0 ; k<D ; k++){
            System.out.println(output[k]);
        }
        //System.out.println(output[1]);
    }

     static class Queue{
        int maxSize ;
        int[] Q = new int[100000] ;
        int front = 0;
        int rear = 0;
        public void enQueue(int x){
            Q[rear] = x ;
            rear++ ;
        }
        public int deQueue(){
            int deleted = Q[front];
            front++ ;
            return deleted ;

        }
        public int showFront(){
            return Q[front] ;
        }

    }
}
