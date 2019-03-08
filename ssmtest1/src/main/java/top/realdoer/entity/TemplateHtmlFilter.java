package top.realdoer.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import top.realdoer.constant.ScriptEnum;
import top.realdoer.query.ItemFilter;

@Getter
@Setter
public class TemplateHtmlFilter extends ItemFilter {
    // 兼容插件
    public List<ScriptEnum> compatbleScript;

    @Override
    public String toString() {
        return "TemplateHtmlFilter [compatbleScript=" + compatbleScript + ", toString()=" + super.toString() + "]";
    }
}
