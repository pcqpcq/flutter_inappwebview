package com.pichillilorenzo.flutter_inappwebview;

import androidx.webkit.WebViewFeature;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class WebViewFeatureManager implements MethodChannel.MethodCallHandler {

  static final String LOG_TAG = "WebViewFeatureManager";

  public static MethodChannel channel;

  public WebViewFeatureManager(BinaryMessenger messenger) {
    channel = new MethodChannel(messenger, "com.pichillilorenzo/flutter_inappwebview_android_webviewfeature");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(MethodCall call, MethodChannel.Result result) {
    switch (call.method) {
      case "isFeatureSupported":
        String feature = (String) call.argument("feature");
        result.success(WebViewFeature.isFeatureSupported(feature));
      default:
        result.notImplemented();
    }
  }

  public void dispose() {
    channel.setMethodCallHandler(null);
  }
}
