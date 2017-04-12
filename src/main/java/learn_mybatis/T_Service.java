package learn_mybatis;

/**
 * Created by fupeng on 2017/4/12.
 */
public class T_Service {

//    @Resource
    TestMapper mapper;

    T_Service(){

    }

    public User getUser(int id){
        User u =  mapper.getUser_3(id);

        return u;
    }
}
