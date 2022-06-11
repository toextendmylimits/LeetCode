class Solution {
    /*public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> rowSoldiersMap = new HashMap<>();
        
        int rows = mat.length;
        int cols = mat[0].length;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(mat[r][c] == 1) {
                    rowSoldiersMap.put(r, rowSoldiersMap.getOrDefault(r, 0) + 1);
                }
                else {
                    break;
                }
            }
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int soldiersOfA = rowSoldiersMap.getOrDefault(a, 0);
            int soldiersOfB = rowSoldiersMap.getOrDefault(b, 0);
            if(soldiersOfA == soldiersOfB) {
                return b - a;
            }
            else {
                return soldiersOfB - soldiersOfA;
            }
        });
        
        for(int r = 0; r < rows; r++) {
           queue.offer(r);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        
        return result;
    }*/
    
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;       
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int soldiersOfA = getSoldiersOfRow(mat[a]);
            int soldiersOfB = getSoldiersOfRow(mat[b]);
            if(soldiersOfA == soldiersOfB) {
                return b - a;
            }
            else {
                return soldiersOfB - soldiersOfA;
            }
        });
        
        for(int r = 0; r < rows; r++) {
           queue.offer(r);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        
        return result;
    }
    
    /*private int getSoldiersOfRow(int[] row) {
        int left = 0;
        int right = row.length - 1;
        int result = 0;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(row[middle] == 1) {
                result = middle + 1;
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        
        return result;
    }*/
    private int getSoldiersOfRow(int[] row) {
        int left = 0;
        int right = row.length;
  
        while(left < right) {
            int middle = left + (right - left) / 2;
            if(row[middle] == 1) {
                left = middle + 1;
            }
            else {
                right = middle;
            }
        }
        
        return left;
    }    
}
