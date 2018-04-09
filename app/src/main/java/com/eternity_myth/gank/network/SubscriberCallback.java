package com.eternity_myth.gank.network;

import com.eternity_myth.gank.model.GankError;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class SubscriberCallback<T> extends Subscriber<T> {
    private ApiCallback<T> apiCallback;

    public SubscriberCallback(ApiCallback<T> apiCallback) {
        this.apiCallback = apiCallback;
    }

    @Override
    public void onCompleted() {
        apiCallback.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        String msg;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络不给力";
            }
            apiCallback.onFailure(code, msg);
        } else if (e instanceof SocketTimeoutException) {
            msg = "服务器连接超时";
            apiCallback.onFailure(GankError.ERROR_TIMEOUT, msg + "\r\n" + e.getMessage());
        } else if (e instanceof UnknownHostException) {
            msg = "未知主机地址错误";
            apiCallback.onFailure(GankError.ERROR_UNKNOWHOST, msg + "\r\n" + e.getMessage());
        } else {
            msg = e.getMessage();
            apiCallback.onFailure(GankError.ERROR_EXCEPTION, msg + "\r\n" + e.getMessage());
        }
        apiCallback.onCompleted();
    }


    @Override
    public void onNext(T t) {
        if (t == null) return;
        apiCallback.onSuccess(t);
    }
}
