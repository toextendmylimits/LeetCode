class Solution {
    private static final int BILL_FIVE_VALUE = 5;
    private static final int BILL_TEN_VALUE = 10;
    private static final int BILL_TWENTY_VALUE = 20;
    
    public boolean lemonadeChange(int[] bills) {
        int billFiveCount = 0;
        int billTenCount = 0;
        for(int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if(bill == BILL_FIVE_VALUE) {
                billFiveCount++;
            }
            else if(bill == BILL_TEN_VALUE) {
                billFiveCount--;
                billTenCount++;
            }
            else {
                if(billTenCount > 0 && billFiveCount > 0) {
                    billTenCount--;
                    billFiveCount--;
                }
                else {
                    billFiveCount -= 3;
                }
            }
            
            if(billFiveCount < 0 || billTenCount < 0) { return false; }
        }
        
        return true;
    }
}
