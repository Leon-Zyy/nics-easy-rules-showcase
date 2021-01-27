package nics.easy.rules.showcase.service.impl;

import com.jd.wms.nics.rules.api.AdvRules;
import com.jd.wms.nics.rules.api.RulesEngine;
import com.jd.wms.nics.rules.core.RulesEngineParameters;
import lombok.extern.slf4j.Slf4j;
import nics.easy.rules.showcase.data.Order;
import nics.easy.rules.showcase.rules.fact.EntryCheckFacts;
import nics.easy.rules.showcase.rules.group.EntryInvoiceGroupRules;
import nics.easy.rules.showcase.service.InvoiceCheckService;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Y.Y.Zhao
 * @version $Id: InvoiceCheckServiceImpl.java, v 0.1 3/29/2019 7:44 PM Y.Y.Zhao Exp $
 */
@Service
@Slf4j
public class InvoiceCheckServiceImpl implements InvoiceCheckService {

    @Resource
    private RulesEngine rulesEngine;

    @Lookup
    public RulesEngine getRulesEngine() {
        return this.rulesEngine;
    }

    @Resource
    private EntryInvoiceGroupRules entryInvoiceGroupRules;

    /**
     * 测试用例可以网上参考
     * http://solverpeng.com/2019/10/29/%E8%A7%84%E5%88%99%E5%BC%95%E6%93%8E-easy-rules/
     * @param order
     */
    @Override
    public void checkInvoice(Order order) {
        EntryCheckFacts facts = new EntryCheckFacts();
        facts.putInvoice(order.getInvoice());
        facts.putOrder(order);

        RulesEngineParameters rulesEngineParameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);

        AdvRules advRules = entryInvoiceGroupRules.getRules();
        try {
            rulesEngine.getParameters().skipOnFirstAppliedRule(true);
            rulesEngine.fire(advRules, facts);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("success");
    }
}
