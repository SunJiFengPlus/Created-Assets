package top.realdoer.task;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时清理临时文件夹中的文件
 * 
 * @author 孙继峰
 * @date 2019/01/18
 */
@Component
@PropertySource("classpath:properties/server.properties")
public class FileCleaner {

    /**
     * 临时目录名
     */
    @Value("${temp_dir}")
    private String tempDirName;

    /**
     * 临时文件默认过期时间 24 小时, 单位:毫秒
     */
    @Value("${default_expired}")
    private Long defaultExpired;
    
    /**
     * 上下文路径
     */
    private static final String CONTEXT;
    

    static {
        // F:/workspace/.metadata/.me_tcat85/webapps/ssmtest1
        CONTEXT = (String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")))
                .replaceFirst("file:/", "").replaceFirst("/WEB-INF/classes/", "");
    }

    /*
     * 第一位，表示秒，取值0-59 第二位，表示分，取值0-59 第三位，表示小时，取值0-23 第四位，日期天/日，取值1-31
     * 第五位，日期月份，取值1-12 第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思 另外：1表示星期天，2表示星期一。
     * 第7为，年份，可以留空，取值1970-2099
     * 
     * (*)星号：可以理解为每的意思，每秒，每分，每天，每月，每年...
     * (?)问号：问号只能出现在日期和星期这两个位置，表示这个位置的值不确定，每天3点执行，所以第六位星期的位置，我们是不需要关注的，就是不确定的值。
     * 同时：日期和星期是两个相互排斥的元素，通过问号来表明不指定值。比如，1月10日，比如是星期1，如果在星期的位置是另指定星期二，就前后冲突矛盾了。
     * (-)减号：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12
     * (,)逗号：表达一个列表值，如在星期字段中使用“1,2,4”，则表示星期一，星期二，星期四
     * (/)斜杠：如：x/y，x是开始值，y是步长，比如在第一位（秒） 0/15就是，从0秒开始，每15秒，最后就是0，15，30，45，60
     */
    /**
     * 每隔 24 小时清理与文件创建时间相距超过 ${DEFAULT_EXPIRED} 时间的文件
     */
    @Scheduled(cron = "0 0 0 0/1 * ?")
    public void clean() {
        File tempDir = new File(CONTEXT + tempDirName);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }

        File[] allUserDir = tempDir.listFiles();
        for (File userDir : allUserDir) {
            // 过滤文件
            File[] expiredFiles = userDir.listFiles((dir, name) -> {
                // 去掉文件名后缀:  asdf.png -> asdf
                String fileNamePrefix = name.substring(0, name.lastIndexOf('.'));
                Long createdDate = Long.parseLong(fileNamePrefix);
                // 如果当前日期在过期日期之后, 则文件过期
                if (new Date().after(new Date(defaultExpired + createdDate))) {
                    return true;
                }
                return false;
            });
            
            // 删除文件
            for (File expiredFile: expiredFiles) {
                expiredFile.delete();
            }
        }
    }
}
