package excercise.kubo.sk.codelab_facerecognition;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


public class CameraActivity extends AppCompatActivity {

    private Camera camera;
    private RelativeLayout relativeLayout;
    private ShowCamera showCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera);
        relativeLayout.findViewById(R.id.frame);

        //start camera
        camera = Camera.open();

        showCamera = new ShowCamera(this, camera);

    }




}
