package top.realdoer.constant;

/**
 *  网站模板兼容的插件常量
 */
public enum ScriptEnum implements BaseMyBatisConvertEnum<BrowerEnum, String> {
    
    FACEBOOK((byte)0,"FaceBook"), ECWID((byte)1,"Ecwid"), ANGULARJS((byte)2,"AngularJS"), 
    ANGULARJS2((byte)3,"AngularJS 2"), ANGULARJS3((byte)4,"AngularJS 3.0.X"), 
    ANGULARJS4((byte)5,"AngularJS 4.0.X"), ANGULARJS5((byte)6,"AngularJS 5.0.X"), 
    ANGULARJS6((byte)7,"AngularJS 6.0.X"), REACTJS((byte)8,"ReactJS"), BOOTSTRAP4((byte)9,"BootStrap 4.x"), 
    BOOTSTRAP3((byte)10,"BootStrap 3.x"), BOOTSTRAP2((byte)11,"BootStrap 2.x"), 
    FOUNDATION6((byte)12,"Foundation 6"), FOUNDATION5((byte)13,"Foundation 5"), 
    FOUNDATION4((byte)14,"Foundation 4");
    
    private Byte key;
    private String value;
    
    private ScriptEnum(Byte key,String value){
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