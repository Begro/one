package test;

import java.util.List;

/**
 * Created by liuyan9 on 2017/7/14.
 */
public class Vo {
    private String content;
    private String timestamp;
    private List<Entity> entities;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Vo() {
    }
}
