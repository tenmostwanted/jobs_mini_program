package top.vertical.mapper;

import org.apache.ibatis.annotations.*;
import top.vertical.pojo.Favorites;

import java.util.List;

@Mapper
public interface FavoritesMapper {
    @Insert("insert into Favorites (user_id, internship_id, created_at) values (#{userId}, #{internshipID}, #{createdAt})")
    int addFavorites(Favorites favorite);

    @Delete("DELETE FROM Favorites WHERE user_id = #{userId} AND internship_id = #{internshipId}")
    int deleteFavorites(@Param("userId") Long userId, @Param("internshipId") Long internshipId);

    @Select("SELECT * FROM Favorites WHERE user_id = #{userId} ")
    List<Favorites> findByUserId(@Param("userId") Long userId);
}


//    @Delete("DELETE FROM favorites WHERE user_id = #{userId} AND internship_id = #{internshipID}")
//    int deleteFavorite(@ParamSELECT * FROM Favorites WHERE user_id = #{userId} AND internship_id = #{internshipId}("userId") Long userId, @Param("internshipID") Long internshipID);
//
//    @Select("SELECT * FROM favorites WHERE user_id = #{userId} AND internship_id = #{internshipID}")
//    Favorites findByUserIdAndInternshipID(@Param("userId") Long userId, @Param("internshipID") Long internshipID);
//}