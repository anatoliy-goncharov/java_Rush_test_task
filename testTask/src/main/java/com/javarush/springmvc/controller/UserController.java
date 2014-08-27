package com.javarush.springmvc.controller;

import com.javarush.springmvc.domain.User;
import com.javarush.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Anatoliy_Goncharov on 21.08.2014.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /** Реализация пейджинга не есть гуд, лучше сделать его Autowired,
     *  но в таком проекте имеет место быть
     */
    protected PagedListHolder<User> articles;
    private boolean isInitedList = false;

    private void init() {
        if (!isInitedList) {
            isInitedList = true;
            articles = new PagedListHolder<User>();
            articles.setSource(userService.getList());
            articles.setPageSize(10);
        }
    }

    /**
     * Форма Создания пользователя
     * @param user
     * @return
     */
    @RequestMapping("form")
    public ModelAndView getForm(@ModelAttribute User user) {
        return new ModelAndView("form");
    }

    /**
     * Метод регистрации пользователя и перебрасывает
     * на обновленную страницу списка пользователей
     * @param user
     * @return
     */
    @RequestMapping("register")
    public ModelAndView registerUser(@ModelAttribute User user) {
        userService.insertRow(user);
        isInitedList = false;
        return new ModelAndView("redirect:list");
    }

    /**
     * Форма Редактирования пользователя
     * @param user
     * @return
     */
    @RequestMapping("edit")
    public ModelAndView editUser(@RequestParam int id,@ModelAttribute User user) {
        user = userService.getRowById(id);
        return new ModelAndView("edit","user",user);
    }

    /**
     * Метод обновления данных пользователя  и перебрасывает
     * на обновленную страницу списка пользователей
     * @param user
     * @return
     */
    @RequestMapping("update")
    public ModelAndView updateUser(@ModelAttribute User user) {
        userService.updateRow(user);
        isInitedList = false;
        return new ModelAndView("redirect:list");
    }

    /**
     * Удаление пользователя
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public ModelAndView deleteUser(@RequestParam int id) {
        userService.deleteRow(id);
        isInitedList = false;
        return new ModelAndView("redirect:list");
    }

    /**
     *  Форма списка всех пользователей
     * @return
     */
    @RequestMapping("list")
    public ModelAndView getList() {
        init();
        List userList = articles.getPageList();
        return new ModelAndView("list","userList",userList);
    }

    @RequestMapping("nextPage")
    public ModelAndView getNextPage() {
        articles.nextPage();
        return new ModelAndView("redirect:list");
    }


    @RequestMapping("prevPage")
    public ModelAndView getPrevPage() {
        articles.previousPage();
        return new ModelAndView("redirect:list");
    }

    /**
     * Форма поиска пользователя
     * @param user
     * @return
     */
    @RequestMapping("search")
    public ModelAndView search(@ModelAttribute User user) {
        return new ModelAndView("search");
    }

    /**
     * Форма вывода результата поиска пользователя
     * @param user
     * @return
     */
    @RequestMapping("searchUser")
    public ModelAndView getSearchList(@ModelAttribute User user) {
        List searchUsers = userService.getSearchList(user.getName());
        return new ModelAndView("searchList","searchUsers",searchUsers);
    }
}
