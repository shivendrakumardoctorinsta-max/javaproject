public class PrintNumbersUsingRecursion {
    public static void main(String[] args) {
        printNumber(5);
    }

    public static void printNumber(int n){
        //base case
        if(n==0)
            return;

        //recursive call
        printNumber(n-1);

        //work after recursion
        System.out.print(n + " ");
    }
}
