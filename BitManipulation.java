//this class demonstrates basic bit manipulation operations: get, set, clear, and update bits at specific positions.
//these operations are fundamental in low-level programming and optimization tasks.
//generally, bit manipulation is used in scenarios such as performance optimization, memory management, and implementing certain algorithms efficiently.

public class BitManipulation {
    //this method returns the bit (0 or 1) at the specified position in the given number.
    //position is 0-indexed from the right.
    //for example, get(5, 0) returns 1 because the binary representation of 5 is 101.
    public static int get(int number, int pos){
        int bitMask = 1 << pos;

        if((bitMask & number) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    //this method sets the bit at the specified position to 1 in the given number.
    //for example, set(5, 1) changes the binary representation of 5 (101) to 111, which is 7 in decimal.
    //it prints the new number after setting the bit.
    //the position is 0-indexed from the right.
    //for example, set(5, 1) changes the binary representation of 5 (101) to 111, which is 7 in decimal.
    public static void set(int number, int pos){
        int bitMask = 1 << pos;
        int newNumber = bitMask | number;
        System.out.println(newNumber);
    }

    //this method clears the bit at the specified position (sets it to 0) in the given number.
    //for example, clear(5, 2) changes the binary representation of 5 (101) to 001, which is 1 in decimal.
    //it prints the new number after clearing the bit.
    public static void clear(int number, int pos){
        int bitMask = 1<<pos;
        int newBitMask = ~bitMask;
        int newNumber = newBitMask & number;

        System.out.println("Number after clear at pos "+ pos + " is "+ newNumber);
    }

    //this method toggles the bit at the specified position in the given number.
    //if the bit is 1, it changes it to 0; if it's 0, it changes it to 1.
    //for example, update(5, 0) changes the binary representation of 5 (101) to 100, which is 4 in decimal.
    public static void update(int number, int pos){
        if(get(number, pos) == 1){
            clear(number, pos);
        }else{
            set(number, pos);
        }
    }
    public static void main(String[] args) {
        // int n = 3;
        // int i = 1;

        // System.out.println("Left shift : "+ (n<<i));
        // System.out.println("Right shift : "+(n>>i));

        // System.out.println("Bit is: " + get(5, 1));

        // System.out.println("New number afer set: ");
        // set(5, 1);
        // clear(5, 2);

        update(5, 1);
        
    }
}
