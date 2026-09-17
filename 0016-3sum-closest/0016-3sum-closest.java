class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closestsum = 140000;
        Arrays.sort(nums);
        for(int k=0;k<=n-3;k++){
            int i =k+1;
            int j =n-1;
            while(i<j){
                int sum = nums[k]+nums[i]+nums[j];

                if(Math.abs(target-sum)<Math.abs(target-closestsum)) {
                    closestsum = sum;
                }
                if(sum<target)i++;
                else j--;
            }
        }
        return closestsum;
    }
}
