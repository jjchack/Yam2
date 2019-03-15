package cn.yc.yam.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 封装常用的操作
 * @author Jie.Yuan
 *
 */
public class JdbcUtils {

	// 初始化连接池
	private static DataSource dataSource;
	static {
		dataSource = new ComboPooledDataSource();
	}
	/**
	 * 连接池
	 * @return 返回连接池实例对象
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 创建DbUtils常用工具类对象
	 */
	public static QueryRunner getQuerrRunner() {
		return new QueryRunner(dataSource);
	}
	
}








