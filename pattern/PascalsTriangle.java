public class PascalsTriangle {
    public static void main(String[] args) {
        // int n = 6;

        // for (int i = 0; i < n; i++) {
        //     int val = 1;
        //     for (int j = 0; j <= i; j++) {
        //         System.out.print(val + " ");
        //         val = val * (i - j) / (j + 1);
        //     }
        //     System.out.println();
        // }

        int n = 6;

        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {

            // First and last element of each row is 1
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            // Fill middle elements
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        // Print triangle
        for (int i = 0; i < n; i++) {
            for(int k=1; k<n-i; k++){
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
