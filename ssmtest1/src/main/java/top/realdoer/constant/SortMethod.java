package top.realdoer.constant;

import lombok.Getter;

/**
 * 排序方式
 *  
 * @author 孙继峰
 */
@Getter
public enum SortMethod {
    ASC(0,"asc"), DESC(1,"desc");
    
    private Integer key;
    private String value;
    
    private SortMethod(Integer key,String value){
        this.key = key;
        this.value = value;
    }

}
