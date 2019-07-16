package com.example.hackathon.network.request;

public class WriteRequest {

    private String barcode;

    private String contents;

    public WriteRequest(String barcode, String contents) {
        this.barcode = barcode;
        this.contents = contents;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
