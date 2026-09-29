class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int sumeven =0;
        for(int num : nums){
            if(num%2==0){
                sumeven += num;
            }
        }
         int[] ans = new int[q];
           for (int i = 0; i < q; i++) {

            int value = queries[i][0];
            int index = queries[i][1];
             // Remove old value if it was even
            if (nums[index] % 2 == 0) {
                sumeven -= nums[index];
            }

            // Apply query
            nums[index] += value;

            // Add new value if it is even
            if (nums[index] % 2 == 0) {
                sumeven += nums[index];
            }

            ans[i] = sumeven;
        }

        return ans;
    }
}