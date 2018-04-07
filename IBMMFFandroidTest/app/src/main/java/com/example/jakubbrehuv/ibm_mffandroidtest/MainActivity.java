package com.example.jakubbrehuv.ibm_mffandroidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.worklight.wlclient.api.WLAccessTokenListener;
import com.worklight.wlclient.api.WLAuthorizationManager;
import com.worklight.wlclient.api.WLClient;
import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.auth.AccessToken;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WLClient.createInstance(this);

        button = findViewById(R.id.submit_button);
        textView = findViewById(R.id.text_view);

        button.setTransformationMethod(null);
        button.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submit_button ){
            WLAuthorizationManager.getInstance().obtainAccessToken("", new WLAccessTokenListener() {
                @Override
                public void onSuccess(AccessToken accessToken) {
                    System.out.println("received acces token is " + accessToken);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("sucess");
                        }
                    });
                }

                @Override
                public void onFailure(WLFailResponse wlFailResponse) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("failed");

                        }
                    });
                }
            });

        }
    }
}
