package com.mio.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Copyright (c) 2018 MioGOGOGO Inc. All Rights Reserved.
 * Authors: mio
 * Date:2018/6/29 14:36.
 */
public class HelloServiceServer {



    public static void main( String[] args ){

        try {
            TProcessor tProcessor = new Hello.Processor<Hello.Iface>( new HelloServiceImpl() );
            TServerSocket serverTransport = new TServerSocket( 9091 );
            TServer.Args tArgs = new TServer.Args( serverTransport );
            tArgs.processor( tProcessor );
            tArgs.protocolFactory ( new TBinaryProtocol.Factory() );
            TServer server = new TSimpleServer( tArgs );
            server.serve();

        }catch ( TTransportException e){
            e.printStackTrace();

        }
    }

}
