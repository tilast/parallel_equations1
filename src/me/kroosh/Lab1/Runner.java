package me.kroosh.Lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ihorkroosh on 2/18/15.
 */
public class Runner {
    public static void main(String[] args) {
        long startTimeSequential = 0;
        long msecTimeElapsedSequential = 0;
        long startTimeParallel = 0;
        long msecTimeElapsedParallel = 0;
        double acceleration = 1;
        double efficiency = 1;

        double steps[] = {0.01, 0.001, 0.005};
        int threadAmounts[] = {5, 10, 15};

//        List<Integrator> integrators = new ArrayList<>();
        Integrator current;

        for(int i = 0; i < steps.length; ++i) {
            for(int j = 0; j < threadAmounts.length; ++j) {
                System.out.println("With " + steps[i] + " step: ");

                current = new Integrator(steps[i], 2, 3);

                startTimeSequential = System.nanoTime();
                current.integrateSequetially();
                msecTimeElapsedSequential = (System.nanoTime() - startTimeSequential) / 1000000;
                System.out.println("Time taken to sequential: " + msecTimeElapsedSequential);
                System.out.println("=======");

                startTimeParallel = System.nanoTime();
                current.integrateParallel(threadAmounts[j]);
                System.out.println("Parallel equation with " + threadAmounts[j] +" threads: " + current.getParallelResult());
                msecTimeElapsedParallel = (System.nanoTime() - startTimeParallel) / 1000000;
                System.out.println("Time taken to parallel: " + msecTimeElapsedParallel);

                acceleration = (double)msecTimeElapsedSequential / (double)msecTimeElapsedParallel;
                efficiency   = acceleration / (double)threadAmounts[j];

                System.out.println("Acceleration: " + acceleration + ", efficiency: " + efficiency);

                System.out.println("\n\n");
            }
        }
    }
}
