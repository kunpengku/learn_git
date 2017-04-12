package learn_mybatis;

import org.apache.ibatis.annotations.Select;

/**
 * Created by fupeng on 2017/4/12.
 */
public interface TestMapper {

    @Select("select * from users where id = #{id}")
    User getUser_3(int id);
}
