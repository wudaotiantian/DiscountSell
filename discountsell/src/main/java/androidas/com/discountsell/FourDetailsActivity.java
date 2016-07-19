package androidas.com.discountsell;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

/**
 * Created by xwb on 2016/7/19.
 */
public class FourDetailsActivity extends AppCompatActivity {
    private WebView webView;
    private String url;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_details_activity);
        Intent intent=getIntent();
        url=intent.getStringExtra("path");
        londUrl(url);
        getBack();
    }
    public void londUrl(String url){
        webView= (WebView) findViewById(R.id.wv_four_details);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
    public void getBack(){
        imageView= (ImageView) findViewById(R.id.iv_four_details_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}
