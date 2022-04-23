class Logger {
    private static final int LOG_INTERVAL_SECONDS_FOR_SAME_MESSAGE = 10;
    
    private Map<String, Integer> messageTimestampMap;
    
    public Logger() {
        messageTimestampMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(messageTimestampMap.containsKey(message)) {
            int lastTimeStamp = messageTimestampMap.get(message);            

            if(timestamp < lastTimeStamp + LOG_INTERVAL_SECONDS_FOR_SAME_MESSAGE) {
                return false;
            }
            
            messageTimestampMap.put(message, timestamp);
            return true;
        }

        messageTimestampMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
