package seu.vczz.mapper;

import seu.vczz.pojo.Category;
import seu.vczz.util.Page;

import java.util.List;

/**
 * CREATE by vczz on 2018/3/1
 */
public interface CategoryMapper {
    //查询所有分类
    List<Category> list(Page page);
    //查询分类个数
     int total();

}
