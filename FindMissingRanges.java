public class FindMissingRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;

        System.out.println(findMissingRanges(nums, lower, upper));  
    }

    public static String findMissingRanges(int[] nums, int lower, int upper) {
        StringBuilder result = new StringBuilder();
        int prev = lower - 1; // Initialize prev to one less than lower

        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1; // Use upper + 1 for the last iteration

            if (prev + 1 < curr) { // There is a missing range
                if (prev + 1 == curr - 1) {
                    result.append(prev + 1).append(","); // Single number missing
                } else {
                    result.append(prev + 1).append("->").append(curr - 1).append(","); // Range missing
                }
            }
            prev = curr; // Update prev to current number
        }

        // Remove the trailing comma if it exists
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
