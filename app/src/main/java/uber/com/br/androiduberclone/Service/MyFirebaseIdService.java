package uber.com.br.androiduberclone.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import uber.com.br.androiduberclone.Common.Common;
import uber.com.br.androiduberclone.Model.Token;

public class MyFirebaseIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        updateTokenToServer(refreshedToken); // When have refresh token, we need update to our Realtime database
    }

    private void updateTokenToServer(String refreshedToken) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference tokens = db.getReference(Common.token_tbl);

        Token token = new Token(refreshedToken);
        // if already login, must update Token
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            tokens.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(token);
        }
    }
}
