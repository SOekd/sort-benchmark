package benchmark.sort.impl;

import benchmark.sort.SortAlgorithm;

import java.util.List;


public final class RadixSort extends SortAlgorithm {

    @Override
    public String getName() {
        return "Radix Sort";
    }

    @Override
    protected void sort(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        int max = findMax(input);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(input, exp);
        }
    }

    private int findMax(List<Integer> input) {
        int max = input.get(0);
        for (int num : input) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private void countingSortByDigit(List<Integer> input, int exp) {
        int size = input.size();
        int[] output = new int[size];
        int[] count = new int[10];

        for (int num : input) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            int num = input.get(i);
            int digit = (num / exp) % 10;
            output[count[digit] - 1] = num;
            count[digit]--;
        }

        for (int i = 0; i < size; i++) {
            input.set(i, output[i]);
        }
    }
}