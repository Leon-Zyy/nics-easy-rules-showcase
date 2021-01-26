package nics.easy.rules.showcase.rules.fact;

import com.jd.wms.nics.easy.rules.spring.facts.AdvFacts;
import nics.easy.rules.showcase.data.Invoice;
import nics.easy.rules.showcase.data.Order;

/**
 * @author Y.Y.Zhao
 * @version $Id: EntryCheckFacts.java, v 0.1 3/29/2019 7:16 PM Y.Y.Zhao Exp $
 */
public class EntryCheckFacts extends AdvFacts{

    private static final String KEY_INVOICE = "invoice";
    private static final String KEY_ORDER = "order";

    /**
     * 发票 fact put
     * @param invoice
     */
    public void putInvoice(Invoice invoice)
    {
        this.put(KEY_INVOICE, invoice);
    }
    /**
     * 发票 fact get
     */
    public Invoice getInvoice()
    {
        return this.get(KEY_INVOICE);
    }

    /**
     * 订单 fact put
     */
    public void putOrder(Order order) {
        this.put(KEY_ORDER, order);
    }
    /**
     * 订单 fact get
     */
    public Order getOrder(){
        return this.get(KEY_ORDER);
    }
}
