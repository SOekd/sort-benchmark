package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.List;

public final class InsertionSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Insertion Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        int n = input.size();

        for (int i = 1; i < n; ++i) {
            int key = input.get(i);
            int j = i - 1;

            while (j >= 0 && input.get(j) > key) {
                input.set(j + 1, input.get(j));
                j = j - 1;
            }
            input.set(j + 1, key);
        }
    }
}
