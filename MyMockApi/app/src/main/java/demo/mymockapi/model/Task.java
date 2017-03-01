package demo.mymockapi.model;

/**
 * Created by Administrator on 2017/2/28.
 */

public class Task {
    public int id;
    public String name;
    public Score score;

    public Task()
    {}

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


}
