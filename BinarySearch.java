//Binary Search in Java
//Both Iterative and Recursive approaches
//Time Complexity: O(log n)
//Space Complexity: O(1) for iterative, O(log n) for recursive due to call stack
//Middle element calculation to prevent overflow: mid = start + (end - start) / 2
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8};
        int target = 3;

        System.out.println(bs(arr, target));

        int st = 0;
        int end = arr.length -1;
        //System.out.println(bsRecursive(arr, st, end, target));
        //System.out.println(searchInsertPosition(arr, target));
        
    }

    //Iterative approach
    public static int bs(int[] arr, int target){
        int st = 0;
        int end = arr.length - 1;

        while(st <= end){
            int mid = st + (end -st)/2;
            if(target < arr[mid]){
                end = mid -1;
            }else if(target > arr[mid]){
                st = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    //Recursive approach
    public static int bsRecursive(int[] arr, int st, int end, int target){
       if(st <= end){
        int mid = st + (end - st)/2;
        if(target < arr[mid]){
            return bsRecursive(arr, st, mid -1, target);
        }else if(target > arr[mid]){
            return bsRecursive(arr, mid + 1, end, target);
        }else{
            return mid;
        }
       }
       
        return -1;
    }

    //Search Insert Position
    //If target is not found, return the index where it would be inserted in order. 
    //This is similar to binary search but returns the insertion point.
    //E.g., arr = [1,3,4,6,8], target = 5 -> return 3 (index to insert 5)
    //E.g., arr = [1,3,4,6,8], target = 0 -> return 0 (index to insert 0)
    //return st when not found beacause st will be at the correct insertion point after the loop ends 
    //(elements before st are less than target, elements after st are greater than target)
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int searchInsertPosition(int[] arr, int target){
        int st = 0;
        int end = arr.length -1;

        while(st <= end){
            int mid = st + (end - st)/2;
            if(target < arr[mid]){
                end = mid -1;
            }else if(target > arr[mid]){
                st = mid + 1;
            }else{
                return mid;
            }
        }

        return st;
    }
}
