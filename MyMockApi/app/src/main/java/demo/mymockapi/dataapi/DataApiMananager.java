package demo.mymockapi.dataapi;


/**
 * Created by Administrator on 2017/2/28.
 */

public class DataApiMananager {

    /**
     * As simple example, when in debug build, we can use mock.
     */
    private static final boolean MOCK_ENABLE = true;

    public static ITaskApi ofTask() {
        if (MOCK_ENABLE) {
            ITaskApi api = new MockTaskApi();
            //返回MockApi
            if (api != null) {
                return api;
            }
        }
        //返回网络请求
        return new NetTaskApi();
    }
}