public class FactorialUsingRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(7));
    }

    public static int factorial(int n){
        //base case
        if(n==1)
            return 1;

        //recursive case
        return n*factorial(n-1);

    }
}
