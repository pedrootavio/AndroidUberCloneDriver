package uber.com.br.androiduberclone.Remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import uber.com.br.androiduberclone.Model.FCMResponse;
import uber.com.br.androiduberclone.Model.Sender;

public interface IFCMService {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAqK7rm70:APA91bGBj0EQVrnkge38s04ESVOX5GTOK-NBdr2jK3-sVVlQfFC5TpXpjsyQ2Qu_uiyqgV03gApN28zru016_lrSTLQJchyvBmKAkS2FtpyHj3DwgzXIbliXNhzRHPRjoK99Y4p4Q_2k"
    })
    @POST("fcm/send")
    Call<FCMResponse> sendMessage(@Body Sender body);

}
