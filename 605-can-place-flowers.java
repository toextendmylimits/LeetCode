class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) { 
            return true;
        }
        
        int previousPlantedPlot = -1;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                boolean isLeftPlotEmpty =  i == 0 || previousPlantedPlot < i - 1;
                boolean isRightPlotEmpty = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if(isLeftPlotEmpty && isRightPlotEmpty) {
                    n--;
                    if(n == 0) {
                        return true;
                    }
                    previousPlantedPlot = i;
                }
            }
            else if(flowerbed[i] == 1) {
                previousPlantedPlot = i;
            }       
        }
        
        return false;
    }
}
