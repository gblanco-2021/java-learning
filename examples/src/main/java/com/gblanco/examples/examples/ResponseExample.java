package com.gblanco.examples.examples;

import lombok.Data;

@Data
public class ResponseExample {
    private String data;
    private String result;

    public boolean isValid(){
        return data != null && result != null;
    }
}
