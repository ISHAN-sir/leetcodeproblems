class Solution {
     public int ways(int i,int[] nums, int target){
        if(i==nums.length){
            if(target==0) return 1;
            else return 0;
        }
      //  if(dp[i][target+sum])
       int add = ways(i+1,nums,target-nums[i]);
     int sub = ways(i+1,nums,target+nums[i]);
     return add+sub;
     }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0 , n = nums.length;
        for(int ele :nums) sum+=ele;
        int[][]dp = new int [n][2];
        for(int i=0;i<dp.length;i++)
        for(int j=0;j<dp[0].length;j++) dp[i][j] = -1;
     return ways(0,nums,target);
    }
}