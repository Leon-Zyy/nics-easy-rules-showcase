package nics.easy.rules.showcase.service.impl;

import com.jd.wms.nics.rules.api.AdvRules;
import com.jd.wms.nics.rules.api.RulesEngine;
import lombok.extern.slf4j.Slf4j;
import nics.easy.rules.showcase.data.Invoice;
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

    @Override
    public void checkInvoice(Invoice invoice) {
        EntryCheckFacts facts = new EntryCheckFacts();
        facts.putInvoice(invoice);
        //facts.putOrder(order);

        AdvRules advRules = entryInvoiceGroupRules.getRules();
        this.getRulesEngine().fire(advRules, facts);
    }
}
