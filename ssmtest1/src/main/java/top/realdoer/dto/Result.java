package top.realdoer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import top.realdoer.constant.ResultEnum;

/**
 * @author 孙继峰
 * @date 2019年2月22日
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    /**
     * 执行结果信息
     */
    private ResultEnum result;
    /**
     * 请求目标数据
     */
    private Object data;
    /**
     * 显示页码
     */
    private int[] navigatePages;
    /**
     * 当前页码
     */
    private Integer currentIndex;
    /**
     * 鉴权信息
     */
    private String token;
    /**
     * 路径
     */
    private String path;

    private Result(Builder builder) {
        this.data = builder.data;
        this.navigatePages = builder.navigatePages;
        this.currentIndex = builder.currentIndex;
        this.token = builder.token;
        this.path = builder.path;
        this.result = builder.result;
    }

    @Getter
    public static class Builder {
        private Object data;
        private int[] navigatePages;
        private Integer currentIndex;
        private String token;
        private String path;
        private ResultEnum result;

        public Builder buildData(Object data) {
            this.data = data;
            return this;
        }

        public Builder buildNavigatePages(int[] navigatePages) {
            this.navigatePages = navigatePages;
            return this;
        }

        public Builder buildCurrentIndex(Integer currentIndex) {
            this.currentIndex = currentIndex;
            return this;
        }

        public Builder buildToken(String token) {
            this.token = token;
            return this;
        }

        public Builder buildPath(String path) {
            this.path = path;
            return this;
        }

        public Builder buildResult(ResultEnum result) {
            this.result = result;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }
}
