package top.realdoer.constant;

/**
 *  项目类型枚举
 *  关联: mapper/ItemMapper.item, 修改时一并修改
 */
public enum ItemType implements BaseMyBatisConvertEnum<ItemType, String> {
    TEMPLATE_HTML((byte)0,"template_html"), TEMPLATE_WORDPRESS((byte)1,"template_wordpress"), 
    TEMPLATE_MARKETING((byte)2,"template_marketing"), TEMPLATE_CMS((byte)3,"template_cms"),
    TEMPLATE_UI((byte)4,"template_ui"), TEMPLATE_PLUGIN((byte)5,"template_plugin"),
    TEMPLATE_ECOMMERCE((byte)6,"template_ecommerce"),
    
    CODE_PHP((byte)7,"code_php"), CODE_WORDPRESS((byte)8,"code_wordpress"), CODE_ECOMMERCE((byte)9,"code_ecommerce"),
    CODE_JAVASCRIPT((byte)10,"code_javascript"), CODE_CSS((byte)11,"code_css"), CODE_HTML((byte)12,"code_html"),
    CODE_SKIN((byte)13,"code_skin"), CODE_PLUGIN((byte)14,"code_plugin"),
    
    VIDEO_AFTER_EFFECTS((byte)15,"video_after_effects"), VIDEO_PRIMIERE((byte)16,"video_primiere"),
    VIDEO_APPLE_MOTION((byte)17,"video_apple_motion"), VIDEO_MOTION_GRAPHICS((byte)18,"video_motion_graphics"),
    VIDEO_CINIMA_4D((byte)19,"video_cinima_4d"), VIDEO_ADD_ON((byte)20,"video_add_on"),
    
    AUDIO_MUSIC((byte)21,"audio_music"), AUDIO_MUSIC_PACK((byte)22,"audio_music_pack"),
    AUDIO_MUSIC_KIT((byte)23,"audio_muisc_kit"), AUDIO_LOGO((byte)24,"audio_logo"),
    AUDIO_SOUND_EFFECT((byte)25,"audio_sound_effect"), AUDIO_SOURCE_FILE((byte)26,"audio_source_file"),
    
    GRAPHICS_GRAPHICS((byte)27,"graphics_graophics"), GRAPHICS_PRINT((byte)28,"graphics_print"),
    GRAPHICS_WEB_ELEMENT((byte)29,"graphics_web_element"), GRAPHICS_ADD_ON((byte)30,"graphics_add_on"),
    GRAPHICS_ICON((byte)31,"graphics_icon"), GRAPHICS_FONT((byte)32,"graphics_font"), 
    GRAPHICS_LOGO((byte)33,"graphics_logo"), GRAPHICS_PHOTO((byte)34,"graphics_photo"),
    
    THIREED_MODLE((byte)35,"3d_modle"), THREED_HDRI_IMAGE((byte)36,"3d_hdri_image"),
    THREED_CG_TEXTURE((byte)37,"3d_cg_texture"), THREED_MATERIAL((byte)38,"3d_material"),
    THREED_MESH((byte)39,"3d_mesh"), THREED_SCRIPT((byte)40,"3d_script");
    
    private Byte key;
    private String value;
    
    private ItemType(Byte key,String value){
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
}
