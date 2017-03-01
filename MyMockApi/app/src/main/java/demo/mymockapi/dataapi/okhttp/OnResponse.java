package demo.mymockapi.dataapi.okhttp;

import java.io.IOException;

/**
 * Created by Administrator on 2017/2/28.
 */

public interface OnResponse {
    void onResponse(String result);
    void onFailure(Exception ex);
}
