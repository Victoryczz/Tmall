package seu.vczz.service;

import seu.vczz.pojo.Category;
import seu.vczz.util.Page;

import java.util.List;

/**
 * CREATE by vczz on 2018/3/1
 */
public interface CategoryService {

    List<Category> list(Page page);

    int total();

    void add(Category category);

}
