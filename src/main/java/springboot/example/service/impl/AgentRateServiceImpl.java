package springboot.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import springboot.example.entity.AgentRateConfig;
import springboot.example.mapper.AgentRateConfigMapper;
import springboot.example.service.AgentRateService;
import springboot.example.system.SystemContext;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


@Service
public class AgentRateServiceImpl implements AgentRateService {

    @Resource
    AgentRateConfigMapper agentRateConfigMapper;
    @Override
    public List<AgentRateConfig> selectByExample(AgentRateConfig agentRateConfig) {
        Example example = new Example(AgentRateConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("code",agentRateConfig.getCode());
        return agentRateConfigMapper.selectByExample(example);
    }

    @Override
    public List<AgentRateConfig> selectByPage(AgentRateConfig agentRateConfig) {
        PageHelper.startPage(SystemContext.getFirstResult(),SystemContext.getPageSize());
        Example example = new Example(AgentRateConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("code",agentRateConfig.getCode());
        List<AgentRateConfig> list = agentRateConfigMapper.selectByExample(example);
        PageInfo page = new PageInfo(list);
        System.out.println(page);
        return list;
    }

    @Override
    public void update() {
        AgentRateConfig agentRateConfig = new AgentRateConfig();
        agentRateConfig.setId(576l);
        agentRateConfig.setCode("xxxxxxx");
        agentRateConfig.setValue(new BigDecimal(1));
        agentRateConfig.setMonth("2");
        agentRateConfig.setYear("33");
        agentRateConfigMapper.updateByPrimaryKeySelective(agentRateConfig);
    }
}
