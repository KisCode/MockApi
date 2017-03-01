package demo.mymockapi.dataapi;

import java.util.List;

import demo.mymockapi.dataapi.base.IOnDataResponse;
import demo.mymockapi.model.ReturnModel;
import demo.mymockapi.model.Task;

/**
 * Created by Administrator on 2017/2/28.
 * 任务模块 所有访问数据方法
 */
public interface ITaskApi {
    void getTaskList(IOnDataResponse<List<ReturnModel>> response);
}
