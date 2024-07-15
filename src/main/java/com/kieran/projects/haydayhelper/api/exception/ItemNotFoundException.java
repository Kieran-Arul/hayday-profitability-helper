package com.kieran.projects.haydayhelper.api.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String itemName) {
        super(itemName + " not found");
    }

}
