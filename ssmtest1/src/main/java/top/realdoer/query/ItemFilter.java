package top.realdoer.query;


import lombok.Data;
import top.realdoer.constant.ItemField;
import top.realdoer.constant.SortMethod;

/**
 * @author 孙继峰
 * @date 2019/03/12
 */
@Data
public class ItemFilter {
    /**
     *  过滤条件
     */
    public static final Integer DAY = 1;
    public static final Integer WEEK = 7;
    public static final Integer MONTH = 30;
    public static final Integer YEAR = 365;

    /**
     * 默认页码以及每页最大项目数
     */
    private static final Integer DEFAULT_INDEX = 1;
    private static final Integer DEFAULT_MAX_NUM_PER_PAGE = 5;

    /**
     * 最高价格/价格不大于
     */
    private Integer maxPrice;
    /**
     * 最低价格/价格不小于
     */
    private Integer minPrice;
    /**
     *  距离最后更新时间小于 X 天
     */
    private Integer pastDay;
    /**
     * 评分高于 1星, 2星, 3星, 4星
     */
    private Integer rate;
    /**
     * 项目标题模糊查询, 不需要加 %
     */
    private String titleLike;
    /**
     * 排序的列
     */
    private ItemField sortBy;
    /**
     * 排序方式
     */
    private SortMethod sortMethod;
    /**
     * 页码
     */
    private Integer index = DEFAULT_INDEX;
    /**
     * 每页最大显示数
     */
    private Integer maxNumPerPage = DEFAULT_MAX_NUM_PER_PAGE;
}
