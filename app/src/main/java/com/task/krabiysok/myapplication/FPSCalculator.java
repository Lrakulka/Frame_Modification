package com.task.krabiysok.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.LinkedList;

/**
 * Created by KrabiySok on 3/29/2015.
 */
public class FPSCalculator {
    private LinkedList<Long> times;
    private final int MAX_SIZE = 100;
    private final double NANOS = 1000000000.0;
    private Paint paint;
    private int x;
    private int y;

    FPSCalculator(int x, int y) {
        this.x = x;
        this.y = y;
        times = new LinkedList<Long>();
        paint = new Paint();
        paint.setColor(Color.YELLOW);
    }

    /** Calculates and returns frames per second */
    private double fps() {
        long lastTime = System.nanoTime();
        double difference = (lastTime - times.getFirst()) / NANOS;
        times.addLast(lastTime);
        int size = times.size();
        if (size > MAX_SIZE) {
            times.removeFirst();
        }
        return difference > 0 ? times.size() / difference : 0.0;
    }

    public void drawFPS(Canvas canvas) {
        canvas.drawText(String.valueOf(fps()), x, y, paint);
    }
}
