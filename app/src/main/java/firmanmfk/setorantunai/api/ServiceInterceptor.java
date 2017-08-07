package firmanmfk.setorantunai.api;

import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import firmanmfk.setorantunai.util.Logger;

/**
 * Created by FirmanMFK on 7/12/17.
 */


public class ServiceInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original;
//                requestBuilder.build();
        long t1 = System.nanoTime();
//        if(!android.support.compat.BuildConfig.DEBUG) {
            Logger.log(Log.INFO, String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));
//        }

        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
//        if(!android.support.compat.BuildConfig.DEBUG) {
            Logger.log(Log.INFO, String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
//        }

        return response;
    }
}
