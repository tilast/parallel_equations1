package me.kroosh.Lab1;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ihorkroosh on 2/18/15.
 */
public class Integrator {
    double h;
    double start;
    double end;
    double sequentialResult = 0;
    double parallelResult = 0;

    public double getParallelResult() {
        return parallelResult;
    }

    Integrator(double step, double startPoint, double endPoint) {
        h     = step;
        start = startPoint;
        end   = endPoint;
    }

    public void integrateSequetially() {
        double leftRectanglesResult = 0;
        double antiderivativeResult = 0;

        for(double i = start; i < end; i = i + h) {
            leftRectanglesResult += func(i) * h;
        }

        sequentialResult = leftRectanglesResult;

        System.out.println("Left rectangles: " + leftRectanglesResult);
//        System.out.println("Antiderivative:  " + (antiderivative(end) - antiderivative(start)));
    }

    public void integrateParallel(int threadsAmount) {
        List<Thread> threads = new ArrayList<>();

        double segmentLength = (end - start) / threadsAmount;

        for(int i = 0; i < threadsAmount; ++i) {
//            System.out.println("Segment start: " + (start + i * segmentLength) + ", segment finish: " + (start + (i + 1) * segmentLength));
            threads.add(new Thread(this.new IntegrateTask(start + i * segmentLength, start + (i + 1) * segmentLength)));
        }
//        System.out.println("Segment start: " + (start + segmentLength * (threadsAmount - 1)) + ", segment finish: " + (start + segmentLength * threadsAmount));

        for(Thread t: threads) {
            t.start();
        }

//        integratePart(start + segmentLength * (threadsAmount - 1), start + segmentLength * threadsAmount);

        for(Thread t: threads) {
            try {
                t.join();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class IntegrateTask implements Runnable {
        private double startPart;
        private double endPart;

        IntegrateTask(double start, double end) {
            startPart = start;
            endPart   = end;
        }

        @Override
        public void run() {
            integratePart(startPart, endPart);
        }
    }

    private void integratePart(double startPart, double endPart) {
        double localParallelResult = 0;
        double antiderivativeParallelResult = 0;
        double tmp;

        for(double i = startPart; i < endPart; i = i + h) {
            tmp = func(i) * h;
            parallelResult += tmp;
//            localParallelResult += tmp;
        }

//        antiderivativeParallelResult = antiderivative(endPart) - antiderivative(startPart);
    }

    private double func(double x) {
        double helper = 1.2;

        for(int i = 0; i < 10000000; ++i) {
            helper += i / (i + 1);
        }

        return Math.pow(x, 3.0) / Math.sqrt(Math.pow(Math.pow(x, 2.0) + 9.0, 3.0)) + (helper * 0);
    }

    private double antiderivative(double x) {
        double part = Math.sqrt(Math.pow(x, 2.0) + 9);
        return part + 9.0 / part;
    }

}