
class Solution {
    public int numRabbits(int[] answers) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }

        int sum = 0;

        for (int key : map.keySet()) {

            int count = map.get(key);
            int groupSize = key + 1;

            int q = count / groupSize;
            int r = count % groupSize;

            sum += q * groupSize;

            if (r > 0) {
                sum += groupSize;
            }
        }

        return sum;
    }
}
