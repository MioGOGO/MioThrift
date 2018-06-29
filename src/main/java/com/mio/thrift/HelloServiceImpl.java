package com.mio.thrift;

import org.apache.thrift.TException;

/**
 * Copyright (c) 2018 MioGOGOGO Inc. All Rights Reserved.
 * Authors: mio
 * Date:2018/6/29 14:29.
 */
public class HelloServiceImpl  implements Hello.Iface {

    public String helloString( String para ) throws TException{
        return "aa : "+para;
    }
}
