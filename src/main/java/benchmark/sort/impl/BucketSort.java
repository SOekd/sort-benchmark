package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class BucketSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Bucket Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        int n = input.size();
        if (n == 0) return;

        int max = Collections.max(input);
        int min = Collections.min(input);
        int bucketCount = (max - min) / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int index = (input.get(i) - min) / n;
            buckets.get(index).add(input.get(i));
        }

        int currentIndex = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                input.set(currentIndex++, num);
            }
        }
    }
}
