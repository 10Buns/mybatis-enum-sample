package com.summer.sample.handler;

import com.summer.sample.constant.IUserLevelEnum;
import com.summer.sample.util.EnumUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * All rights Reserved, Designed By mapletowngames.com
 *
 * @Version V1.0
 * @Title: UserLevelEnumTypeHandler
 * @Package com.summer.sample.handler
 * @Author: summer
 * @Date: 2019-02-24 21:57
 * @Description: 注意：
 */
public class UserLevelEnumTypeHandler<E extends Enum<?> & IUserLevelEnum> extends BaseTypeHandler<IUserLevelEnum> {

    private Class<E> enumType;

    public UserLevelEnumTypeHandler(Class<E> enumType){
        if (null == enumType){
            throw new IllegalArgumentException("用户等级枚举类型不能为空");
        }
        this.enumType = enumType;
    }

    /**
     * 把Java类型的参数转换为对应的数据库类型
     * @param preparedStatement
     * @param i
     * @param baseEnum
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, IUserLevelEnum baseEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, baseEnum.getLevel());
    }

    /**
     * 通过字段名称获取字段数据时，把数据库类型转换为对应的Java类型
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public IUserLevelEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int enumCode = resultSet.getInt(s);
        return resultSet.wasNull() ? null : valueConvert(enumCode);
    }

    /**
     * 通过字段索引获取字段数据时，把数据库类型转换为对应的Java类型
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public IUserLevelEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int enumCode = resultSet.getInt(i);
        return resultSet.wasNull() ? null : valueConvert(enumCode);
    }

    /**
     * 调用存储过程时，把数据库类型转换为对应的Java类型
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public IUserLevelEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int enumCode = callableStatement.getInt(i);
        return callableStatement.wasNull() ? null : valueConvert(enumCode);
    }

    private E valueConvert(int enumValue){
        try {
            return EnumUtil.convertEnumValue(enumType, enumValue);
        } catch (Exception ex) {
            throw new IllegalArgumentException("无法将枚举值" + enumValue + " 转换成 " + enumType.getSimpleName() + ",异常信息:", ex);
        }
    }
}
