package springboot.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import springboot.example.entity.AgentRateConfig;
import springboot.example.mapper.AgentRateConfigMapper;
import springboot.example.service.AgentRateService;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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
        PageHelper.startPage(0,10);
        Example example = new Example(AgentRateConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("code",agentRateConfig.getCode());
        List<AgentRateConfig> list = agentRateConfigMapper.selectByExample(example);
        PageInfo page = new PageInfo(list);
        System.out.println(page);
        return list;
    }
}
