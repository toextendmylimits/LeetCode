class Solution {
    public int maxDistToClosest(int[] seats) {
        int leftPerson = -1;
        int maxDist = 0;
        int len = seats.length;
        for(int rightPerson = 0; rightPerson < len; rightPerson++) {
            if(seats[rightPerson] == 1) {
                if(leftPerson == -1) { // First seat is empty
                    maxDist = rightPerson;
                }
                else { // Check sitting between two persons
                    maxDist = Math.max(maxDist, (rightPerson - leftPerson) / 2);
                }
                leftPerson = rightPerson;
            }
        }
        
        if(seats[len - 1] == 0) { // Last seat is empty
            maxDist = Math.max(maxDist, len - 1 - leftPerson);
        }
        
        return maxDist;
    }
}
