package org.mao.dubbo.dto;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Date;

public class FlyDTO implements Serializable {

    private String who;

    private Date when;

    private Long how;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Long getHow() {
        return how;
    }

    public void setHow(Long how) {
        this.how = how;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
