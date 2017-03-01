package demo.mymockapi.dataapi.base;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Administrator on 2017/2/28.
 */

public abstract class BaseApi<T> {
    public Handler mHandler;

    public BaseApi() {
        mHandler=new Handler(Looper.getMainLooper());
    }

    public  void deliverySuccessResultToUI(final T t,
                                           final IOnDataResponse<T> callBack) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callBack.onSuccess(t);
            }
        });
    }

    public  void deliveryFailureResultToUI(final Throwable e,
                                           final IOnDataResponse<T> callBack) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callBack.onError(e);
            }
        });
    }

    public  void  deliveryResponseCodeErroResultToUI(final T t,
                                                     final IOnDataResponse<T> callBack) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callBack.onResponseCodeErro();
            }
        });
    }
}
