/*
 * 版权所有 2021 涂聚文有限公司
 * 许可信息查看：
 * 描述：
 *
 * 历史版本： JDK 14.02
 * 2021-12-12 创建者 geovindu
 * 2021-12-15 添加 Lambda
 * 2021-12-15 修改：date
 * 接口类
 * 2021-12-15 修改者：Geovin Du
 * 生成API帮助文档的指令：
 *javadoc - -encoding Utf-8 -d apidoc DuMain.java
 *
 * */




import com.mysql.cj.*;
import com.mysql.jdbc.*;
// import com.intellij.database.*;
// import com.intellij.database.dialects.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DuMain {





    public static void main(String[] args) {


        DuMsSQLConn msqlcon=new DuMsSQLConn();
        msqlcon.getConnection();

        DuMysqlCon c = new DuMysqlCon();
        c.getConnection();

        DuCon cn=new DuCon();
        cn.getConnection();


    }



}



