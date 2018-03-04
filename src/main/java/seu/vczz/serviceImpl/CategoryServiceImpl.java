package seu.vczz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.vczz.mapper.CategoryMapper;
import seu.vczz.pojo.Category;
import seu.vczz.pojo.CategoryExample;
import seu.vczz.service.CategoryService;
import seu.vczz.util.Page;

import java.util.List;

/**
 * CREATE by vczz on 2018/3/1
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    /*@Override
    public int total() {
        return categoryMapper.total();
    }*/

    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
