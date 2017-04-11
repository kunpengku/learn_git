package jdbc_learn;


import java.sql.*;

/**
 * Created by fupeng on 2017/4/10.
 *
 * //依赖
 <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
 <dependency>
 <groupId>mysql</groupId>
 <artifactId>mysql-connector-java</artifactId>
 <version>6.0.6</version>
 </dependency>
 
 */


public class Sjdbc {
    public static void main(String[] args) {
        System.out.println("q1");
        try{
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver") ;
        }catch(ClassNotFoundException e){
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace() ;
        }

        //连接MySql数据库，用户名和密码都是root
        String url = "jdbc:mysql://10.60.0.36:3306/mypipe" ;
        String username = "superadmin" ;
        String password = "super1qa2ws" ;
        try{
            Connection con =
                    DriverManager.getConnection(url , username , password ) ;

            Statement stmt = con.createStatement() ;

            ResultSet rs = stmt.executeQuery("SELECT * FROM users") ;

            while(rs.next()){
                String name = rs.getString("NAME") ;
                String age = rs.getString(3) ; // 此方法比较高效

                System.out.println(name+age);
            }

            if(rs != null){   // 关闭记录集
                try{
                    rs.close() ;
                }catch(SQLException e){
                    e.printStackTrace() ;
                }
            }
            if(stmt != null){   // 关闭声明
                try{
                    stmt.close() ;
                }catch(SQLException e){
                    e.printStackTrace() ;
                }
            }
            if(con != null){  // 关闭连接对象
                try{
                    con.close() ;
                }catch(SQLException e){
                    e.printStackTrace() ;
                }
            }


        }catch(SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace() ;
        }

    }
}
