package com.mio.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Copyright (c) 2018 MioGOGOGO Inc. All Rights Reserved.
 * Authors: mio
 * Date:2018/6/29 14:45.
 */
public class HelloClient {

    public static void main( String[] args ){

        TTransport transport = null;

        transport = new TSocket( "127.0.0.1",9091,30000 );

        TProtocol tProtocol = new TBinaryProtocol( transport );
        Hello.Client client = new Hello.Client( tProtocol );
        try {
            transport.open();
            String st = client.helloString( "mio" );
            System.out.println( st );

        }catch ( TTransportException e){

            e.printStackTrace();
        }catch ( TException te ){
            te.printStackTrace();
        }finally {

            if( null != transport ){
                transport.close();
            }

        }


    }


}
