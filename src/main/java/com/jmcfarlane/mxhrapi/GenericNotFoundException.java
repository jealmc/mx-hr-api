package com.jmcfarlane.mxhrapi;

class GenericNotFoundException extends RuntimeException {

    GenericNotFoundException(String objectType) {
        super("Could not find " + objectType);
    }
}