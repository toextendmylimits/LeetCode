class Solution {
    static final int ONE_HUNDRED = 100;
    static final int ONE_THOUSAND = 1000;
    static final int ONE_MILLION = ONE_THOUSAND * ONE_THOUSAND;
    static final int ONE_BILLION = ONE_THOUSAND * ONE_MILLION;
    static final Map<Integer, String> VALUE_SYMBOL = new TreeMap<>((a, b) -> b - a);
    static {
        VALUE_SYMBOL.put(ONE_BILLION, "Billion");
        VALUE_SYMBOL.put(ONE_MILLION, "Million");
        VALUE_SYMBOL.put(ONE_THOUSAND, "Thousand");
        VALUE_SYMBOL.put(ONE_HUNDRED, "Hundred");
        VALUE_SYMBOL.put(90, "Ninety");
        VALUE_SYMBOL.put(80, "Eighty");
        VALUE_SYMBOL.put(70, "Seventy");
        VALUE_SYMBOL.put(60, "Sixty");
        VALUE_SYMBOL.put(50, "Fifty");
        VALUE_SYMBOL.put(40, "Forty");
        VALUE_SYMBOL.put(30, "Thirty");
        VALUE_SYMBOL.put(20, "Twenty");
        VALUE_SYMBOL.put(19, "Nineteen");
        VALUE_SYMBOL.put(18, "Eighteen");
        VALUE_SYMBOL.put(17, "Seventeen");
        VALUE_SYMBOL.put(16, "Sixteen");
        VALUE_SYMBOL.put(15, "Fifteen");
        VALUE_SYMBOL.put(14, "Fourteen");
        VALUE_SYMBOL.put(13, "Thirteen");
        VALUE_SYMBOL.put(12, "Twelve");  
        VALUE_SYMBOL.put(11, "Eleven");
        VALUE_SYMBOL.put(10, "Ten");  
        VALUE_SYMBOL.put(9, "Nine");  
        VALUE_SYMBOL.put(8, "Eight");  
        VALUE_SYMBOL.put(7, "Seven");  
        VALUE_SYMBOL.put(6, "Six");  
        VALUE_SYMBOL.put(5, "Five");  
        VALUE_SYMBOL.put(4, "Four");  
        VALUE_SYMBOL.put(3, "Three");  
        VALUE_SYMBOL.put(2, "Two");  
        VALUE_SYMBOL.put(1, "One");     
    }

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        
        StringBuilder result = new StringBuilder();
        while(num > 0) {
            for(Map.Entry<Integer, String> entry : VALUE_SYMBOL.entrySet()) {
                int intValue = entry.getKey();
                String symbol = entry.getValue();
                int count = num / intValue;
                num = num % intValue;
                if(count > 0) {
                    if(intValue >= ONE_HUNDRED) {
                        result.append(numberToWords(count));
                        result.append(' ');                        
                    }
                    result.append(symbol);
                    if(num > 0) {
                        result.append(' ');  
                    }
                }
                
                if(num == 0) {
                    break;
                }
            }
        }
        
        return result.toString();
    }
}
