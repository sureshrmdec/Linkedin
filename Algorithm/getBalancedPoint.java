public class FindBalancePoint {


    public static void main(String[] args) {


        int[] nums = {1, 2, 3, 3, 2, 1};

        System.out.println(getBalancedPoint(nums));
    }


    public static int getBalancedPoint(int[] nums) {


        int sum = 0;

        int n = nums.length;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {


            sum += nums[i];

            arr[i] = sum;
        }


        for (int i = 1; i < arr.length; i++) {

            if ((arr[n - 1] - arr[i]) == arr[i]) {
                return i;
            }
        }

        return -1;
    }
}
