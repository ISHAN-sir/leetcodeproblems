class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length , n = mat[0].length;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
        if(!map.containsKey(i+j)){
            map.put((i+j),new ArrayList<>());
        }
        map.get(i+j).add(mat[i][j]);
      }
    }
    int[] ans = new int[m * n];
        int k = 0;

        for (int d = 0; d < m + n - 1; d++) {

            List<Integer> list = map.get(d);

            if (d % 2 == 0) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    ans[k++] = list.get(i);
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    ans[k++] = list.get(i);
                }
            }
        }

        return ans;
    }  
}