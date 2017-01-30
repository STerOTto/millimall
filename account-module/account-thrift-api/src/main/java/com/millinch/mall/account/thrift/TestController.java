package com.millinch.mall.account.thrift;

import org.apache.thrift.TException;
import ru.trylogic.spring.boot.thrift.annotation.ThriftController;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@ThriftController("/test")
public class TestController implements CalculatorService.Iface {

    public int add(int num1, int num2) throws TException {
        return num1 + num2;
    }

    public int minus(int num1, int num2) throws TException {
        return num1 - num2;
    }

    public int multi(int num1, int num2) throws TException {
        return num1 * num2;
    }

    public int divi(int num1, int num2) throws TException {
        return num1 /num2;
    }
}
