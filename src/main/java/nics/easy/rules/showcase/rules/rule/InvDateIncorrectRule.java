package nics.easy.rules.showcase.rules.rule;

import com.jd.wms.nics.easy.rules.spring.rule.AbstractRule;
import com.jd.wms.nics.rules.annotation.Action;
import com.jd.wms.nics.rules.annotation.Condition;
import com.jd.wms.nics.rules.annotation.Rule;
import lombok.extern.slf4j.Slf4j;
import nics.easy.rules.showcase.data.Order;
import nics.easy.rules.showcase.rules.fact.EntryCheckFacts;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 订单信息校验
 * @author Y.Y.Zhao
 * @version $Id: InvDateIncorrectRule.java, v 0.1 1/22/2019 8:53 PM Y.Y.Zhao Exp $
 */
@Rule(name="invDateIncorrectRule", description = "订单信息校验")
@Component
@Scope("prototype")
@Slf4j
public class InvDateIncorrectRule extends AbstractRule{

    private static final String KEY_ORDER_EMPTY_FIELD_NAME = "orderEmptyFieldName";

    @Condition
    public boolean condition(EntryCheckFacts facts) {
        Order order = facts.getOrder();
        if (StringUtils.isEmpty(order.getGoodsNo())) {
            order.setGoodsNo("123123123123123");
            facts.put(KEY_ORDER_EMPTY_FIELD_NAME, "goodsNo");
            return true;
        }
        if (StringUtils.isEmpty(order.getGoodsName())) {
            facts.put(KEY_ORDER_EMPTY_FIELD_NAME, "goodsName");
            return true;
        }
        return false;
    }

    @Action
    public void action(EntryCheckFacts facts) throws Exception{
        String fieldName = facts.get(KEY_ORDER_EMPTY_FIELD_NAME);
        log.error("字段'{}'值为空", fieldName);
//        throw new RuntimeException("1111");
        facts.putEnd(true);
    }
}
