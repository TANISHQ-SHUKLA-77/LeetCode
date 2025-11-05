class Solution {
    private static final class Entry implements Comparable<Entry> {
        int freq, val;
        Entry(int f, int v) { freq = f; val = v; }
        @Override public int compareTo(Entry o) {
            if (freq != o.freq) return Integer.compare(freq, o.freq);
            return Integer.compare(val, o.val);
        }
        @Override public boolean equals(Object o) {
            if (!(o instanceof Entry)) return false;
            Entry e = (Entry) o;
            return freq == e.freq && val == e.val;
        }
        @Override public int hashCode() { return Objects.hash(freq, val); }
    }

    private final Map<Integer, Integer> freq = new HashMap<>();
    private final TreeSet<Entry> best = new TreeSet<>();
    private final TreeSet<Entry> rest = new TreeSet<>();
    private long bestSum = 0L;
    private int X = 0;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        X = x;

        for (int i = 0; i < k; i++) add(nums[i]);
        ans[0] = bestSum;

        for (int i = k; i < n; i++) {
            add(nums[i]);
            remove(nums[i - k]);
            ans[i - k + 1] = bestSum;
        }
        return ans;
    }

    private void add(int val) {
        int old = freq.getOrDefault(val, 0);
        if (old > 0) erase(val, old);
        int now = old + 1;
        freq.put(val, now);
        rest.add(new Entry(now, val));
        normalize();
    }

    private void remove(int val) {
        int old = freq.get(val);
        erase(val, old);
        int now = old - 1;
        if (now == 0) {
            freq.remove(val);
        } else {
            freq.put(val, now);
            rest.add(new Entry(now, val));
        }
        normalize();
    }

    private void erase(int val, int f) {
        Entry key = new Entry(f, val);
        if (best.remove(key)) {
            bestSum -= (long) val * f;
        } else {
            rest.remove(key);
        }
    }

    private void normalize() {
        while (best.size() < X && !rest.isEmpty()) {
            Entry take = rest.pollLast();
            best.add(take);
            bestSum += (long) take.val * take.freq;
        }
        while (!best.isEmpty() && !rest.isEmpty()) {
            Entry maxRest = rest.last();
            Entry minBest = best.first();
            if (maxRest.compareTo(minBest) > 0) {
                rest.pollLast();
                best.pollFirst();
                rest.add(minBest);
                best.add(maxRest);
                bestSum += (long) maxRest.val * maxRest.freq - (long) minBest.val * minBest.freq;
            } else break;
        }
    }
}