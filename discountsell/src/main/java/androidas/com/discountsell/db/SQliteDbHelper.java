package androidas.com.discountsell.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQliteDbHelper extends SQLiteOpenHelper{
	
	//create table student(_id integer primary key,name text,age integer,phone char(11));
	private static final String CREATE_TABLE_STUDENT = "create table "+DbConstant.TABLE_NAME+"("
			+ DbConstant.COLUMN_NAME_ID+" integer primary key,"
			+ DbConstant.COLUMN_NAME_NAME+" text,"
			+ DbConstant.COLUMN_NAME_AGE+" integer,"
			+ DbConstant.COLUMN_NAME_PHONE+" char(11)"
			+ ");";
	

	/**
	 * 构造数据库
	 * @param context 上下文
	 */
	public SQliteDbHelper(Context context){
		//参数1: context 上下文
		//参数2: dbName   数据库名
		//参数3: CursorFactory  游标工厂，一般设置为null
		//参数4: version  版本号
		super(context, DbConstant.DB_NAME, null, DbConstant.DB_VERSION);
	}
	
	/**
	 * 创建数据表
	 * 
	 * 只会在第一次创建数据库时调用
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("xiaxin", "第一次创建数据库，才进入该方法.....");
		String sql=CREATE_TABLE_STUDENT;
		//执行生成数据表
		db.execSQL(sql);
	}
	
	/**
	 * 升级数据库
	 * 参数1: db  数据库
	 * 参数2: oldVersion 上一个版本号
	 * 参数3: newVersion 升级版本号
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i("xiaxin", "升级数据库，才进入该方法.....");
		if(newVersion>oldVersion){
			//drop table student
			String sql="drop table "+DbConstant.TABLE_NAME;
			db.execSQL(sql);
		}
		//重新生成数据表
		db.execSQL(CREATE_TABLE_STUDENT);
	}

}
