package com.wuang.library.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * * 在进行导出的时候，需要注意命令语句的运行环境，如果已经将mysql安装路径下的bin加入到 *
 * 系统的path变量中，那么在导出的时候可以直接使用命令语句，否则，就需要在执行命令语句的 *
 * 时候加上命令所在位置的路径，即mysql安装路径想的bin下的mysqldump命令 * @author andy *
 */
public class CreateDBFile {
	public static void main(String args[]) {
		try {
			CreateDBFile.backup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 这里简单点异常我就直接往上抛
		// CreateDBFile.importSql(properties);
	}

	public static void backup() {
		int processComplete;
		try {
			InputStream is = CreateDBFile.class.getClassLoader()
					.getResourceAsStream("druid.properties");
			Properties properties = new Properties();
			properties.load(is);
			String username = properties.getProperty("druid.username");
			String password = properties.getProperty("druid.password");
			String exportDatabaseName = properties
					.getProperty("druid.exportDatabaseName");
			String host = properties.getProperty("druid.host");
			String port = properties.getProperty("druid.port");
			String exportPath = properties.getProperty("druid.exportPath")
					+ "library" + GetTime.getNumTime() + ".sql";
			String savePath = exportPath;
			String execCMD = "cmd.exe /C mysqldump" + " -u" + username
					+ " --password=" + password + " " + exportDatabaseName
					+ " -r " + savePath;
			System.out.println(execCMD.toString());
			Process process = Runtime.getRuntime().exec(execCMD);
			processComplete = process.waitFor();
			if (processComplete == 0) {
				System.out.println("备份成功.");
			} else {
				// throw new RuntimeException("备份数据库失败.");
				System.out.println("备份失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
