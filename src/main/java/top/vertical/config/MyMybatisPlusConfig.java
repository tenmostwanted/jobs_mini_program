package top.vertical.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("top.vertical.mapper")
public class MyMybatisPlusConfig {
}
