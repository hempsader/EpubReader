package com.example.epubreader;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SimpleContentFragment extends Fragment {
    public static final String KEY_STRING = "key_string";

    public static SimpleContentFragment newInstance(String file)
    {
        SimpleContentFragment fr = new SimpleContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_STRING, file);
        fr.setArguments(bundle);
        return fr;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_simple_content,container,false);
        WebView webView = v.findViewById(R.id.webVIew);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().getBuiltInZoomControls();
        webView.loadUrl(getPage());
        return v;
    }

    private String getPage()
    {
        Log.d("aa",getArguments().getString(KEY_STRING).toString());
        return getArguments().getString(KEY_STRING);
    }
}
