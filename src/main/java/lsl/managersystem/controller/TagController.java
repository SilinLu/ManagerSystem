package lsl.managersystem.controller;
import lsl.managersystem.config.ResponseData;
import lsl.managersystem.config.UserToken;
import lsl.managersystem.service.TokenService;
import lsl.managersystem.service.TagService;
import lsl.managersystem.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    TagService TagService;
    @Autowired
    TokenService tokenService;
    @UserToken.UserLoginToken
    @GetMapping("/getTagList")
    @ResponseBody
    public ResponseData getTagList() {
        Map<String, Object> map = new HashMap<>();
        ResponseData res;
        List<Tag> tagForBase = TagService.query();

        res=ResponseData.success();
        map.put("list", tagForBase);
        res.data(map);
        return res;
    }

    @UserToken.UserLoginToken
    @DeleteMapping("/deleteTag")
    @ResponseBody
    public ResponseData deleteTag(Tag tag) {
        Map<String, Object> map = new HashMap<>();
        ResponseData res;
        int tagForBase = TagService.deleteTag(tag.getId());

        res=ResponseData.success();
        map.put("id", tag.getId());
        res.data(map);
        return res;
    }

    @UserToken.UserLoginToken
    @PostMapping("/addTag")
    @ResponseBody
    public ResponseData addTag(String name) {
        Map<String, Object> map = new HashMap<>();
        ResponseData res;
        int tagForBase = TagService.insertTag(name);

        res=ResponseData.success();
        map.put("name", name);
        res.data(map);
        return res;
    }


}
