package excercise.kubo.sk.codelab_facerecognition;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


public class CameraActivity extends AppCompatActivity {

    private Camera camera;
    private FrameLayout frameLayout;
    private ShowCamera showCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera);


        frameLayout = findViewById(R.id.frame);

        //start camera

        try {

            camera = Camera.open();
            showCamera = new ShowCamera(this, camera);
            frameLayout.addView(showCamera);

        }catch (Exception e){
            Log.e("Error", ""+e);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }
}
