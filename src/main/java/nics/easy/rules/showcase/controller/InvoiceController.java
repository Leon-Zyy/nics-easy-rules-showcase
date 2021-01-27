package nics.easy.rules.showcase.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import nics.easy.rules.showcase.data.Order;
import nics.easy.rules.showcase.service.InvoiceCheckService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Y.Y.Zhao
 * @version $Id: InvoiceCheckController.java, v 0.1 3/29/2019 7:39 PM Y.Y.Zhao Exp $
 */
@RestController
@RequestMapping("/invoice/check")
@Api(value = "发票管理", consumes = "application/json,application/xml")
public class InvoiceController {

    @Resource
    private InvoiceCheckService invoiceCheckService;

    @PostMapping
    @ApiOperation(value = "校验发票", notes = "案例而已")
    public void checkInvoice(@ApiParam(value="发票信息") @RequestBody Order order)
    {
        this.invoiceCheckService.checkInvoice(order);
    }

}
