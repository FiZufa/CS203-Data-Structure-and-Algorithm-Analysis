import java.util.Scanner;

public class A {
    static long score(String s){
        Stack stc = new Stack(s.length());

        stc.push(0L);
        for(int i=0 ; i<s.length() ; i++){ //((()())())
            if(s.charAt(i) == '('){
                stc.push(0L);
            } else {
                if(stc.peek() == 0L){
                    stc.pop();
                    stc.push(stc.pop() +1L);
                } else{
                    long point = stc.pop();
                    stc.push((stc.pop() + 2*point)%514329);
                }
            }
        }

        long points = 0L ;
        while (stc.top > -1){
            points += stc.pop();
        }
        return points;
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.print(score(str));

    }

    //STACK
    static class Stack{
        long[] stack ;
        int top = -1 ;

        Stack(int l){
            stack = new long[l];
        }

        void push(long x){
            top++ ;
            stack[top] = x ;
        }
        long pop(){
            long x = stack[top] ;
            top-- ;
            return x ;
        }
        long peek(){
            long x = stack[top] ;
            return x ;
        }

    }


}
