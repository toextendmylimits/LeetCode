class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int cookieIndex = 0;
        int childIndex = 0;
        for(; cookieIndex < s.length && childIndex < g.length; cookieIndex++) {
            if(s[cookieIndex] >= g[childIndex]) {
                childIndex++;
            }
        }
        
        return childIndex;
    }
}
