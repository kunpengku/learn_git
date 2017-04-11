package learn_mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fupeng on 2017/4/11.
 */
public class MyBatis_T1 {

    public static void main(String[] args) {

        //mybatis的配置文件
        String resource = "mybatis_conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        //获取is 方法1
//        InputStream is = Main.class.getClassLoader().getResourceAsStream(resource);
        InputStream is = null;
        try {
            //获取is 方法2
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 2);

        session.close();
        System.out.println(user);

    }
}
