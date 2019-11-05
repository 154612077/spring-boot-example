package springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("springboot.example.mapper") //扫描的mapper
public class Application {

    public static void main(String[] args) {
        System.out.println("begin------------");
        SpringApplication.run(Application.class,args);
    }
}
