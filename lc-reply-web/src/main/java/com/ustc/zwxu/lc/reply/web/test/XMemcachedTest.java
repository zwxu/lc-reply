package com.ustc.zwxu.lc.reply.web.test;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class XMemcachedTest {
	public static void main(String[] args) throws IOException {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));
        MemcachedClient memcachedClient = builder.build();
        
        try {
            memcachedClient.set("key", 0, "Hello World!");
            String value = memcachedClient.get("key");
            System.out.println("key值：" + value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            memcachedClient.shutdown();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
