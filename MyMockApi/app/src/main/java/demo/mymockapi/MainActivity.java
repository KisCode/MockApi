package demo.mymockapi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mockito.Mockito;

import java.util.List;

import demo.mymockapi.dataapi.DataApiMananager;
import demo.mymockapi.dataapi.ITaskApi;
import demo.mymockapi.dataapi.base.IOnDataResponse;
import demo.mymockapi.model.ReturnModel;
import demo.mymockapi.model.Task;

public class MainActivity extends Activity {

    private TextView tvContent;
    private Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        fetchData();
    }

    private void initView()
    {
        tvContent=(TextView)findViewById(R.id.tv_content);
        btnRefresh=(Button)findViewById(R.id.btn_refresh);

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvContent.setText("加载网络数据...");
                fetchData();
            }
        });
    }

    private void fetchData()
    {
        ITaskApi api= DataApiMananager.ofTask();
        api.getTaskList(new IOnDataResponse<List<ReturnModel>>() {
            @Override
            public void onSuccess(List<ReturnModel> data) {
                tvContent.setText("获取网络数据:\n"+data.toString());
            }

            @Override
            public void onError(Throwable e) {
                tvContent.setText("网络错误:\n"+e.getMessage());
            }

            @Override
            public void onResponseCodeErro() {
                tvContent.setText("网络请求错误");
            }
        });
    }
}
