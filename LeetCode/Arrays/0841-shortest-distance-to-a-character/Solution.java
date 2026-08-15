class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                list.add(i);
            }
        }
        int [] ans = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == c){
                ans[i] = 0;
                continue;
            }
            else{
                int n = Integer.MAX_VALUE;

                for(int p : list){
                    n = Math.min(Math.abs(i-p), n);
                }
                ans[i] = n;
            }
        }
        return ans;
    }
}