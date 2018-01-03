package com.sanketguru.notesapp.apiservice;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import timber.log.Timber;

/**
 * Created by Sanket Gurav on 12/12/2017.
 */

public class RequestInterceptor implements Interceptor {
    private boolean debug = false;
    private boolean decrypt = false;

    /**
     * */
    public RequestInterceptor(boolean debug, boolean decrypt) {
        this.debug = debug;
        this.decrypt = decrypt;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {

        final Request original = chain.request();
        final HttpUrl originalHttpUrl = original.url();

        final HttpUrl url = originalHttpUrl.newBuilder()
                //    .addQueryParameter("username", "demo")
                .build();

        // Request customization: add request headers
        final Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        Response response = chain.proceed(request);
        if (debug) {
            Timber.v("Request url  : [ %s ] -> [ %s ]", request.method(), request.url().toString());
            Timber.v("Request body : %s", request.body());
            Timber.v("Request head : %s", request.headers());

            //   Timber.v("Response url  : [ %s ] -> [ %s ]", request.method(), request.url().toString());
            Timber.v("Response body : [ %d ] -> %s",   response.code(),response.body());
            Timber.v("Response head : %s", response.headers());
        }
        if (decrypt) {
            //TODO encrypt request data here
        }
        return response;
    }
}
