package top.realdoer.constant;

/**
 *  网站模板兼容的浏览器类型常量
 */
public enum BrowerEnum implements BaseMyBatisConvertEnum<BrowerEnum, String> {
    
    IE6((byte)0,"IE6"), IE7((byte)1,"IE7"), IE8((byte)2,"IE8"), IE9((byte)3,"IE9"), IE10((byte)4,"IE10"), IE11((byte)5,"IE11"),
    FIREFOX((byte)6,"Firefox"), SAFARI((byte)7,"Safari"), OPERA((byte)8,"Opera"), CHROME((byte)9,"Chrome"), EDGE((byte)10,"Edge");

    private Byte key;
    private String value;
    
    private BrowerEnum(Byte key,String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public Byte getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setKey(Byte key) {
        this.key = key;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * fastJson 序列化配置枚举类型使用 toString() 方法进行序列化
     */
    @Override
    public String toString() {
        return this.value;
    }
}