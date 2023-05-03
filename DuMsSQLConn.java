
/*
 * 版权所有 2021 涂聚文有限公司
 * 许可信息查看：
 * 描述：
 * IDE: IntelliJ IDEA 2021.2.3
 * 历史版本： JDK 14.02
 * 2021-12-12 创建者 geovindu
 * 2021-12-15 添加 Lambda
 * 2021-12-15 修改：date
 * 接口类 mssql-jdbc-9.4.1.jre16.jar.
 * 数据库：MSSQL Server 2019
 * 2021-12-15 修改者：Geovin Du
 * 生成API帮助文档的指令：
 *javadoc - -encoding Utf-8 -d apidoc DuMsSQLConn.java
 *https://www.microsoft.com/en-us/software-download/windows10
 *https://github.com/PaddlePaddle/PaddleOCR
 *https://docs.microsoft.com/es-es/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
 *https://github.com/microsoft/mssql-jdbc/blob/main/README.md

 * */



import java.sql.*;
//import com.microsoft.*;
//import com.microsoft.sqlserver.jdbc.*;
//import com.microsoft.*;
//import com.microsoft.sqlserver.*;


public class DuMsSQLConn {

    Connection con;
    Statement stmt = null;
    //
    public Connection getConnection()
    {

        //数据库地址
        String url = "jdbc:sqlserver://GEOVINDU;DataBaseName=geovindu";  //GEOVINDU  //localhost
        //
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //com.mysql.cj.jdbc.Driver  //com.mysql.jdbc.Driver
        //
        String userName = "sa";
        //
        String password = "770214";

        try {
            Class.forName(driverName);
            System.out.println("Ms SQL 数据库驱动加载成功");
        } catch
        (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            con = DriverManager.getConnection(url,userName,password);
            System.out.println("Ms SQL数据库连接成功");
            stmt = con.createStatement();
            String sql;
            sql = "SELECT RoleType,RoleTypeName,RoleTypeDescribe  FROM RoleTypeList";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int typid  = rs.getInt("RoleType");
                String rolename = rs.getString("RoleTypeName");
                String roledec = rs.getString("RoleTypeDescribe");

                // 输出数据
                System.out.print("角色ID: " + typid);
                System.out.print("  ,  角色名字: " + rolename);
                System.out.print("  , 角色描述: " + roledec);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            con.close();


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;

    }


}
