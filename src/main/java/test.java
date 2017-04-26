import com.fanyank.mapper.UserMapper;
import com.fanyank.pojo.User;
import com.fanyank.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by yanfeng-mac on 2017/4/25.
 */
public class test {
    public static void main(String[] args) {
        SqlSession  sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        User user = userMapper.findById(3);
//        System.out.println(user);

        User user = new User();
        user.setUsername("swift");
        user.setPassword("123123");
        user.setGender(2);
        userMapper.insertUser(user);

        sqlSession.commit();
        sqlSession.close();
    }
}
