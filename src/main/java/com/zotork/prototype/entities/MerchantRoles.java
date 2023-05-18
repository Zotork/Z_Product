package com.zotork.prototype.entities;

import lombok.Getter;

@Getter
public enum MerchantRoles {
    USER(1,new String[]{"read"});

    private int id;
    private String[] authorities;

    MerchantRoles(int id, String[] auth){
        this.id = id;
        this.authorities = auth;
    }
}
