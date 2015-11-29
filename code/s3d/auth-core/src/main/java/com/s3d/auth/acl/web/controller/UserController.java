package com.s3d.auth.acl.web.controller;

import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.service.UserService;
import com.s3d.auth.acl.vo.param.QueryUserParam;
import com.s3d.auth.acl.vo.param.UserIdListParam;
import com.s3d.auth.acl.vo.result.UserVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Model getUserList(HttpServletRequest request, final Model model, @RequestBody QueryUserParam queryUserParam) {
        // find user list and set model.
        List<User> users = this.userService.getUsers(queryUserParam);
        // to json.
        List<Map> jsonUsers = new ArrayList<Map>();
        if(users != null && users.size() >0){
            for(User user : users){
                Map oneUser = new HashMap();
                oneUser.put("id", user.getId());
                oneUser.put("realName", user.getFullName());
                jsonUsers.add(oneUser);
            }
        }
        return model;
    }
    @RequestMapping(value="/departments/{orgId}/departments/users", method = RequestMethod.GET)
    @ResponseBody
    public Map getUsersOfOrg(HttpServletRequest request,  @PathVariable(value = "orgId") Integer orgId,
                               @RequestParam(value = "page", defaultValue="0") Integer page,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        PageParam pageParam = new PageParam(page, pageSize);
        PageResult<User> result = this.userService.getUsers(orgId, pageParam);
        List<UserVO> userVOList = new ArrayList<UserVO>();
        List<User> userList = result.getResults();
        if(userList != null && userList.size() > 0){
            for(User user : userList){
                UserVO userVO = new UserVO(user);
                userVOList.add(userVO);
            }
        }
        Map map = new HashMap();
        map.put("count", result.getTotalRecords());
        map.put("users", userVOList);
        return map;
    }

    @RequestMapping(value = "/users/{userId}")
    public Model getUser(HttpServletRequest request, final Model model, @PathVariable Integer userId) {
        User user = this.userService.getById(userId);
        if (user == null) {
            model.addAttribute("user", null);
        } else {
            UserVO userVO = new UserVO(user);
            model.addAttribute("user", userVO);
        }
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Model saveOrUpdate(HttpServletRequest request, final Model model, @RequestBody UserVO userVO) {
        String failedMsg;
        try {
            this.userService.saveOrUpdate(userVO);
            failedMsg = "";
        } catch (Exception ex) {
            logger.error("Save or update user failed.", ex);
            failedMsg = ex.getMessage();
        }
        if (StringUtils.isEmpty(failedMsg)) {
            model.addAttribute("status", "succeed");
        } else {
            model.addAttribute("status", "failure");
            Map error = new HashMap();
            error.put("code", "Exception");
            error.put("message", failedMsg);
            model.addAttribute("error", error);
        }
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public Model delete(HttpServletRequest request, final Model model, @RequestBody UserIdListParam userIdListParam) {
        if (userIdListParam == null || userIdListParam.getUserIds() == null || userIdListParam.getUserIds().size() == 0) {
            model.addAttribute("status", "failure");
        } else {
            this.userService.delete(userIdListParam.getUserIds());
            model.addAttribute("status", "succeed");
        }
        return model;
    }

    public List query() {
        return null;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
