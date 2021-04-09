package testGeospatial;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>文档描述：特殊类型地图空间</p>
 *
 * @Author TestGerspatial
 * @Date 2021/4/8 0008 下午 9:26
 * @Version 1.0
 */
public class TestGerspatial {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");

        jedis.auth("95827");

//        jedis.flushDB();
//
//        Map<String, GeoCoordinate> map = new HashMap<>();
//        map.put("beijing",new GeoCoordinate(121.445, 31.417));
//        System.out.println(jedis.geoadd("geo", map));
        System.out.println(jedis.get("test"));
        System.out.println(jedis.get("user"));
        System.out.println(jedis.geopos("geo", "beijing"));
    }
}
