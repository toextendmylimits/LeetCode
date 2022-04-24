class Solution {
     public int[][] highFive(int[][] items) {
         return getStudentTopNAverageScores(items, 5);
     }
    
     public int[][] getStudentTopNAverageScores(int[][] items, int n) {
        List<int[]> result = new ArrayList<>();
         int length = items.length;
              
         // Sort Items
         Arrays.sort(items, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            else {
                return a[0] - b[0];
            }
        });
         
         int i = 0;
         while(i < length) {
            int id = items[i][0];
             int sum = 0;
             for(int j = i; j < i + n; j++) {
                 sum += items[j][1];
             }
             
             result.add(new int[]{ id, sum / n});
             while(i < length && items[i][0] == id) {
                 i++;
             }
         }
         
         return result.toArray(new int[result.size()][]);
    } 
    
    /*public int[][] highFive(int[][] items) {
       List<int[]> result = new ArrayList<>(); 
        
        // Sort items
        Arrays.sort(items, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            else {
                return a[0] - b[0];
            }
        });
         
        int count = 5;
        int sum = 0;
        
        for(int i = 0; i < items.length; i++) {
            if(result.isEmpty() || result.get(result.size() - 1)[0] != items[i][0]) {
                if(!result.isEmpty() && result.get(result.size() - 1)[0] == items[i][0]) {
                    continue;
                } 
                
                if(count-- > 0) {
                    sum += items[i][1];
                }
                
                if(count == 0) {
                    result.add(new int[] { items[i][0], sum / 5 });
                    count = 5;
                    sum = 0;
                }
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }*/
}
