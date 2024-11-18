package top.vertical.mapper;

import org.apache.ibatis.annotations.*;
import top.vertical.common.R;
import top.vertical.pojo.Internship;

import java.util.List;

@Mapper
public interface InternshipMapper {

    // 根据 ID 查询单个实习信息
    @Select("SELECT * FROM Internships WHERE id = #{id}")
    Internship getInternshipById(Long id);

    // 插入新的实习信息;
    @Insert("INSERT INTO Internships (company_name, company_type, industry, position, location, salary, description, requirements, contact_info, posted_by, " +
            "position_type, acquisitions, company_logo, application_deadline, picture, memo) " +
            "VALUES (#{companyName}, #{companyType}, #{industry}, #{position}, #{location}, #{salary}, #{description}, #{requirements}, #{contactInfo}, #{postedBy}, " +
            "#{positionType}, #{acquisitions}, #{companyLogo}, #{applicationDeadLine}, #{picture}, #{memo})")
    int insertInternship(Internship internship);

    //删除实习咨询BY ID
    @Delete("DELETE FROM Internships WHERE id = #{id}")
    int deleteInternship(Long id);


    @Select("SELECT * FROM Internships")
    List<Internship> getAllInternships();


    //修改实习咨询BY ID
    @Update("UPDATE Internships SET company_name = #{companyName}, " +
            "company_type = #{companyType}, industry = #{industry}, position = #{position}, location = #{location}, salary = #{salary}, " +
            "description = #{description}, requirements = #{requirements}, contact_info = #{contactInfo}, posted_by = #{postedBy}, " +
            "position_type = #{positionType}, acquisitions = #{acquisitions}, company_logo = #{companyLogo}, " +
            "application_deadline = #{applicationDeadLine}, picture = #{picture}, memo = #{memo} " +
            "WHERE id = #{id}")
    int updateInternship(Internship internship);


    @Select("SELECT * FROM Internships WHERE company_type = #{companyType}")
    List<Internship> getInternshipsByType(String companyType);

    @Select("SELECT * FROM Internships WHERE company_name LIKE CONCAT('%', #{keyword}, '%') OR description LIKE CONCAT('%', #{keyword}, '%')")
    List<Internship> searchInternships(String keyword);
}



