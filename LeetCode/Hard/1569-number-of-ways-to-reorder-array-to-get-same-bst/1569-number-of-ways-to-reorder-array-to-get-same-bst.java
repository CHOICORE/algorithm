import java.math.BigInteger;

class Solution {
    static int MOD = 1_000_000_007;
    static Map<Long, Long> F = new HashMap();

    static {
        F.put(1L, 1L);
        for (var i = 2L; i < 100_001L; i++) {
            F.put(i, (F.get(i - 1) * i) % MOD);
        }
    }

    Map<Integer, Set<Integer>> G = new HashMap();

    static long inv(long n) {
        return BigInteger.valueOf(F.get(n)).modInverse(BigInteger.valueOf(MOD)).longValue();
    }

    static long nCk(long n, long k) {
        return n <= k ? 1 : F.get(n) * inv(k) % MOD * inv(n - k) % MOD;
    }

    int numOfWays(int[] A) {
        build(-1, A);
        return (int) post(A[0])[1] - 1;
    }

    void build(int p, int[] A) {
        if (0 < A.length) {
            var A_i = A[0];
            if (p != -1) {
                G.computeIfAbsent(p, __ -> new HashSet()).add(A_i);
            }
            build(A_i, Arrays.stream(A).filter(A_j -> A_i > A_j).toArray());
            build(A_i, Arrays.stream(A).filter(A_j -> A_i < A_j).toArray());
        }
    }

    long[] post(int u) {
        long[] ustate = {1, 1};
        for (var v : G.getOrDefault(u, new HashSet<>())) {
            var vstate = post(v);
            ustate[0] += vstate[0];
            ustate[0] %= MOD;

            ustate[1] *= vstate[1];
            ustate[1] %= MOD;
            ustate[1] *= nCk(ustate[0] - 1, vstate[0]);
            ustate[1] %= MOD;
        }
        return ustate;
    }
}