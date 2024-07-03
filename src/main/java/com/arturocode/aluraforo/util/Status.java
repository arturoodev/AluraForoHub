package com.arturocode.aluraforo.util;

public enum Status {
    OPEN("Abierto"),
    CLOSED("Cerrado");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public static Status fromString(String text){
        for(Status status1: Status.values()){
            if (status1.status.equalsIgnoreCase(text)){
                return status1;
            }
        }
        throw new IllegalArgumentException("No se encontro el estado: " + text);
    }
}
