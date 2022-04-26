class Solution {
    private static final Map<String, Integer> MONTH_SHORTCODE_MAP = new HashMap<>();
    private static final String[] MONTH_SHORTCODE = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final char DATE_PARTS_SEPARATOR_HYPEN = '-';
    static {       
        for(int i = 0; i < MONTH_SHORTCODE.length; i++) {
            MONTH_SHORTCODE_MAP.put(MONTH_SHORTCODE[i], i + 1);
        }
    }
    
    public String reformatDate(String date) {
        String[] dateParts = date.split(" ");
        int day = parseDay(dateParts[0]);
        int month = parseMonth(dateParts[1]);
        int year = parseYear(dateParts[2]);
        return format(day, month, year, DATE_PARTS_SEPARATOR_HYPEN);
       
    }
    
    private int parseDay(String day) {
        String digits = "";

        for(int i = 0; i < day.length(); i++) {
            char c = day.charAt(i);
            if(Character.isDigit(c)) {
                digits += c;
            }
        }
        
        return Integer.parseInt(digits);
    }
    
    private int parseYear(String year) {
        return Integer.parseInt(year);
    }
    
    private int parseMonth(String month) {
        return MONTH_SHORTCODE_MAP.get(month);
    }
    
    private String format(int day, int month, int year, char separator) {
        return String.valueOf(year) + separator + addZeroIfLessThanTwoDigits(month) + separator
            + addZeroIfLessThanTwoDigits(day);
    }
    
    private String addZeroIfLessThanTwoDigits(int dayOrMonth) {
        return dayOrMonth < 10? "0" + dayOrMonth : String.valueOf(dayOrMonth); 
    }
}
