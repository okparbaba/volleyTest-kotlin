package com.softwarefactory.sdk.listener;

public interface StatusListener {

    void onSuccess();

    void onError(int errorCode);
}