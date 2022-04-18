class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a [1]);
        
        int totalUnit = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(truckSize > 0) {
                int boxesToPutOnTruck = Math.min(boxTypes[i][0], truckSize);
                truckSize -= boxesToPutOnTruck;
                totalUnit += boxesToPutOnTruck * boxTypes[i][1];
            }
            else {
                break;
            }
        }
        
        return totalUnit;
    }
}
