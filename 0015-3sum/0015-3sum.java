class Solution {

    public void twosum(ArrayList<List<Integer>> arr, int[] nums,
                       int i, int j, int target) {

        while (i < j) {

            int sum = nums[i] + nums[j];

            if (sum > target) {
                j--;
            }
            else if (sum < target) {
                i++;
            }
            else {

                arr.add(Arrays.asList(-target, nums[i], nums[j]));

                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }

                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }

                i++;
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        ArrayList<List<Integer>> arr = new ArrayList<>();

        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            twosum(arr, nums, i + 1, n - 1, target);
        }

        return arr;
    }
}