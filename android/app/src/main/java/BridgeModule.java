package com.my.package;

import android.content.Context;
import android.content.Intent;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class BridgeModule extends ReactContextBaseJavaModule{
    public BridgeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "BridgeModule";
    }

    @ReactMethod
    public void showFullscreen(String videoUri, int durationToSeek, String playerId) {
        Context context = getReactApplicationContext();
        Intent intent = new Intent(context, VideoActivity.class); // mContext got from your overriden constructor
        intent.putExtra("VIDEO_URL", videoUri);
        intent.putExtra("CURRENT_TIME", durationToSeek);
        intent.putExtra("PLAYER_ID", playerId);
        getCurrentActivity().startActivity(intent);
    }
}
