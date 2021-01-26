package nics.easy.rules.showcase.configurer;


import com.jd.wms.nics.easy.rules.spring.support.GroupRulesRegister;
import com.jd.wms.nics.easy.rules.spring.support.ProtoRulesEngineFactoryBean;
import com.jd.wms.nics.easy.rules.spring.support.RulesDefinitionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * easy-rules配置
 * @author Y.Y.Zhao
 * @version $Id: EasyRulesConfigurer.java, v 0.1 1/3/2019 3:19 PM Y.Y.Zhao Exp $
 */
@Configuration
public class EasyRulesConfigurer {

    @Bean
    ProtoRulesEngineFactoryBean rulesEngineFactoryBean()
    {
        return new ProtoRulesEngineFactoryBean();
    }

    @Bean
    @ConfigurationProperties(prefix = "nics.easyrules")
    RulesDefinitionFactory rulesDefinitionFactory()
    {
        return new RulesDefinitionFactory();
    }

    @Bean
    GroupRulesRegister groupRulesRegister()
    {
        return new GroupRulesRegister();
    }
}
