package demo.mymockapi.dataapi.base;

public interface IMockApiStrategy {
    void onResponse(int callCount, Response out);

    /**
     * Mock响应返回结果，表示响应的状态
     */
    class Response {
        public static final int STATE_NETWORK_ERROR = 1;
        public static final int STATE_SERVER_ERROR = 2;
        public static final int STATE_SUCCESS = 3;

        public int state = STATE_SUCCESS;
        public int delayMillis = 600;
    }
}