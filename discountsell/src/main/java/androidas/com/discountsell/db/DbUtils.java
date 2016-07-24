package androidas.com.discountsell.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbUtils {
	private SQLiteDatabase db;

	public DbUtils(Context context) {
		// 创建数据库
		SQliteDbHelper dbHelper = new SQliteDbHelper(context);
		// 获取数据库
		db = dbHelper.getWritableDatabase();
		// dbHelper.getReadableDatabase() 获取数据库，可读可写

		// 二者区别：getReadableDatabase()表示磁盘空间不足时，仍能读取数据库，不报异常
		// getWritableDatabase()表示磁盘空间不足时，读取数据库奔溃。
	}

	/**
	 * 获取数据库
	 * 
	 * @return
	 */
	public SQLiteDatabase getDataBase() {

		if (db != null) {
			return db;
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return db;
	}

	/**
	 * 关闭数据库
	 */
	public void closeDataBase() {
		if (db != null) {
			db.close();
		}
	}

	/**
	 * 插入数据
	 * 
	 * @table 表名
	 * @values 数据值(columnName, columnValue)
	 * @return 返回新插入行的ID
	 */
	public long insertData(String table, ContentValues values) {
		if (db != null) {
			return db.insert(table, null, values);
		}

		return 0;
	}
	
	
	/**
	 * 删除数据
	 * @param table 表名
	 * @param whereClause 条件语句
	 * @param whereArgs 填充占位符
	 * @return 返回删除的行数
	 */
	public int deleteData(String table, String whereClause, String[] whereArgs) {
		if (db != null) {
			return db.delete(table, whereClause, whereArgs);
		}
		return 0;
	}
	
	/**
	 * 查询数据表
	 * @param table 表名
	 * @param columns 列名集合 new String[]{"name","age","phone"}
	 * @param selection 条件语句
	 * @param selectionArgs 填充占为符
	 * @return 返回一个游标
	 */
	public Cursor queryData(String table, String[] columns, String selection, 
			String[] selectionArgs){
		if(db !=null){
			return db.query(table, columns, selection, selectionArgs,null, null, null);
		}
		return null;
	}
	
	/**
	 * 更新数据
	 * @param table 表名
	 * @param values 键值对
	 * @param whereClause 条件语句
	 * @param whereArgs 填充展位符
	 * @return 返回更新数据的行数
	 */
	public int updateData(String table,ContentValues values,String whereClause, 
			String[] whereArgs){
		if(db !=null){
			return db.update(table, values, whereClause, whereArgs);
		}
		
		return 0;
	}

}
