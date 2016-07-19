package androidas.com.myapplication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import androidas.com.myapplication.entity.TabEntity;
import androidas.com.myapplication.fragments.BlankFragment;
import androidas.com.myapplication.utils.ViewFindUtils;


public class MainActivity extends AppCompatActivity {
private CommonTabLayout tabLayout;
    private View mDecorView;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDecorView = getWindow().getDecorView();
tabLayout = ViewFindUtils.find(mDecorView,R.id.ctbl_1);
        mFragments2.add(BlankFragment.newInstance());
        mFragments2.add(Blank2Fragment.newInstance());
        mTabEntities.add(new TabEntity(mTitles[0]));
        mTabEntities.add(new TabEntity(mTitles[1]));
        mTabEntities.add(new TabEntity(mTitles[2]));
        mTabEntities.add(new TabEntity(mTitles[3]));
        mTabEntities.add(new TabEntity(mTitles[3]));
        mTabEntities.add(new TabEntity(mTitles[3]));
        mTabEntities.add(new TabEntity(mTitles[3]));
        ;

        tabLayout.setTabData(mTabEntities,this, R.id.rl_1, mFragments2);


    }
}
