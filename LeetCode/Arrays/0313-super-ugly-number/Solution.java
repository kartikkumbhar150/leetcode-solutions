class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
    int k = primes.length;
    int[] ugly = new int[n];
    int[] idx = new int[k];
    long[] cand = new long[k];

    ugly[0] = 1;

    for (int i = 0; i < k; i++) {
        idx[i] = 0;
        cand[i] = primes[i];
    }

    for (int i = 1; i < n; i++) {
        long next = Long.MAX_VALUE;

        for (int j = 0; j < k; j++)
            next = Math.min(next, cand[j]);

        ugly[i] = (int) next;

        for (int j = 0; j < k; j++) {
            if (cand[j] == next) {
                idx[j]++;
                cand[j] = (long) primes[j] * ugly[idx[j]];
            }
        }
    }
    return ugly[n - 1];
}

}