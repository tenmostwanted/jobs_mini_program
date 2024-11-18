package top.vertical.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Internship implements Serializable {

    private Long id;


    private String companyName;  // 公司名字
    private String industry; // 行业

    private String companyType; // 公司性质


    private String position; // 职位



    private BigDecimal salary;  // 薪水

    private String location;  // 地点
    private String description;  // 职责
    private String requirements;  // 岗位要求

    private String positionType; // 新增 实习类型 远程、线下
    private String acquisitions;  // 新增 实习收获
    private   String companyLogo;  // 新增 公司logo
    private LocalDateTime applicationDeadLine;  // 新增 投递截止日期
    private String picture;  // 新增 图片
    private String memo;  // 新增 备注

    private Integer postedBy;   // 发布者


    private String contactInfo; // 投递方式

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}