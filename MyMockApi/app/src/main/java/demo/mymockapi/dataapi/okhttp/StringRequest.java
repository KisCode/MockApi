package demo.mymockapi.dataapi.okhttp;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * 封装OkHttp异步请求网络方式*
 * 
 * 通过二次封装，提供了get和post两种访问方式，把handler和子线程进行封装，调用时类似AsynTask
 * 可通过回调的方式在回调函数中直接进行UI绘制
 * 
 * @author K 2015/09/16 23:48
 */
@SuppressLint("NewApi")
public class StringRequest{

	/** 请求参数类型 */
	public static final MediaType REQUEST_TYPE = MediaType
			.parse("application/json; charset=utf-8");

	/** 连接超时10秒 */
	public static final long TIME_OUT = 10;

	private static StringRequest mInstance;
	private OkHttpClient mOkHttpClient;

	@SuppressLint("NewApi")
	private StringRequest() {
		mOkHttpClient = new OkHttpClient();

		// 设置连接超时
		mOkHttpClient.setConnectTimeout(TIME_OUT, TimeUnit.SECONDS);

		// cookie enabled
		mOkHttpClient.setCookieHandler(new CookieManager(null,
				CookiePolicy.ACCEPT_ORIGINAL_SERVER));
	}

	public static StringRequest getInstance() {
		if (mInstance == null) {
			synchronized (StringRequest.class) {
				if (mInstance == null) {
					mInstance = new StringRequest();
				}
			}
		}
		return mInstance;
	}


	/**
	 * 向服务器发起请求
	 * 
	 * @param request
	 * @param callBack
	 */
	private static void requestFromServer(final Request request,
			final OnResponse callBack) {
		// 初始化一个
		final Call call = getInstance().mOkHttpClient.newCall(request);
		// 执行请求
		call.enqueue(new Callback() {
			@Override
			public void onResponse(Response response) throws IOException {
				String result = response.body().string();
				Log.i("okresult", result);
				callBack.onResponse(result);
			}

			@Override
			public void onFailure(Request request, IOException ex) {
				callBack.onFailure(ex);
			}
		});
	}

	/***
	 * http get请求，访问结果以String类型在UI线程在回调函数中触发
	 *
	 * @param url
	 *            访问地址
	 * @param callBack
	 *            回调接口
	 */
	public static void getAsyn(String url, final OnResponse callBack) {
		// 初始化一个请求
		Request request = new Request.Builder().url(url).build();
		requestFromServer(request, callBack);
	}

	/**
	 * http get请求，访问结果以String类型在UI线程在回调函数中触发
	 *
	 * @param url
	 *            访问地址
	 * @param obj
	 *            post实体对象
	 * @param callBack
	 *            回调接口
	 */
	public static void postAsyn(String url, Object obj,
								final OnResponse callBack) {

		try {
			//TODO 对象转为json字符串作为post条件
//			String json = JsonUtils.initJsonString(obj);
			String json = "json";
			RequestBody body = RequestBody.create(REQUEST_TYPE, json);
			// 初始化一个请求
			Request request = new Request.Builder().url(url).post(body).build();
			requestFromServer(request, callBack);
		} catch (Exception e) {
			callBack.onFailure(e);
		}
	}
}