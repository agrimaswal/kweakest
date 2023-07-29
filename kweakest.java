import java.util.Arrays;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Create an array to store the strengths of each row along with their indices
        int[][] rowStrengths = new int[m][2]; // [rowIndex, strength]
        
        // Calculate the strength of each row (number of soldiers)
        for (int i = 0; i < m; i++) {
            int strength = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    strength++;
                } else {
                    break; // Since soldiers appear before civilians, we can stop counting once we encounter a 0
                }
            }
            rowStrengths[i] = new int[]{i, strength};
        }
        
        // Sort the rowStrengths array based on strength (and row index in case of equal strengths)
        Arrays.sort(rowStrengths, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        // Extract the indices of the k weakest rows
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rowStrengths[i][0];
        }
        
        return result;
    }
}
