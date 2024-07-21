package com.example;

import java.sql.Timestamp;

public class HistoryResult {
    private String keyword;
    private Timestamp timestamp; // Add timestamp field

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
