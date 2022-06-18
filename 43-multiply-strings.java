class Solution {
    /*public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] resultArr = new int[len1 + len2];
        for(int i = len1 - 1; i >=0; i--) {
            for(int j = len2 - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + resultArr[p2];
                resultArr[p1] += sum / 10;
                resultArr[p2] = sum % 10;
            }
        }
        
        StringBuilder resultSb = new StringBuilder();
        for(int p : resultArr) {
            if(!(resultSb.length() == 0 && p == 0)) {
                resultSb.append(p);
            }
        }
        
        return resultSb.length() == 0? "0" : resultSb.toString();
    }*/
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] resultArr = new int[len1 + len2];
        for(int i = len2 - 1; i >=0; i--) {
            for(int j = len1 - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + resultArr[p2];
                resultArr[p1] += sum / 10;
                resultArr[p2] = sum % 10;
            }
        }
        
        StringBuilder resultSb = new StringBuilder();
        for(int p : resultArr) {
            if(!(resultSb.length() == 0 && p == 0)) {
                resultSb.append(p);
            }
        }
        
        return resultSb.length() == 0? "0" : resultSb.toString();
    }    
}
