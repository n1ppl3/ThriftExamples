package ru.n1ppl3.thrift.examples;

import com.henryxi.thrift.addserver.AdditionService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


public class MyThriftClient {

    public static void main(String[] args) throws TException {
        TTransport transport = new TSocket("localhost", 9090);
        try {
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            AdditionService.Client client = new AdditionService.Client(protocol);
            System.out.println("100 + 200 = " + client.add(100, 200));
        } finally {
            transport.close();
        }
    }
}
