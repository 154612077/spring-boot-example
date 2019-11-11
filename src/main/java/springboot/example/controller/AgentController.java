package springboot.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.example.entity.AgentRateConfig;
import springboot.example.service.AgentRateService;
import springboot.example.system.SystemContext;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AgentController {


    @Resource
    private AgentRateService agentRateService;

    @GetMapping("/hello")
    public List<AgentRateConfig> getAgents(String code){
        AgentRateConfig agentRateConfig = new AgentRateConfig();
        agentRateConfig.setCode(code);
        return agentRateService.selectByExample(agentRateConfig);
    }
    @GetMapping("/helloPage")
    public List<AgentRateConfig> helloPage(String code){
        AgentRateConfig agentRateConfig = new AgentRateConfig();
        agentRateConfig.setCode(code);
        return agentRateService.selectByPage(agentRateConfig);
    }
    @GetMapping("/cs/t")
    public void test(){
        System.out.println("过滤器");
    }
}
