package lsl.managersystem.dao;
import lsl.managersystem.domain.Good;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface GoodDao {
    @Select(" select * from  Good")
    List<Good> query();
    @Select("select password,id from  Good where id=#{id}")
    Good queryid(String id);

    @Insert("insert into  Good(password, id)\n" +"values (#{password},#{id})")
    int insertGood( Good good);
    @Update("update  Good\n" +
            "    set password = #{password}\n" +
            "    where id = #{id}")
    int updateGood( Good good);
    @Delete("delete from  Good where id = #{id,jdbcType=VARCHAR}")
    int deleteGood( Good good);
}