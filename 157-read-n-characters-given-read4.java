public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */   
    public int read(char[] buf, int n) {
        int total = 0;
        boolean eof = false;
        char[] charsRead = new char[4];

        while(!eof && total < n) {         
            int count = read4(charsRead);
            eof = count < 4;
            count = Math.min(count, n - total);
            
            for(int i = 0; i < count; i++) {
                buf[total++] = charsRead[i];
            }
        }
        
        return total;
    }
}
