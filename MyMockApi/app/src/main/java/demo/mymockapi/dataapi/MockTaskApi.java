package demo.mymockapi.dataapi;

import android.util.Log;

import java.util.List;

import demo.mymockapi.dataapi.base.BaseMockApi;
import demo.mymockapi.dataapi.base.IOnDataResponse;
import demo.mymockapi.model.ReturnModel;
import demo.mymockapi.utils.MockUtils;

/**
 */
public class MockTaskApi extends BaseMockApi implements ITaskApi{
    @Override
    public void getTaskList(final IOnDataResponse<List<ReturnModel>> response) {
        //mock假数据
        List<ReturnModel> list= MockUtils.mockList(ReturnModel.class);
        dealResponse(response,list);
    }
}
