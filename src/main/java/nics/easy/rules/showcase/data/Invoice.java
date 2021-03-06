package nics.easy.rules.showcase.data;

import lombok.Data;

/**
 * 发票实体类
 *
 * @author Y.Y.Zhao
 * @version $Id: Invoice.java, v 0.1 3/29/2019 7:20 PM Y.Y.Zhao Exp $
 */
@Data
public class Invoice {

    private String invNo;

    private String invSn;

    private String intoDate;

    private String outDate;
}
