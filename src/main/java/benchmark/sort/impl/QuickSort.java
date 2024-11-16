package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.List;

public final class QuickSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Quick Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        quickSort(input, 0, input.size() - 1);
    }

    private void quickSort(List<Integer> input, int low, int high) {
        if (low < high) {
            int pi = partition(input, low, high);

            quickSort(input, low, pi - 1);
            quickSort(input, pi + 1, high);
        }
    }

    private int partition(List<Integer> input, int low, int high) {
        int pivot = input.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (input.get(j) <= pivot) {
                i++;

                int temp = input.get(i);
                input.set(i, input.get(j));
                input.set(j, temp);
            }
        }

        int temp = input.get(i + 1);
        input.set(i + 1, input.get(high));
        input.set(high, temp);

        return i + 1;
    }
}

