package lsl.managersystem.serviceImpl;
import lsl.managersystem.dao.TagDao;
import lsl.managersystem.domain.Tag;
import lsl.managersystem.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.List;
@EnableTransactionManagement
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagDao TagDao;
    @Override
    public List<Tag> query() {
        return TagDao.query();
    }


    @Override
    public Tag queryid(String id) {
        return TagDao.queryid(id);
    }

    @Override
    public int insertTag(String name) {
        TagDao.insertTag(name);
        return 0;
    }



    @Override
    public int deleteTag(Integer id) {
        TagDao.deleteTag(id);
        return 0;
    }
}