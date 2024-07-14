package com.kieran.projects.haydayprofitabilityhelper.api.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String itemName) {
        super(itemName + " not found");
    }

}
