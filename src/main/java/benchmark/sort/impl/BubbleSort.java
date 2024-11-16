package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.List;

public final class BubbleSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Bubble Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        int n = input.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    int temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }
    }


}
