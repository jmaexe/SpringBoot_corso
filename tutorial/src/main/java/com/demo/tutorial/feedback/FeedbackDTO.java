package com.demo.tutorial.feedback;

public class FeedbackDTO {
    private Long user_id;
    private String commento;

    public FeedbackDTO() {

    }

    public FeedbackDTO(Long user_id, String commento) {
        this.user_id = user_id;
        this.commento = commento;
    }

    public String getCommento() {
        return commento;
    }

    public Long getUserId() {
        return user_id;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return " user Id: " + user_id + ", commento : " + commento;
    }
}
