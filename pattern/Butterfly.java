public class Butterfly {
    public static void main(String[] args) {
        int n=4;

        //uper half
        for(int i=1; i<=n;i++){
            
            //print star
            for(int j=1; j<=i;j++){
                System.err.print("*");
            }

            //print space
            int space = 2*(n-i);
            for(int j=1; j<=space;j++){
                System.out.print(" ");
            }

            //print star
            for(int j=1; j<=i;j++){
                System.err.print("*");
            }

            System.out.println();
        }

        //lower half
        for(int i=n; i>=1;i--){
            
            //print star
            for(int j=1; j<=i;j++){
                System.err.print("*");
            }

            //print space
            int space = 2*(n-i);
            for(int j=1; j<=space;j++){
                System.out.print(" ");
            }

            //print star
            for(int j=1; j<=i;j++){
                System.err.print("*");
            }

            System.out.println();
        }
    }
}
