package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.List;

public final class SelectionSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Selection Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        int n = input.size();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (input.get(j) < input.get(min_idx)) {
                    min_idx = j;
                }
            }

            int temp = input.get(min_idx);
            input.set(min_idx, input.get(i));
            input.set(i, temp);
        }
    }
}
