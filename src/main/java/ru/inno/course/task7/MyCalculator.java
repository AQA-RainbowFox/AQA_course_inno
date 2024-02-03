package ru.inno.course.task7;

import java.util.Collection;

public class MyCalculator implements Calculator {

    @Override
    public int sum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    @Override
    public int sub(int a, int b) {
        int sub = a - b;
        return sub;
    }

    @Override
    public int mul(int a, int b) {
        int mul = a * b;
        return mul;
    }

    @Override
    public double div(int a, int b) {
        double div = (double) a / b;
        return div;
    }

    @Override
    public double avg(Collection<Integer> nums) {
        Integer sum = 0;
        for (Integer value : nums) {
            sum = sum + value;
        }
        Double avg = (double) (sum / nums.size());

        return avg;
    }

    @Override
    public int min(Collection<Integer> nums) {
        Integer min = Integer.MAX_VALUE;
        for (Integer value : nums) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public int max(Collection<Integer> nums) {
        Integer max = Integer.MIN_VALUE;
        for (Integer value : nums) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
