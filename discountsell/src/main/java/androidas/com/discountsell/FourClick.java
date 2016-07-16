package androidas.com.discountsell;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Created by xwb on 2016/7/14.
 */
public class FourClick extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_click_activity);
        intiView();

    }

    private void intiView() {
        GridView gridView= (GridView) findViewById(R.id.gv_four_click_activity);

    }

}
