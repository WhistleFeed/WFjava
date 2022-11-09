package com.whistle.whistlefeedjava;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Whistlefeed  extends ConstraintLayout {
     Context mContext;
     AttributeSet attrs;
     int def;
     WebView webView;
    RequestQueue mRequestQueue;
    StringRequest mStringRequest;
    String BASE_URL="";
    String STAGING_URL="http://13.232.216.75/whistle-pixel/feedAds.php?";
    String LIVE_URL="https://pixel.whistle.mobi/feedAds.php?";
    Boolean islivelink=true;


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

    Log.d("printpubtoken",publisher_token);
   String packageName = getContext().getPackageName();
    Log.e("getpackagename ",packageName);

    if(islivelink)
    {
        Log.e("getpackagename ",islivelink.toString());

        BASE_URL=LIVE_URL;
        Log.d("baseurlforlive",BASE_URL+"packagename="+packageName+"&size="+pencil+"&apiToken="+publisher_token);
    }
    else
    {
        BASE_URL=STAGING_URL;
        Log.d("baseurlforstaging",BASE_URL+"packagename="+packageName+"&size="+pencil+"&apiToken="+publisher_token);
    }

    mRequestQueue = Volley.newRequestQueue(mContext);
    // String Request initialized
    Log.d("FCEFCECE",mRequestQueue.toString());

    mStringRequest = new StringRequest(Request.Method.GET, BASE_URL+"packagename="+packageName+"&size="+pencil+"&apiToken="+publisher_token, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.i("", "RESPONSE :" + response.toString());
            try {
                JSONObject jObject = new JSONObject(response);
                Log.d("jsonresponse",jObject.toString());

                if(jObject.getString("status").equals("Success"))
                {
                  String scripttags = jObject.getString("data");
                     //String Scripttags="<!DOCTYPE html><html><body><script src=https://pixel.whistle.mobi/feedAds.js size="+pencil+" token="+publisher_token+" packagename="+packageName+"></script> </body> </html>";
                    WebSettings webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    WebViewClientImpl webViewClient = new WebViewClientImpl(mContext);
                    webView.setWebViewClient(webViewClient);
                    webView.loadData(scripttags, "text/html", "UTF-8");
                    Log.d("scripttags",scripttags);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("sdad",e.toString());
            }


            Toast.makeText(mContext, "Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.i("", "Error :" + error.toString());
        }

    });
    mRequestQueue.add(mStringRequest);

 }
}
