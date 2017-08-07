package firmanmfk.setorantunai.api;

import android.support.compat.BuildConfig;
import android.util.Log;

import firmanmfk.setorantunai.util.Logger;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by FirmanMFK on 7/12/17.
 */


public abstract class ApiCallback<T> implements Callback<T> {

    public abstract void onSuccess(T data);
    public abstract void onFailed(Throwable t);


    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        if(response.body() != null){
//            if(!BuildConfig.DEBUG){
                Logger.log(Log.INFO, "data -> " + response.body().toString());
//            }
            onSuccess(response.body());
        }else{
            onFailed(null);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(!BuildConfig.DEBUG){
            Logger.log(t);
        }
        onFailed(t);
    }

}
