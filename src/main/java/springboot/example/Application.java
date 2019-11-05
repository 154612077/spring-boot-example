package springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @GetMapping
    public String home(String name){
        System.out.println("姓名：" + name);
        return "hello" + name;
    }

    public static void main(String[] args) {
        System.out.println("begin------------");
        SpringApplication.run(Application.class,args);
    }
}
