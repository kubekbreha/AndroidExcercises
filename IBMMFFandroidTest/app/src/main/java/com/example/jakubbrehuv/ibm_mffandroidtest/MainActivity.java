package com.example.jakubbrehuv.ibm_mffandroidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.model.Response;
import com.worklight.wlclient.api.WLAccessTokenListener;
import com.worklight.wlclient.api.WLAuthorizationManager;
import com.worklight.wlclient.api.WLClient;
import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.auth.AccessToken;

import okhttp3.MediaType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private Button pushButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WLClient.createInstance(this);

        button = findViewById(R.id.submit_button);
        pushButton = findViewById(R.id.push_button);
        textView = findViewById(R.id.text_view);

        button.setTransformationMethod(null);
        button.setOnClickListener(this);
        pushButton.setOnClickListener(this);

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

        }else if(v.getId() == R.id.push_button){
            CloudantClient client = ClientBuilder.account("Cloudant NoSQL DB-bi")
                    .username("101cd02a-2daa-40b5-94a2-6f49790da45b-bluemix")
                    .password("6e78461ecad66b3816119f1cb23169852d7eb2ca16a139ee1d980f9ff43f31b7")
                    .build();
            System.out.println("Server Version: " + client.serverVersion());
        }
    }



}
