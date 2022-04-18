class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a [1]);
        
        int totalUnit = 0;
        for(int[] boxType : boxTypes) {
            if(truckSize > 0) {
                int boxesToPutOnTruck = Math.min(boxType[0], truckSize);
                truckSize -= boxesToPutOnTruck;
                totalUnit += boxesToPutOnTruck * boxType[1];
            }
            else {
                break;
            }
        }
        
        return totalUnit;
    }
}
