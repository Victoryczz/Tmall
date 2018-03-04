package seu.vczz.util;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/**
 * CREATE by vczz on 2018/3/4
 * 解决mybatis-generator插件的一个bug
 */
public class OverIsMergeablePlugin extends PluginAdapter{
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }
}
