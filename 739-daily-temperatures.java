class Solution {
    /* Solution 1: brute-force
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int day = 0; day < temperatures.length; day++) {
            int daysToWait = 0;
            for(int futureDay = day + 1; futureDay < temperatures.length; futureDay++) {
                if(temperatures[futureDay] > temperatures[day]) {
                    result[day] = futureDay - day;
                    break;
                }
            }                     
        }
        
        return result;
    }*/

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> monotoneIncreasingStack = new Stack<>();
        for(int day = 0; day < temperatures.length; day++) {
            while(!monotoneIncreasingStack.isEmpty() && temperatures[day] > temperatures[monotoneIncreasingStack.peek()]) {
                int top = monotoneIncreasingStack.pop();
                result[top] = day - top;
            }  
            
            monotoneIncreasingStack.push(day);        
        }
        
        return result;
    }
}
