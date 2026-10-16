public class NumberPyramid {
    public static void main(String[] args) {
        int n=5;
        for(int i=1; i<=n; i++){
            //print spcae n-1
            int space = n-i;
            for(int k= 1; k<=space; k++){
                System.out.print(" ");
            }

            //print star
            for(int j=1; j<=i; j++){
                System.out.print(i);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
