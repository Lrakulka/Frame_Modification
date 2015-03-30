package com.task.krabiysok.myapplication;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.SurfaceView;

/** Program changes frame from camera.
 * Result:
 * Android gives to change copy of frame(use setPreviewCallback method of Camera)
 * Need to decode int array witch contains frame to rgb array
 * Some frames loses
 */
public class MainActivity extends ActionBarActivity {
    SurfaceView surfaceViewOrig;
    SurfaceView surfaceViewModiff;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceViewOrig = (SurfaceView) findViewById(R.id.surfaceViewOrigin);
        surfaceViewModiff = (SurfaceView) findViewById(R.id.surfaceViewModify);
    }

    @Override
    protected void onResume() {
        super.onResume();
        camera = Camera.open();
        camera.setDisplayOrientation(90); // Not work for onPreviewFrame. Gives frames without rotation.
        surfaceViewOrig.getHolder().addCallback(new OriginHolderCallback(camera));
        surfaceViewModiff.getHolder().addCallback(new ModifyHolderCallback(camera));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (camera != null)
            camera.release();
        camera = null;
    }
}
