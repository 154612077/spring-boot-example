package springboot.example.service;

import springboot.example.entity.AgentRateConfig;

import java.util.List;

public interface AgentRateService {

    List<AgentRateConfig> selectByExample(AgentRateConfig agentRateConfig);

    List<AgentRateConfig> selectByPage(AgentRateConfig agentRateConfig);
}
