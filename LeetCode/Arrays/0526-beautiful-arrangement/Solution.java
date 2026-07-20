class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean [] used = new boolean[n+1];
        backtrack(1,n,used);
        return count;

    }
    public void backtrack(int pos, int n, boolean [] used){
        if(pos > n){
            count++;
            return;
        }
        for(int num = 1; num <= n; num++){
            if(!used[num] && (num % pos == 0 || pos % num == 0)){
                used[num] = true;
                backtrack(pos+1, n,used);
                used[num] = false;
            }
        }
    }
}