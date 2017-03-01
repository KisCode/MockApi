package demo.mymockapi.dataapi;

import java.util.List;

import demo.mymockapi.dataapi.base.BaseMockApi;
import demo.mymockapi.dataapi.base.BaseNetApi;
import demo.mymockapi.dataapi.base.IOnDataResponse;
import demo.mymockapi.dataapi.okhttp.OnResponse;
import demo.mymockapi.dataapi.okhttp.StringRequest;
import demo.mymockapi.model.ReturnModel;
import demo.mymockapi.model.Task;

/**
 * Created by Administrator on 2017/2/28.
 */

public class NetTaskApi extends BaseNetApi implements ITaskApi {
    private final boolean MOCK_TASK_ENABLE=true;

    @Override
    public void getTaskList(final IOnDataResponse<List<ReturnModel>> response) {
        //1.异步 访问网络
        StringRequest.getAsyn("task/getTasklist", new OnResponse() {
            @Override
            public void onResponse(String result) {
//                得到服务器响应
                //解析 数据 根据状态
                deliverySuccessResultToUI(null,response);
            }

            @Override
            public void onFailure(Exception ex) {
                //服务器访问异常
                if(MOCK_TASK_ENABLE)
                {
                    //2.1获取数据后返回UI线程
                    //2.2访问服务器异常，通过MockAPI生成模拟数据返回
                    MockTaskApi api= new MockTaskApi();
                    api.getTaskList(response);
                }else
                {
                    deliveryFailureResultToUI(ex,response);
                }
            }
        });
    }
}
