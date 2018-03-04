package seu.vczz.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;

import org.mybatis.generator.internal.DefaultShellCallback;


import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CREATE by vczz on 2018/3/4
 * mybatis生成类
 * 1.由于每次运行时都会重新逆向覆盖掉之前的，所以只有日期一直才能运行
 */
public class MybatisGenerator {

    public static void main(String[] args) throws Exception{
        String today = "2018-03-04";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date theDay = sdf.parse(today);
        Date now = new Date();
        if (now.getTime()>theDay.getTime()+1000*60*60*24){
            System.out.println("------------------wow,日期不一致-----------------");
            return;
        }

        if (false)
            return;

        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        InputStream is = MybatisGenerator.class.getClassLoader().getResource("generatorConfig.xml").openStream();
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = configurationParser.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("----------只能一次------------------");
    }
}
