import java.util.Scanner;

public class A {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int loop = in.nextInt();
        int[][] cuboid = new int[loop][3];
        for(int i=0 ; i<cuboid.length ; i++){
            for(int j=0 ; j<3 ; j++){
                cuboid[i][j] = in.nextInt();
            }
        }

        for(int i=0 ; i<cuboid.length ; i++){
            print(cuboid[i][0], cuboid[i][1], cuboid[i][2]);
        }


    }

    public static void print(int a, int b, int c){
        int m = (2*a+1)+2*b;
        int n = 2*b+(2*c+1);
        char[][] arr = new char[n][m];

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(i<2*b && j<2*b && i+j<2*b){ //dot top
                    arr[i][j] = '.';
                }
                if (j>=2*a+1 && i>=2*c+1 && i+j>=2*a+2*c+2*b+1){ //dot bottom
                    arr[i][j] = '.';
                }
                if(i<2*b && i+j>=2*b && i+j<2*a+2*b+1){ // top
                    if(i%2 == 0 && j%2 == 0){
                        arr[i][j] = '+';
                    }
                    if(i%2 == 0 && j%2 == 1){
                        arr[i][j] = '-';
                    }
                    if(i%2 == 1 && j%2 == 0){
                        arr[i][j] = '.';
                    }
                    if(i%2 == 1 && j%2 == 1){
                        arr[i][j] = '/';
                    }
                }
                if(i>=2*b && j<2*a+1){ //front
                    if(i%2 == 0 && j%2 == 0){
                        arr[i][j] = '+';
                    }
                    if(i%2 == 0 && j%2 == 1){
                        arr[i][j] = '-';
                    }
                    if(i%2 == 1 && j%2 == 0){
                        arr[i][j] = '|';
                    }
                    if(i%2 == 1 && j%2 == 1){
                        arr[i][j] = '.';
                    }
                }
                if(j>=2*a+1 && i+j>=2*a+1+2*b && i+j<2*a+2*c+2*b+1){ //right
                    if(i%2 == 0 && j%2 == 0){
                        arr[i][j] = '+';
                    }
                    if(i%2 == 0 && j%2 == 1){
                        arr[i][j] = '.';
                    }
                    if(i%2 == 1 && j%2 == 0){
                        arr[i][j] = '|';
                    }
                    if(i%2 == 1 && j%2 == 1){
                        arr[i][j] = '/';
                    }
                }

            }

        }
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

}
