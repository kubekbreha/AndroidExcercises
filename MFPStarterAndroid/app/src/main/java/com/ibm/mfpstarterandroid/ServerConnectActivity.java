package com.ibm.mfpstarterandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;

import com.worklight.wlclient.api.WLAccessTokenListener;
import com.worklight.wlclient.api.WLAuthorizationManager;
import com.worklight.wlclient.api.WLClient;
import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import com.worklight.wlclient.auth.AccessToken;

import java.net.URI;
import java.net.URISyntaxException;
import android.util.Log;



public class ServerConnectActivity extends AppCompatActivity implements OnClickListener {

    private WLClient client;
    private android.widget.TextView connectionStatusLabel;
    private android.widget.TextView titleLabel;
    private android.widget.TextView serverURLLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        client = WLClient.createInstance(this);

        connectionStatusLabel = (android.widget.TextView) findViewById(R.id.connection_status_id);
        titleLabel = (android.widget.TextView) findViewById(R.id.title_id);
        serverURLLabel = (android.widget.TextView) findViewById(R.id.server_url_id);
        android.widget.Button pingButton = (android.widget.Button) findViewById(R.id.ping_mobilefirst_btn);
        pingButton.setTransformationMethod(null);
        pingButton.setOnClickListener(this);
    }

    @Override
    public void onClick(android.view.View v) {
        if (v.getId() == R.id.ping_mobilefirst_btn) {

            connectionStatusLabel.clearComposingText();
            connectionStatusLabel.setText("Connecting to Server...");
            serverURLLabel.setText(client.getServerUrl().toString());

            System.out.println("Testing Server Connection");



            WLAuthorizationManager.getInstance().obtainAccessToken("", new WLAccessTokenListener() {
                @Override
                public void onSuccess(AccessToken token) {
                    System.out.println("Received the following access token value: " + token);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            titleLabel.setText("Yay!");
                            connectionStatusLabel.setText("Connected to MobileFirst Server");
                        }
                    });

                    URI adapterPath = null;
                    try {
                        adapterPath = new URI("/adapters/javaAdapter/resource/greet");
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }


                    WLResourceRequest request = new WLResourceRequest(adapterPath, WLResourceRequest.GET);

                    request.setQueryParameter("name","world");
                    request.send(new WLResponseListener() {
                        @Override
                        public void onSuccess(WLResponse wlResponse) {
                            // Will print "Hello world" in LogCat.
                            Log.i("MobileFirst Quick Start", "Success: " + wlResponse.getResponseText());
                        }

                        @Override
                        public void onFailure(WLFailResponse wlFailResponse) {
                            Log.i("MobileFirst Quick Start", "Failure: " + wlFailResponse.getErrorMsg());
                        }
                    });
                }

                @Override
                public void onFailure(WLFailResponse wlFailResponse) {
                    System.out.println("Did not receive an access token from server: " + wlFailResponse.getErrorMsg());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            titleLabel.setText("Bummer...");
                            connectionStatusLabel.setText("Failed to connect to MobileFirst Server");
                        }
                    });
                }
            });




        }
    }
}
