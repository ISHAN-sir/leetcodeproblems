class Solution {

    public void twosum(ArrayList<List<Integer>> ans, int[] nums,
                       int i, int j, int target) {

        while (i < j) {

            int sum = nums[i] + nums[j];

            if (sum < target) {
                i++;
            }
            else if (sum > target) {
                j--;
            }
            else {
                ans.add(Arrays.asList(-target, nums[i], nums[j]));

                i++;
                j--;

                // skip duplicates
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }

                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        ArrayList<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            twosum(ans, nums, i + 1, nums.length - 1, target);
        }

        return ans;
    }
}