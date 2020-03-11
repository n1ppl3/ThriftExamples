package ru.n1ppl3.thrift.examples;

import com.henryxi.thrift.addserver.AdditionService;

public class AdditionServiceImpl implements AdditionService.Iface {

    public int add(int n1, int n2) {
        return n1 + n2;
    }
}
