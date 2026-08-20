class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list.add(nums[0]);
        list2.add(nums[1]);

        if(nums.length < 3){
            return new int[]{nums[0], nums[1]};
        }
        for(int i = 2; i < nums.length; i++){
            if(list.get(list.size()-1) > list2.get(list2.size()-1)){
                list.add(nums[i]);
            }
            else{
                list2.add(nums[i]);
            }
        }
        int [] ans = new int[nums.length];
        int u = 0;
        for(int h : list){
            ans[u++] = h;
        }
        for(int h : list2){
            ans[u++] = h;
        }
        return ans;
    }
}