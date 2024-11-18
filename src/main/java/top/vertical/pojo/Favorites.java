package top.vertical.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Favorites implements Serializable {

        private static final long serialVersionUID = 1L;

        private Long id;

        private Long userId;
        private Long internshipID;


        private LocalDateTime createdAt;






    }


