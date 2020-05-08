package com.example.demo.dao;

import com.example.demo.base.MyMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Repository
public interface UserMapper extends MyMapper<User> {


    User getUserRandomByUserId(@Param("userId") String userId);

    @Select({"SELECT * FROM user WHERE user_id = #{userId}"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nick_name", property = "nickName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP)
    })
    User selectByUserId(String userId);


    @SelectProvider(type = getUserListSql.class, method = "getUserListMethod")
    List<User> getUserList(@Param("param1") String param1, @Param("param2") String param2);


    class getUserListSql {
        public String getUserListMethod(@Param("param1") String param1, @Param("param2") String param2) {
            SQL sql = new SQL();
            sql.SELECT("id");
            sql.SELECT("user_id");
            sql.SELECT("user_name");
            sql.SELECT("nick_name");
            sql.SELECT("phone");
            sql.SELECT("email");
            sql.SELECT("create_time");
            sql.FROM("user");
            sql.WHERE("is_valid = 1");
            if (StringUtil.isNotEmpty(param1)) {
                sql.WHERE("user_id = #{param1}");
            }
            if (StringUtil.isNotEmpty(param2)) {
                sql.WHERE("user_name = #{param1,jdbcType=VARCHAR}");
            }

            return sql.toString();
        }
    }
}