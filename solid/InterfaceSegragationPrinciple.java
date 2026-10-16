package solid;

// This class demonstrates the Interface Segregation Principle (ISP).
// ISP states that no client should be forced to depend on methods it does not use.
// Instead of one large interface, many small, specific interfaces are preferred.
public class InterfaceSegragationPrinciple {
    public static void main(String[] args) {
        Printer simplePrinter = new SimplePrinter();
        simplePrinter.print("Hello, World!");

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print("Document to print");
        String scanned = mfp.scan();
        mfp.fax(scanned);
    }

}

// Segregated interfaces
    interface Printer {
        void print(String content);
    }   
    interface Scanner {
        String scan();
    }
    interface Fax {
        void fax(String content);
    }
    // Implementing classes only implement the interfaces they need
    class SimplePrinter implements Printer {
        @Override
        public void print(String content) {
            System.out.println("Printing: " + content);
        }
    }
    class MultiFunctionPrinter implements Printer, Scanner, Fax {
        @Override
        public void print(String content) {
            System.out.println("Printing: " + content);
        }

        @Override
        public String scan() {
            String scannedContent = "Scanned Document";
            System.out.println(scannedContent);
            return scannedContent;
        }

        @Override
        public void fax(String content) {
            System.out.println("Faxing: " + content);
        }
    }