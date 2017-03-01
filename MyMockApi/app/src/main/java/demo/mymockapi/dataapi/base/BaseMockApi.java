package demo.mymockapi.dataapi.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.List;

import demo.mymockapi.dataapi.base.IMockApiStrategy.Response;
import demo.mymockapi.model.ReturnModel;
import demo.mymockapi.utils.MockUtils;

public abstract class BaseMockApi<T> extends BaseApi<T>{
    protected int mCallCount;
    private IMockApiStrategy mStrategy;
    private Response mResponse = new Response();

    public Response onResponse() {
        if (mStrategy == null) {
            mStrategy = getMockApiStrategy();
        }

        if (mStrategy != null) {
            mStrategy.onResponse(mCallCount, mResponse);
            mCallCount++;
        }

        return mResponse;
    }

    protected IMockApiStrategy getMockApiStrategy() {
        return new WheelApiStrategy();
    }

    protected void dealResponse(IOnDataResponse<T> response,T t)
    {
        IMockApiStrategy.Response responseStrategy=onResponse();
        //模拟网络请求的三种状态{“成功”,"网络错误","服务器错误"}
        if(responseStrategy.state== IMockApiStrategy.Response.STATE_SUCCESS)
        {
            deliverySuccessResultToUI(t,response);
        }else if(responseStrategy.state== IMockApiStrategy.Response.STATE_NETWORK_ERROR)
        {
            deliveryResponseCodeErroResultToUI(null,response);
        }else if(responseStrategy.state== IMockApiStrategy.Response.STATE_SERVER_ERROR)
        {
            deliveryFailureResultToUI(new Exception("服务器访问异常"),response);
        }
    }
}
