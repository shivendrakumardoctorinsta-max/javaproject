public class HollowButterfly {
    public static void main(String[] args) {
        int n=5;

        //uper half
        for(int i=1; i<=n;i++){
            
            //print star
            for(int j=1; j<=i;j++){
                if(j==1 || j==i){
                    System.err.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            //print space
            int space = 2*(n-i);
            for(int j=1; j<=space;j++){
                System.out.print(" ");
            }

            //print star
            for(int j=1; j<=i;j++){
                if(j==1 || j==i){
                    System.err.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        //lower half
        for(int i=n; i>=1;i--){
            
            //print star
            for(int j=1; j<=i;j++){
                if(j==1 || j==i){
                    System.err.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            //print space
            int space = 2*(n-i);
            for(int j=1; j<=space;j++){
                System.out.print(" ");
            }

            //print star
            for(int j=1; j<=i;j++){
                if(j==1 || j==i){
                    System.err.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
