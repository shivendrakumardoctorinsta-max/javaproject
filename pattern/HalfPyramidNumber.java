public class HalfPyramidNumber {
    public static void main(String[] args) {
        int n= 5;
        for(int i=1; i<=n;i++){
            //print space
            for(int k=1; k<=n-i; k++){
                System.out.print(" ");
            }

            //print number
            for(int j=1; j<=i; j++){
                System.err.print(j + " ");
            }

            System.out.println();
        }
        
    }
}
