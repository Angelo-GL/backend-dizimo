package com.dizimo.backend_dizimo.exceptions;

public class EntityConflict extends RuntimeException{
    public EntityConflict (String msg){
        super(msg);
    }
}
