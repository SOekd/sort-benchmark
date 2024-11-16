package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.List;

public final class ImprovedBubbleSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Improved Bubble Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        int n = input.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    int temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}

