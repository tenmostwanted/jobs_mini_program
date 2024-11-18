package top.vertical.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.vertical.pojo.User;

@Repository
public interface WxMapper extends BaseMapper<User> {
    @Select("select * from user where openid = #{openId}")
    User getByOpenId(String openId);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user values (null,#{openid}," +
            "#{name},#{phone},#{sex},#{idNumber}" +
            ",#{avatar},#{createTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void saveUser(User user);

}
