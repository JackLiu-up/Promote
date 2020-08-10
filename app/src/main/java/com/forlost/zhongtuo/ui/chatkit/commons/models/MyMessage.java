package com.forlost.zhongtuo.ui.chatkit.commons.models;

import java.util.Date;

public class MyMessage implements IMessage {
    String id;
    String text;
    String type;
    public MyMessage(String type,String id,String text){
        this.type=type;
        this.id=id;
        this.text=text;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public IUser getUser() {
        return null;
    }

    @Override
    public Date getCreatedAt() {
        return null;
    }
}
