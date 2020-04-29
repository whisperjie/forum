package com.whisper.forum.exception;

public class NoLoginException extends Exception {
    @Override
    public String toString() {
        return "not login";
    }
}
