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
        List<AgentRateConfig> list = agentRateService.selectByPage(agentRateConfig);
        System.out.println(123);
        System.out.println(list.toString());
        return agentRateService.selectByExample(agentRateConfig);
    }
    @GetMapping("/cs/t")
    public List<AgentRateConfig> test(String code){
        AgentRateConfig agentRateConfig = new AgentRateConfig();
        agentRateConfig.setCode(code);
        List<AgentRateConfig> list = agentRateService.selectByPage(agentRateConfig);
        System.out.println(123);
        System.out.println(list.toString());
        return agentRateService.selectByExample(agentRateConfig);
    }
}
