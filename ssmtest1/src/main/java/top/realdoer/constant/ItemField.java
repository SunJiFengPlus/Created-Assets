package top.realdoer.constant;

import lombok.Getter;

/**
 * 项目中需要排序的列
 * 
 * @author 孙继峰
 */
@Getter
public enum ItemField {
    
    LAST_UPDATE(0,"last_update"), SALES(1,"sales"), RATE(2,"rate"),
    REGULAR_LICENSE_PRICE(3,"regular_license_price");
    
    private Integer key;
    private String value;
    
    private ItemField(Integer key, String value){
        this.key = key;
        this.value = value;
    }
}
