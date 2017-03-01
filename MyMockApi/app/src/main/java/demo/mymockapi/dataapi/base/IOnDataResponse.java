package demo.mymockapi.dataapi.base;

/**
 * 异步访问网络响应.
 */
public interface IOnDataResponse<T>  {
    //请求成功
    void onSuccess(T data);

    //服务器访问异常
    void onError(Throwable e);

    //请求状态码错误
    void onResponseCodeErro();
}