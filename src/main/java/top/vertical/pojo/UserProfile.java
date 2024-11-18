package top.vertical.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String nickname;

    private String gender;

    private String region;

    private String avatar;
}
