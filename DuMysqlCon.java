/*
 * 版权所有 2021 涂聚文有限公司
 * 许可信息查看：
 * 描述：
 *
 * 历史版本： JDK 14.02
 * 2021-12-12 创建者 geovindu
 * 2021-12-15 添加 Lambda
 * 2021-12-15 修改：date
 * 接口类 mysql-connector-java-8.0.27.jar.
 * 数据库：MySQL Server 8.0
 * 2021-12-15 修改者：Geovin Du
 * 生成API帮助文档的指令：
 *javadoc - -encoding Utf-8 -d apidoc DuMysqlCon.java
 *
 * */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



public class DuMysqlCon {

    Connection con;
    Statement stmt = null;
    //
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.cj.jdbc.Driver  com.mysql.jdbc.Driver访问需要相应的JAR版本，在安装的数据库下拷贝来引用
            System.out.println("mysql数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?characterEncoding=UTF-8", "root", "770214");

            System.out.println("mysql数据库连接成功");
            System.out.println(" 实例化Statement对象...");       // 执行查询
            stmt = con.createStatement();
            String sql;
            sql = "SELECT city_id,city,country_id  FROM city";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int cityid  = rs.getInt("city_id");
                String city = rs.getString("city");
                int countryid = rs.getInt("country_id");

                // 输出数据
                System.out.print("ID: " + cityid);
                System.out.print("  ,  城市名字: " + city);
                System.out.print("  , 区域cid: " + countryid);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            con.close();




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
