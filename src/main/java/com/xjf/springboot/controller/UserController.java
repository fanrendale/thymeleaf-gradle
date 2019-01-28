package com.xjf.springboot.controller;

import com.xjf.springboot.domain.User;
import com.xjf.springboot.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xjf
 * @date 2019/1/28 13:56
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRespository userRespository;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRespository.getUserList());
        model.addAttribute("title","用户管理");

        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView getUserById(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userRespository.getUserById(id));
        model.addAttribute("title","查看用户");

        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");

        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * 进行新增获取更新
     * @param user
     * @param model
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user,Model model){
        user = userRespository.saveOrUpdteUser(user);
        model.addAttribute("user",user);
        System.out.println("操作成功");

        return new ModelAndView("users/save","userModel",model);
    }
}
