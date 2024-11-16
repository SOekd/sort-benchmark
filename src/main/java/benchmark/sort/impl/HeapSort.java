package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.List;

public final class HeapSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Heap Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        int n = input.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(input, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = input.get(0);
            input.set(0, input.get(i));
            input.set(i, temp);

            heapify(input, i, 0);
        }
    }

    private void heapify(List<Integer> input, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && input.get(l) > input.get(largest)) {
            largest = l;
        }

        if (r < n && input.get(r) > input.get(largest)) {
            largest = r;
        }

        if (largest != i) {
            int swap = input.get(i);
            input.set(i, input.get(largest));
            input.set(largest, swap);

            heapify(input, n, largest);
        }
    }
}

