package ru.n1ppl3.thrift.examples;

import com.henryxi.thrift.addserver.AdditionService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;


public class MyThriftServer {

    public static void main(String[] args) throws TTransportException {
        AdditionService.Processor<AdditionServiceImpl> processor = new AdditionService.Processor<>(new AdditionServiceImpl());

        TServerTransport serverTransport = new TServerSocket(9090);
        try {
            TServer.Args serverArgs = new TServer.Args(serverTransport)
                .processor(processor);
            TServer server = new TSimpleServer(serverArgs);
            System.out.println("Starting the simple server...");
            server.serve();
        } finally {
            serverTransport.close();
        }
    }
}
