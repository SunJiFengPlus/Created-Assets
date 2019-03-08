package top.realdoer.constant;

/**
 *  项目中包含的文件类型 
 */
public enum FileTypeEnum implements BaseMyBatisConvertEnum<BrowerEnum, String> {
    
    LAYERED_PNG((byte)0,"Layered PNG"), PNG((byte)1,"PNG"), LAYERED_PSD((byte)2,"Layered PSD"), 
    PSD((byte)3,"PSD"), PHP((byte)4,"PHP Files"), CSS((byte)5,"CSS Files"), HBS((byte)6,"HBS Files"), 
    HTML((byte)7,"HTML Files"), JS((byte)8,"JS File"), JSP((byte)9,"JSP File"), 
    AE_PROJECT((byte)10,"After Effects Project Files"), MG_TEMPLATE((byte)11,"Motion Graphics Template Files"),
    SCRIPT((byte)12,"Script Files"), VIDEO((byte)13,"Video Files"), IMAGE((byte)14,"IMAGE File"), 
    VECTOR((byte)15,"Vector Files"), DESIGN((byte)16,"Design Files"), 
    SOUND_EFFECT((byte)17,"Sound Effect Files"), MUSIC((byte)18,"MUSIC Files");
    
    private Byte key;
    private String value;
    
    private FileTypeEnum(Byte key, String value){
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
    
    @Override
    /**
     * fastJson 序列化配置枚举类型使用 toString() 方法进行序列化
     */
    public String toString() {
        return this.value;
    }
}
