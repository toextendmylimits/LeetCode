class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[2051];
        int maxPopulation = 0;
        int result = 0;
        
        for(int[] l : logs) {
            population[l[0]]++;
            population[l[1]]--;
        }
        
        for(int i = 1950; i < 2051; i++) {
            population[i] += population[i - 1];
            if(population[i] > maxPopulation) {
                maxPopulation = population[i];
                result = i;
            }
        }
        
        return result;
    }
}
