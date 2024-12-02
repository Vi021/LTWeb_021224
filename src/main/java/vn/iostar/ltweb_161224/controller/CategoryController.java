package vn.iostar.ltweb_161224.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import vn.iostar.ltweb_161224.model.category;
import vn.iostar.ltweb_161224.model.user;
import vn.iostar.ltweb_161224.service.CategoryService;
import vn.iostar.ltweb_161224.service.UserService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @QueryMapping
    public List<category> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @QueryMapping
    public List<category> findCategoriesByUser(@Argument Long userId) {
        user user = userService.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("user not found");
        }

        return categoryService.findCategoriesByUser(user);
    }
}
