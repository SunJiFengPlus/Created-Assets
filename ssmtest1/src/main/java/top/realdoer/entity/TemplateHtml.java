package top.realdoer.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import top.realdoer.constant.BrowerEnum;
import top.realdoer.constant.ScriptEnum;
import top.realdoer.entity.Item;

/**
 *  网站模板服务端模型 
 */
@Getter
@Setter

public class TemplateHtml extends Item {
    // 示例链接
    private String demoUrl;
    // 兼容浏览器的枚举值集合
	private List<BrowerEnum> compatibleBrower;
	// 兼容插件的枚举值集合
	private List<ScriptEnum> compatibleScript;
	
    @Override
    public String toString() {
        return "TemplateHtml [demoUrl=" + demoUrl + ", compatibleBrower=" + compatibleBrower + ", compatibleScript="
                + compatibleScript + ", toString()=" + super.toString() + "]";
    }
}
