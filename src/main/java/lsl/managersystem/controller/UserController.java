package lsl.managersystem.controller;
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

@Transactional
@RestController
@RequestMapping("/api/user")
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
        User User=UserService.queryid(id);
        return User;
    }
    @RequestMapping("/query")
    public List<User> query(){
        List<User>people=UserService.query();
        return people;
    }
    @GetMapping(value = "/test")
    public String testUser(){
        return "ok";
    }
    /**@ApiOperation(value="登录接口",notes ="验证登录后获取一个token")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="username",value="账号",required = true),
            @ApiImplicitParam(paramType="query",name="password",value="密码",required = true)
    })**/
    @PostMapping("/login")
    @ResponseBody
    public Map login(User user) {
        Map<Object, Object> map = new HashMap<>();
        User userForBase = UserService.queryid(user.getId());
        if (userForBase == null) {
            map.put("message", "登录失败,用户不存在");
            return map;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                map.put("message", "登录失败,密码错误");
                return map;
            } else {
                String token = tokenService.getToken(userForBase);
                map.put("token", token);
                map.put("user", userForBase);
                return map;
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
