package androidas.com.discountsell;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by my on 2016/7/18.
 */
public class DetailsActivity extends AppCompatActivity{
    private WebView mWebView;
    private String detailUrl;
    public static final String Url="http://www.baidu.com";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent=getIntent();
        detailUrl = intent.getStringExtra("detailUrl");
        mWebView = (WebView) findViewById(R.id.wv_product_detail);
        //WebView加载详情网址
        mWebView.loadUrl(detailUrl);
    }
}
