package androidas.com.discountsell;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidas.com.discountsell.fragment.FirstFragment;
import androidas.com.discountsell.fragment.FiveFragment;
import androidas.com.discountsell.fragment.FourFragment;
import androidas.com.discountsell.fragment.SecondFragment;
import androidas.com.discountsell.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rgp;

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private SecondFragment newFragment;
    private FirstFragment storyFragment;
    private ThirdFragment spFragment;
    private FourFragment myFragment;
    private FiveFragment fiveFragment;

    //private FragmentManager manager;
    private View view;
    private View view1;
    private LinearLayout vp;
    private LinearLayout frameLayout;
//nih
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/
        setContentView(R.layout.activity_main);
        rgp = (RadioGroup) findViewById(R.id.rg_button);
        rgp.setOnCheckedChangeListener(this);
        manager = getSupportFragmentManager();
        RadioButton childAt = (RadioButton) rgp.getChildAt(0);
        childAt.setChecked(true);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        {
            transaction = manager.beginTransaction();
            //transaction.setCustomAnimations(R.anim.enter, R.anim.exit);
            switch (i) {
                case R.id.rb_guide:
                    if (storyFragment == null) {
                        storyFragment = FirstFragment.newInstance();
                        transaction.add(R.id.ll_main, storyFragment, "story");
                        if (spFragment != null) {
                            transaction.hide(spFragment);
                        }
                        if (myFragment != null) {
                            transaction.hide(myFragment);
                        }
                        if (newFragment != null) {
                            transaction.hide(newFragment);
                        }if (fiveFragment != null) {
                            transaction.hide(fiveFragment);
                        }
                    } else {
                        transaction.show(storyFragment);
                        if (spFragment != null) {
                            transaction.hide(spFragment);
                        }
                        if (myFragment != null) {
                            transaction.hide(myFragment);
                        }
                        if (newFragment != null) {
                            transaction.hide(newFragment);
                        }if (fiveFragment != null) {
                            transaction.hide(fiveFragment);
                        }
                    }
                    break;
                case R.id.rb_hot:
                    if (newFragment == null) {
                        newFragment = SecondFragment.newInstance();
                        transaction.add(R.id.ll_main, newFragment, "new");
                        if (spFragment != null) {
                            transaction.hide(spFragment);
                        }
                        if (myFragment != null) {
                            transaction.hide(myFragment);
                        }
                        if (storyFragment != null) {
                            transaction.hide(storyFragment);
                        }if (fiveFragment != null) {
                            transaction.hide(fiveFragment);
                        }
                    } else {
                        transaction.show(newFragment);
                        if (spFragment != null) {
                            transaction.hide(spFragment);
                        }
                        if (myFragment != null) {
                            transaction.hide(myFragment);
                        }
                        if (storyFragment != null) {
                            transaction.hide(storyFragment);
                        }if (fiveFragment != null) {
                            transaction.hide(fiveFragment);
                        }
                    }
                    break;
                case R.id.rb_classify:
                    if (spFragment == null) {
                        spFragment = ThirdFragment.newInstance();
                        transaction.add(R.id.ll_main, spFragment, "sp");
                        if (storyFragment != null) {
                            transaction.hide(storyFragment);
                        }
                        if (myFragment != null) {
                            transaction.hide(myFragment);
                        }
                        if (newFragment != null) {
                            transaction.hide(newFragment);
                        }
                        if (fiveFragment != null) {
                            transaction.hide(fiveFragment);
                        }
                    } else {
                        transaction.show(spFragment);
                        if (storyFragment != null) {
                            transaction.hide(storyFragment);
                        }
                        if (myFragment != null) {
                            transaction.hide(myFragment);
                        }
                        if (newFragment != null) {
                            transaction.hide(newFragment);
                        }
                        if (fiveFragment != null) {
                            transaction.hide(fiveFragment);
                        }
                    }
                    break;
                case R.id.rb_my:
                    if (myFragment == null) {
                        myFragment = FourFragment.newInstance();
                        transaction.add(R.id.ll_main, myFragment, "my");
                        if (spFragment != null) {
                            transaction.hide(spFragment);
                        }
                        if (fiveFragment != null) {
                            transaction.hide(fiveFragment);
                        }
                        if (storyFragment != null) {
                            transaction.hide(storyFragment);
                        }
                        if (newFragment != null) {
                            transaction.hide(newFragment);
                        }
                    } else {
                        transaction.show(myFragment);
                        if (spFragment != null) {
                            transaction.hide(spFragment);
                        }
                        if (storyFragment != null) {
                            transaction.hide(storyFragment);
                        }
                        if (newFragment != null) {
                            transaction.hide(newFragment);
                        }
                        if (fiveFragment != null) {
                            transaction.hide(fiveFragment);
                        }
                    }
                    break;
                case R.id.rb_final:
                    if (fiveFragment == null) {
                        fiveFragment = FiveFragment.newInstance();
                        transaction.add(R.id.ll_main, fiveFragment, "my");
                        if (spFragment != null) {
                            transaction.hide(spFragment);
                        }
                        if (storyFragment != null) {
                            transaction.hide(storyFragment);
                        }
                        if (newFragment != null) {
                            transaction.hide(newFragment);
                        }if(myFragment != null){
                            transaction.hide(myFragment);
                        }
                    } else {
                        transaction.show(fiveFragment);
                        if (spFragment != null) {
                            transaction.hide(spFragment);
                        }
                        if (storyFragment != null) {
                            transaction.hide(storyFragment);
                        }
                        if (newFragment != null) {
                            transaction.hide(newFragment);
                        }if(myFragment != null){
                            transaction.hide(myFragment);
                        }
                    }
                    break;
            }
            transaction.commit();
        }
    }
}
