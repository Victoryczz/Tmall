package seu.vczz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import seu.vczz.pojo.Category;
import seu.vczz.service.CategoryService;
import seu.vczz.util.Page;

import java.util.List;

/**
 * CREATE by vczz on 2018/3/1
 */
@Controller
@RequestMapping("")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 展示分类
     */
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        //获取分类
        List<Category> categories = categoryService.list(page);
        //获取总数
        int total = categoryService.total();
        page.setTotal(total);
        //添加属性
        model.addAttribute("categories", categories);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }

}
