class Solution {
    private static Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] resultArr = s.toCharArray();
        while(left < right) {
            while(left < right && !VOWELS.contains(s.charAt(left))) {
                left++;
            }
            
            while(left < right && !VOWELS.contains(s.charAt(right))) {
                right--;
            }
                  
            if(left < right) {
                resultArr[left] = s.charAt(right);
                resultArr[right] = s.charAt(left);
                left++;
                right--;
            }
        }
                  
        return new String(resultArr);
    }
}
