class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // 0 = no reservation
        // bits represent seats 2-9
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Every completely empty row can have 2 families
        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

            // Seats 2,3,4,5
            boolean left = (mask & ((1 << 2) | (1 << 3) |
                                   (1 << 4) | (1 << 5))) == 0;

            // Seats 6,7,8,9
            boolean right = (mask & ((1 << 6) | (1 << 7) |
                                    (1 << 8) | (1 << 9))) == 0;

            // Seats 4,5,6,7
            boolean middle = (mask & ((1 << 4) | (1 << 5) |
                                      (1 << 6) | (1 << 7))) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || right || middle) {
                ans += 1;
            }
        }

        return ans;
    }
}