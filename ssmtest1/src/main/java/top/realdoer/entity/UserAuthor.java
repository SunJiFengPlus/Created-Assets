package top.realdoer.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *  作者用户服务端模型 
 */
@JsonInclude(Include.NON_NULL)
public class UserAuthor extends User{
    // 收益
	private Integer earn;
	// 评级
    private Double rating;
	
    public Integer getEarn() {
        return earn;
    }
    public void setEarn(Integer earn) {
        this.earn = earn;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return "UserAuthor [earn=" + earn + ", rating=" + rating + ", toString()=" + super.toString() + "]";
    }
}
