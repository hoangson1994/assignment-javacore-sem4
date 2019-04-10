package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    private int id;
    private String title;
    private String content;
    private int user_id;
    private int status;
    private long created_at;
    private long updated_at;

    private HashMap<String, ArrayList<String>> errors;
    public Feedback() {
    }

    public Feedback(String title, String content, int user_id) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.created_at = System.currentTimeMillis();
        this.updated_at = System.currentTimeMillis();
    }

    public Feedback(int id, String title, String content, int user_id, int status, long created_at, long updated_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public enum StatusFeedback {
        ACCEPTED (2),
        PROCESSING(1),
        DELETED(-1);

        private int value;

        StatusFeedback(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }
    }

    public boolean isValid() {
        validate();
        return this.errors.size() == 0;
    }

    public void validate() {
        if (errors == null) {
            errors = new HashMap<>();
        }
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> content = new ArrayList<>();
        if (this.title == null || this.title.length() == 0) {
            title.add("Title is required");
        }
        if (this.content == null || this.content.length() == 0) {
            content.add("Content is required");
        }

        if (title.size() > 0)
            this.errors.put("title", title);
        if (content.size() > 0)
            this.errors.put("content", content);
    }

    public HashMap<String, ArrayList<String>> getErrors(){
        return this.errors;
    }
}

