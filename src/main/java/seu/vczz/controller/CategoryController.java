package seu.vczz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import seu.vczz.pojo.Category;
import seu.vczz.service.CategoryService;
import seu.vczz.util.ImageUtil;
import seu.vczz.util.Page;
import seu.vczz.util.UploadedImageFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
     * 展示分类,使用分页插件
     */
    /*@RequestMapping("admin_category_list")
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
    }*/
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        //分页插件
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Category> categories = categoryService.list();
        //获得全部数量
        int total = (int) new PageInfo<>(categories).getTotal();
        page.setTotal(total);
        model.addAttribute("categories", categories);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
    /**
     * 添加分类
     */
    @RequestMapping("admin_category_add")
    public String add(Category category, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        //添加分类
        categoryService.add(category);
        //获得运行时环境路径，放置上传图片文件
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
        //图片以分类名称命名
        File file = new File(imageFolder, category.getId()+".jpg");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage image = ImageUtil.change2jpg(file);
        ImageIO.write(image, "jpg", file);
        return "redirect:/admin_category_list";
    }

    /**
     * 删除分类
     */
    @RequestMapping("admin_category_delete")
    public String delete(int id, HttpSession session){
        categoryService.delete(id);
        //删除图片文件
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, id+"jpg");
        file.delete();

        return "redirect:/admin_category_list";

    }

    /**
     * 通过id获取分类
     */
    @RequestMapping("admin_category_edit")
    public String get(int id, Model model){
        Category category = categoryService.get(id);
        model.addAttribute("category", category);
        return "admin/editCategory";
    }

    /**
     * 修改提交
     */
    @RequestMapping("admin_category_update")
    public String update(Category category, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(category);
        MultipartFile image = uploadedImageFile.getImage();
        //如果重新上传了图片，就覆盖掉之前的，否则什么也不做，这样前端依然能够取到之前的图片
        if (null != image && !image.isEmpty()){
            File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder, category.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }
}
