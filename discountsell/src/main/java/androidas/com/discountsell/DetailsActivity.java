package androidas.com.discountsell;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by my on 2016/7/18.
 */
public class DetailsActivity extends AppCompatActivity {
    private WebView mWebView;
    private String detailUrl;
    public static final String Url="http://www.baidu.com";
    private TextView detailPageProductName;
    private String detailTitle;
    private ImageView imageViewBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //获取详情页面上部的ImageView控件
        imageViewBack = (ImageView) findViewById(R.id.iv_detail_page_back);
        //获取详情页面上部的TextView控件
        detailPageProductName = (TextView) findViewById(R.id.tv_detail_page_product_name);
        //接收从Fragment传递过来的数据
        Intent intent=getIntent();
        //详情的URL
        detailUrl = intent.getStringExtra("detailUrl");
        //详情的标题
        detailTitle = intent.getStringExtra("detailTitle");
        //获取详情的WebView控件
        mWebView = (WebView) findViewById(R.id.wv_product_detail);
        //将Fragment传递过来的数据填充到标题
        detailPageProductName.setText(detailTitle);
        //将WebView设置为在自身显示，不用跳到手机的浏览器显示
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        //WebView加载详情网址
        mWebView.loadUrl(detailUrl);

        //设置ImageView点击返回
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this, "返回", Toast.LENGTH_SHORT).show();
                //返回键
                onBackPressed();
            }
        });
    }
}
