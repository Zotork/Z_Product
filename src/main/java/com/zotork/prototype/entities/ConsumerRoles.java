package com.zotork.prototype.entities;

public enum ConsumerRoles {
    USER(1,new String[]{"read"});

    private int id;
    private String[] authourities;

    ConsumerRoles(int id,String[] authorities){
        this.id= id;
        this.authourities = authorities;
    }

    String[] getAuthourities(){
        return this.authourities;
    }

    int getId(){
        return this.id;
    }
}
