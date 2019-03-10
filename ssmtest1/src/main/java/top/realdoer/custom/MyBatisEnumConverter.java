package top.realdoer.custom;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import io.jsonwebtoken.lang.Assert;
import top.realdoer.constant.BaseMyBatisConvertEnum;
import top.realdoer.exception.DaoException;

/**
 * MyBatis 枚举类型转换器
 * @param <E> 处理的枚举类型
 */
public class MyBatisEnumConverter<E extends BaseMyBatisConvertEnum<?, ?>> extends BaseTypeHandler<E> {

    private Class<E> type;
    private E[] enums;

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     * @param type 配置文件中设置的转换类
     */
    public MyBatisEnumConverter(Class<E> type) {
        Assert.notNull(type);
        this.type = type;
        this.enums = type.getEnumConstants();
        Assert.noNullElements(enums, type.getSimpleName() + " 不是一个枚举类型");
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getKey());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Integer key = rs.getInt(columnName);
        return getValue(key);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer key = rs.getInt(columnIndex);
        return getValue(key);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer key = cs.getInt(columnIndex);
        return getValue(key);
    }

    /**
     * 枚举类型转换，由于构造函数获取了枚举的子类enums，让遍历更加高效快捷
     * @param key 数据库中存储的键
     * @return value对应的枚举类
     */
    private E getValue(Integer key) throws DaoException {
        Byte byteKey;
        try {
            byteKey = new Byte(key.toString());
        } catch (Exception e) {
            throw new DaoException("不能进行的类型转换: 将 " + key + " 转换为 " + Byte.class.getName());
        }
        
        for (E e : enums) {
            if (e.getKey().equals(byteKey)) {
                return e;
            }
        }
        throw new DaoException("未知的枚举类型：" + key + ",请核对" + type.getSimpleName());
    }
}
