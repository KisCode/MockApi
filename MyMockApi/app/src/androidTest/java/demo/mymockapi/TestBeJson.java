package demo.mymockapi;

import android.util.Log;

import org.junit.Test;
import org.mockito.Mockito;

import demo.mymockapi.model.TestJson;
import demo.mymockapi.model.Task;

/**
 * Created by Administrator on 2017/2/28.
 */

public class TestBeJson {

    @Test
    public void testJsonCreator()
    {
        TestJson json= Mockito.mock(TestJson.class);

        Log.i("i","ok");

        Task task=new Task();
//        ClassCreatorUtils.mo(task);
        Log.i("mockTask",task.toString());
    }
}
