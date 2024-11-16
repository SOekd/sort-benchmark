package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public final class MergeSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        mergeSort(input, 0, input.size() - 1);
    }

    private void mergeSort(List<Integer> input, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;

            mergeSort(input, left, m);
            mergeSort(input, m + 1, right);

            merge(input, left, m, right);
        }
    }

    private void merge(List<Integer> input, int left, int m, int right) {
        int n1 = m - left + 1;
        int n2 = right - m;

        List<Integer> L = new ArrayList<>(n1);
        List<Integer> R = new ArrayList<>(n2);

        for (int i = 0; i < n1; ++i)
            L.add(input.get(left + i));
        for (int j = 0; j < n2; ++j)
            R.add(input.get(m + 1 + j));

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                input.set(k, L.get(i));
                i++;
            } else {
                input.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            input.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            input.set(k, R.get(j));
            j++;
            k++;
        }
    }
}
