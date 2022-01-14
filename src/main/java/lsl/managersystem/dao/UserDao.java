package lsl.managersystem.dao;
import lsl.managersystem.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface UserDao {
    @Select(" select * from User")
    List<User> query();
    @Select("select password,id from User where id=#{id}")
    User queryid(String id);

    @Insert("insert into User(password, id)\n" +"values (#{password},#{id})")
    int insertUser(User User);
    @Update("update User\n" +
            "    set password = #{password}\n" +
            "    where id = #{id}")
    int updateUser(User User);
    @Delete("delete from User where id = #{id,jdbcType=VARCHAR}")
    int deleteUser(User User);
}