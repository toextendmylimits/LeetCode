class Solution {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        // Loop through 1 to n, find the correspanding string, and add to list
        for(int i = 1; i <= n; i++) {
            result.add(mapToFizzBuzz(i));
        }
        
        return result;
    }
    
    private String mapToFizzBuzz(int i) {
        if(i % 3 == 0 && i % 5 == 0) {
            return FIZZ + BUZZ;
        }
        else if(i % 3 == 0) {
            return FIZZ;
        }
        else if(i % 5 == 0) {
            return BUZZ;
        }
        else {
            return String.valueOf(i);
        }
    }
}
