package seu.vczz.service;

import seu.vczz.pojo.Category;
import seu.vczz.util.Page;

import java.util.List;

/**
 * CREATE by vczz on 2018/3/1
 */
public interface CategoryService {

    List<Category> list();

    //int total();

    void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);

}
