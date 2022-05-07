class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] pos = new int[n1 + n2];
        
        for(int i = n1 -1; i >= 0; i--) {
            for(int j = n2 - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = p1 + 1;
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        
        int k = 0;
        // Find first element which is not zero
        while(k < pos.length && pos[k] == 0) { k++; }
        
        StringBuilder sb = new StringBuilder();
        for(; k < pos.length; k++) {
            sb.append(pos[k]);
        }
        
        
        return sb.length() == 0? "0" : sb.toString();
    }
}
