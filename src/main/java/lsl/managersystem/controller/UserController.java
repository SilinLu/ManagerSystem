package lsl.managersystem.controller;
import lsl.managersystem.config.ResponseData;
import lsl.managersystem.config.UserToken;
import lsl.managersystem.service.TokenService;
import lsl.managersystem.service.UserService;
import lsl.managersystem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService UserService;
    @Autowired
    TokenService tokenService;
    @RequestMapping("/insert")
    public String insertUser(User User){
        UserService.insertUser(User);
        return "ok";
    }
    @RequestMapping("/id")
    public User queryid(String id){
        return UserService.queryid(id);
    }
    @RequestMapping("/query")
    public List<User> query(){
        return UserService.query();
    }
    @GetMapping(value = "/test")
    public String testUser(){
        return "ok";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseData login(User user) {
        Map<String, Object> map = new HashMap<>();
        ResponseData res;
        User userForBase = UserService.queryid(user.getId());
        if (userForBase == null) {
            res=ResponseData.fail();
            res.msg("用户不存在");
            res.code(10001);
            return res;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                res=ResponseData.fail();
                res.msg("密码错误");
                res.code(10002);
                return res;
            } else {
                String token = tokenService.getToken(userForBase);
                res=ResponseData.success();
                map.put("token", token);
                res.data(map);
                return res;
            }
        }
    }
    //@ApiOperation(value="测试token",notes ="测试token是否通过")
    @UserToken.UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }


}
