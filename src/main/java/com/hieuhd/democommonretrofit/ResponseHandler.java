package com.hieuhd.democommonretrofit;

import android.content.Context;
import android.util.Log;

public abstract class ResponseHandler<T>  {
    private static final String TAG = ResponseHandler.class.getSimpleName();

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private final Context context;

    public ResponseHandler() {
        this(null);
    }

    public ResponseHandler(final Context context) {
        this.context = context;
    }


    public abstract void onResponse(final T response);
    public void onError(final ModelEvent errorResponse) {
        if (context == null) {
            return;
        }
        Log.e("TAG", "An error occurred while invoking service. Error Code: " + errorResponse.getCode() + LINE_SEPARATOR + "Message: " + errorResponse.getModelMessage() + LINE_SEPARATOR);

    }

    public void onFailure(Throwable throwable) {
        if (context == null) {
            return;
        }
        Log.e("TAG", "An error occurred while invoking service", throwable);
    }
}
