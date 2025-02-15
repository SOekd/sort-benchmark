package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.List;

public final class ShellSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Shell Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        int n = input.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                int temp = input.get(i);
                int j;

                for (j = i; j >= gap && input.get(j - gap) > temp; j -= gap) {
                    input.set(j, input.get(j - gap));
                }
                input.set(j, temp);
            }
        }
    }
}
