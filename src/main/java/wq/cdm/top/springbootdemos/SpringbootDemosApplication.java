package wq.cdm.top.springbootdemos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("wq.cdm.top.springbootdemos.dao.mappers")
public class SpringbootDemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemosApplication.class, args);
    }

}
