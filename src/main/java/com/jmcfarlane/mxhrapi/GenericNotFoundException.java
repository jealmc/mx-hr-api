package com.jmcfarlane.mxhrapi;

public class GenericNotFoundException extends RuntimeException {

    public GenericNotFoundException(String objectType) {
        super("Could not find " + objectType);
    }
}