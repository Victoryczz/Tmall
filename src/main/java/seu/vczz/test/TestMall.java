package seu.vczz.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * CREATE by vczz on 2018/3/2
 * 测试类
 */
public class TestMall {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall?useUnicode=true&characterEncoding=utf8",
                    "root", "CHINAchen");
            Statement s = connection.createStatement();
            for (int i =0 ; i <= 10; i++){
                String sqlFormat = "INSERT INTO category VALUES(NULL, '测试分类%d')";
                String sql = String.format(sqlFormat, i);
                s.execute(sql);
            }
            System.out.println("插入了");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
