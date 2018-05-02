package uber.com.br.androiduberclone.Service;

import android.content.Intent;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import uber.com.br.androiduberclone.CustommerCall;

public class MyFirebaseMessaging extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //Because i will send the Firebase message with contain lat and lng from Rider app
        //So i need convert message to LatLng
        LatLng customer_location = new Gson().fromJson(remoteMessage.getNotification().getBody(), LatLng.class);

        Intent intent = new Intent(getBaseContext(), CustommerCall.class);
        intent.putExtra("lat", customer_location.latitude);
        intent.putExtra("lng", customer_location.longitude);

        startActivity(intent);

    }
}
