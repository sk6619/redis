package com.example.demo;

import com.example.demo.tools.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

//测试类，放在测试包下面，外面用失效

@SpringBootTest
public class SpringspptRedisApplicationTests {

    @Autowired
    @Qualifier(value = "redisTemplate")
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {

        //opsForValue()操作字符串
        //opsForList()操作list
        //opsForZSet()操作zset
        //opsForGeo()
        //....可以通过redisTemplate进行基本操作，比如事务， crud
        //      redisTemplate.multi();
        //       redisTemplate.exec();
        //      redisTemplate.watch();
        //       redisTemplate.unwatch();
        //获取redis连接对象RedisConnection connection = redisTemplate.getConnectionFactory()
        //                .getConnection();
        //              connection.flushAll();
        //              connection.flushDb();


        /*User user = new User("shaokui", 10);
        redisTemplate.opsForValue().set("user", user.toString());*/
        System.out.println(redisTemplate.opsForValue().get("test1"));
    }

    @Test
    void test() {

        Point point = new Point(121.444, 31.417);
        //获取北京坐标
        redisTemplate.opsForGeo().add("geo",point,"shanghai");
        List<Point> points = redisTemplate.opsForGeo().position("geo", "beijing");
        if(points != null) {
            points.forEach(i->{
                if(i != null) {
                    System.out.println(i.getX());
                    System.out.println(i.getY());
                }
            });
        }
        redisTemplate.opsForValue().set("name", "shaokui");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }

    @Test
    void test2() {

        redisUtil.set("name", "邵奎");
        System.out.println(redisUtil.get("name"));
        redisUtil.set("age", 20);
        System.out.println(redisUtil.get("age"));
        Set<String> keys = redisUtil.getKeys("*");
        if(keys != null) {
            keys.forEach(System.out::println);
        }
    }

    @Test
    void test3() {

        //一次添加一个
        Point point = new Point(116.46,39.92 );
        redisUtil.geoAdd("city",point ,"北京" );
        //添加多个
        HashMap<Object, Point> map = new HashMap<>();
        Point point1 = new Point(117.1,40.13 );
        Point point2 = new Point(116.85,40.37 );
        Point point3 = new Point(116.65,40.13 );
        map.put("pinggu", point);
        map.put("miyun", point2);
        map.put("shunyi", point3);
        redisUtil.geoAdds("city", map);

        List<Point> points = redisUtil.geoPos("city", "miyun", "pinggu", "shunyi");
        if(points != null) {
            points.forEach(i->{
                if(i != null) {
                    System.out.println(i.getX());
                    System.out.println(i.getY());
                }
            });
        }

    }
}

