package com.task.krabiysok.myapplication;

import android.hardware.Camera;
import android.view.SurfaceHolder;

/**
 * Created by KrabiySok on 3/29/2015.
 */
public class OriginHolderCallback implements SurfaceHolder.Callback {
    Camera camera;

    OriginHolderCallback(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        camera.stopPreview();
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        /*if (camera != null) {
            camera.stopPreview();
        }*/
    }

}
