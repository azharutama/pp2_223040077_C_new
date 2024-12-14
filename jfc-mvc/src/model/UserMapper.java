package model;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM users")
    default List<User> getAllUsers() {
        return null;
    }

    @Insert("INSERT INTO users (name, email) VALUES (#{name}, #{email})")
  void insertUser(User user);




}