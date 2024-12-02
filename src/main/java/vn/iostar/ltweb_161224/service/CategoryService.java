package vn.iostar.ltweb_161224.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iostar.ltweb_161224.model.category;
import vn.iostar.ltweb_161224.model.user;
import vn.iostar.ltweb_161224.repository.iCategoryRepos;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    iCategoryRepos categoryRepos;

    public List<category> findAllCategories() {
        return categoryRepos.findAll();
    }

    public List<category> findCategoriesByUser(user user) {
        return new ArrayList<>(user.getCategories());
    }
}
