package mapper;

import java.util.List;
import model.JenisMember;
import model.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MemberMapper {

    @Insert("INSERT INTO member (id, nama, jenis_member_id) VALUES (#{id}, #{nama}, #{jenisMemberId})")
    int insert(Member member);

    @Update("UPDATE member SET nama = #{nama}, jenis_member_id = #{jenisMemberId} WHERE id = #{id}")
    int update(Member member);

    @Delete("DELETE FROM member WHERE id = #{id}")
    int delete(int id);

    @Select("SELECT * FROM member")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "nama", column = "nama"),
        @Result(property = "jenisMemberId", column = "jenis_member_id"),
        @Result(
            property = "jenisMember",
            column = "jenis_member_id",
            javaType = JenisMember.class,
            one = @One(select = "mapper.JenisMemberMapper.getJenisMember")
        )
    })
    List<Member> findAll();

    @Select("SELECT * FROM jenis_member WHERE id = #{id}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "nama", column = "nama")
    })
    JenisMember getJenisMember(int id);
}
