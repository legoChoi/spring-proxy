package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.execute(); // 1초
        client.execute(); // 1초
        client.execute(); // 1초

        // 총 3초
    }


    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject); // 프록시가 중간 브로커 역할
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        client.execute(); // 실제 객체 호출 O
        client.execute(); // 실제 객체 호출 X
        client.execute(); // 실제 객체 호출 X
    }
}
