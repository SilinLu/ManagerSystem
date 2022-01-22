package lsl.managersystem.dao;
import lsl.managersystem.domain.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface TagDao {
    @Select(" select * from Tag")
    List<Tag> query();
    @Select("select name from Tag where id=#{id}")
    Tag queryid(String id);

    @Insert("insert into Tag( name)\n" +"values (#{name})")
    int insertTag(String tag);
    @Delete("delete from Tag where id = #{id}")
    int deleteTag(Integer id);
}