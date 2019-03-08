package top.realdoer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  评分 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rate {
    private Integer itemId;
    // 评分
    private Double rate;
    // 评分人数
    private Short rateNum;
}