
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

            int groups = (count + groupSize - 1) / groupSize;

            sum += groups * groupSize;
        }

        return sum;
    }
}
