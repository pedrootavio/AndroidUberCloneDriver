package uber.com.br.androiduberclone.Common;

import uber.com.br.androiduberclone.Retrofit.IGoogleAPI;
import uber.com.br.androiduberclone.Retrofit.RetrofitClient;

public class Common {
    public static final String baseURL = "https://maps.googleapis.com";

    public static IGoogleAPI getGoogleAPI() {
        return RetrofitClient.getClient(baseURL).create(IGoogleAPI.class);
    }
}
