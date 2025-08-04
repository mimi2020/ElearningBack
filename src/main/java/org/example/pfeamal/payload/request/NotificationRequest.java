package org.example.pfeamal.payload.request;

public class NotificationRequest {

    private String title;
    private String body;
    private String topic;
    private String token;

    public NotificationRequest(String title, String body, String topic, String token) {
        this.title = title;
        this.body = body;
        this.topic = topic;
        this.token = token;
    }

    public NotificationRequest() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
