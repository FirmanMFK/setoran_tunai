package firmanmfk.setorantunai.api;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import firmanmfk.setorantunai.BuildConfig;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by FirmanMFK on 7/12/17.
 */


public abstract class RetrofitBuilder {


    public static Retrofit getRetrofit() {

        OkHttpClient okHttpKlien = new OkHttpClient();
        okHttpKlien.setConnectTimeout(60, TimeUnit.SECONDS);
        okHttpKlien.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpKlien.interceptors().add(new ServiceInterceptor());

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpKlien)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RestApi create(Class c){
        return (RestApi) getRetrofit().create(c);
    }
}