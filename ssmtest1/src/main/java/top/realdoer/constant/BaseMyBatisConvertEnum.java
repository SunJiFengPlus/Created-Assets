package top.realdoer.constant;

/**
 * MyBatis 类型转换时需要实现
 * @param <E> 需要转换的枚举类型
 * @param <T> 枚举 Value 类型
 */
public interface BaseMyBatisConvertEnum<E extends Enum<?>, T> {
    
    public Byte getKey();
    
    public String getValue();
    
    public void setKey(Byte key);
    
    public void setValue(String value);
}
