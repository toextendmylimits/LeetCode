public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private char[] prevBuffer = new char[4];
    private int prevIndex = 0;
    private int prevSize = 0;
    
    public int read(char[] buf, int n) {
        int currentIndex = 0;
        
        while(currentIndex < n) {
            if(prevIndex < prevSize) {
                buf[currentIndex] = prevBuffer[prevIndex];
                currentIndex++;
                prevIndex++;
            }
            else {
                prevIndex = 0;
                prevSize = read4(prevBuffer);                
            }
            
            if(prevSize == 0) { break; }
        }
        
        return currentIndex;
    }
}
