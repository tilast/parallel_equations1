package me.kroosh.Lab1;

/**
 * Created by ihorkroosh on 2/18/15.
 */
public class Runner {
    public static void main(String[] args) {
        long startTime = 0;
        long msecTimeElapsed = 0;

        System.out.println("With 0.001 step: ");

            Integrator first = new Integrator(0.001, 2, 3);
            startTime = System.nanoTime();
            first.integrateSequetially();
            msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
            System.out.println("Time taken to sequential: " + msecTimeElapsed);
            System.out.println("=======");

            startTime = System.nanoTime();
            first.integrateParallel(10);
            System.out.println("Parallel equation: " + first.getParallelResult());
            msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
            System.out.println("Time taken to parallel: " + msecTimeElapsed);

        System.out.println("\n\n");

        System.out.println("With 0.0001 step: ");

            Integrator second = new Integrator(0.0001, 2, 3);
            startTime = System.nanoTime();
            second.integrateSequetially();
            msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
            System.out.println("Time taken to sequential: " + msecTimeElapsed);
            System.out.println("=======");

            startTime = System.nanoTime();
            second.integrateParallel(10);
            System.out.println("Parallel equation: " + second.getParallelResult());
            msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
            System.out.println("Time taken to parallel: " + msecTimeElapsed);

        System.out.println("\n\n");

        System.out.println("With 0.0005 step: ");
        Integrator third = new Integrator(0.0005, 2, 3);
            startTime = System.nanoTime();
            third.integrateSequetially();
            msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
            System.out.println("Time taken to sequential: " + msecTimeElapsed);
            System.out.println("=======");

            startTime = System.nanoTime();
            third.integrateParallel(10);
            System.out.println("Parallel equation: " + third.getParallelResult());
            msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
            System.out.println("Time taken to parallel: " + msecTimeElapsed);

        System.out.println("\n\n");

        System.out.println("With 0.001 step: ");

        Integrator first5 = new Integrator(0.001, 2, 3);
        startTime = System.nanoTime();
        first.integrateSequetially();
        msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Time taken to sequential: " + msecTimeElapsed);
        System.out.println("=======");

        startTime = System.nanoTime();
        first5.integrateParallel(5);
        System.out.println("Parallel equation: " + first5.getParallelResult());
        msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Time taken to parallel: " + msecTimeElapsed);

        System.out.println("\n\n");

        System.out.println("With 0.0001 step: ");

        Integrator second5 = new Integrator(0.0001, 2, 3);
        startTime = System.nanoTime();
        second5.integrateSequetially();
        msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Time taken to sequential: " + msecTimeElapsed);
        System.out.println("=======");

        startTime = System.nanoTime();
        second5.integrateParallel(5);
        System.out.println("Parallel equation: " + second5.getParallelResult());
        msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Time taken to parallel: " + msecTimeElapsed);

        System.out.println("\n\n");

        System.out.println("With 0.0005 step: ");
        Integrator third5 = new Integrator(0.0005, 2, 3);
        startTime = System.nanoTime();
        third5.integrateSequetially();
        msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Time taken to sequential: " + msecTimeElapsed);
        System.out.println("=======");

        startTime = System.nanoTime();
        third5.integrateParallel(5);
        System.out.println("Parallel equation: " + third5.getParallelResult());
        msecTimeElapsed = (System.nanoTime() - startTime) / 1000000;
        System.out.println("Time taken to parallel: " + msecTimeElapsed);

        System.out.println("\n\n");
    }
}
