package com.whistle.whistlefeedjava;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Whistlefeed  extends ConstraintLayout {
     Context mContext;
     AttributeSet attrs;
     int def;
     WebView webView;

    public Whistlefeed(@NonNull Context context) {
        super(context);
        this.mContext=context;
        initview();

    }

    public Whistlefeed(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        this.attrs=attrs;
        initview();
    }

    public Whistlefeed(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        this.attrs=attrs;
        this.def=defStyleAttr;
        initview();

    }
public void initview()
{
    View view=inflate(mContext, R.layout.adds_view,this);
    webView=(WebView)view.findViewById(R.id.adswebview);
}

public void setadds(String publisher_token,String pencil)
{
    String packageName = getContext().getPackageName();
    Log.e("getpackagename ",packageName);
    String Scripttags="<!DOCTYPE html><html><body><script src=https://pixel.whistle.mobi/feedAds.js size="+pencil+" token="+publisher_token+" packagename="+packageName+"></script> </body> </html>";
    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    WebViewClientImpl webViewClient = new WebViewClientImpl(mContext);
    webView.setWebViewClient(webViewClient);
    webView.loadData(Scripttags, "text/html", "UTF-8");
}


}
