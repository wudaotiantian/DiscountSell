package androidas.com.discountsell.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidas.com.discountsell.R;
import androidas.com.discountsell.db.DbConstant;
import androidas.com.discountsell.db.DbUtils;

public class SearchActivity extends AppCompatActivity {

    private TextView tv;
    private EditText et;
    private ListView lv;
    private Button btn;
    private DbUtils dbUtils;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        dbUtils = new DbUtils(SearchActivity.this);
        Log.i("tag11", "onCreate: "+dbUtils);
        Cursor cursor=dbUtils.queryData(DbConstant.TABLE_NAME,
                new String[]{DbConstant.COLUMN_NAME_ID,DbConstant.COLUMN_NAME_NAME},
                null, null);

        adapter = new SimpleCursorAdapter(SearchActivity.this,R.layout.item_sql,cursor, new String[]{DbConstant.COLUMN_NAME_NAME},
                new int[]{R.id.tv_sql},SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tvLoc= (TextView) view.findViewById(android.R.id.text1);

               // String text = (String) ((TextView) view.).getText();
                Log.i("text11", "onItemClick: "+tvLoc);
                Cursor cursor = (Cursor) adapter.getItem(i);
                Intent intent = new Intent(SearchActivity.this, Search2Activity.class);
                intent.putExtra("key", cursor.getString(cursor
                        .getColumnIndex("name")));
                startActivity(intent);
            }
        });
        initListenner();
    }

    private void initListenner() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values=new ContentValues();
                String key = et.getEditableText().toString();
                Intent intent = new Intent(SearchActivity.this, Search2Activity.class);
                intent.putExtra("key",key);
                values.put(DbConstant.COLUMN_NAME_NAME, key);
                dbUtils.insertData(DbConstant.TABLE_NAME, values);
                Cursor cursor=dbUtils.queryData(DbConstant.TABLE_NAME,
                        new String[]{DbConstant.COLUMN_NAME_ID,DbConstant.COLUMN_NAME_NAME},
                        null, null);

                adapter = new SimpleCursorAdapter(SearchActivity.this,R.layout.item_sql,cursor, new String[]{DbConstant.COLUMN_NAME_NAME},
                        new int[]{R.id.tv_sql},SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
                lv.setAdapter(adapter);
                startActivity(intent);
            }
        });
    }

    private void initView() {

        tv = (TextView) findViewById(R.id.text_cancel);
        et = (EditText) findViewById(R.id.search_1);
        lv = (ListView) findViewById(R.id.lv_sql);
        btn = (Button)findViewById(R.id.all_cancel_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
