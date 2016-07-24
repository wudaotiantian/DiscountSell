package androidas.com.discountsell;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            String encode = URLEncoder.encode("衣服", "UTF-8");
            Log.i("tag222", "onCreate: "+encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
