package testString;

import redis.clients.jedis.Jedis;

/**
 * <p>文档描述：测试一些操作String类型的命令</p>
 *
 * @Author TestString
 * @Date 2021/4/8 0008 下午 7:39
 * @Version 1.0
 */
public class TestString {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");

        jedis.auth("95827");
        System.out.println(jedis.keys("*"));//查看所有key
        jedis.set("name", "shaokui");
        jedis.set("age","10");
        System.out.println(jedis.get("name"));
        //返回子字符串  key  start end
        System.out.println(jedis.getrange("name", 0, 2));
        //getset  将给定的key设为value  返回oldValue
        System.out.println(jedis.getSet("name", "zhangsan"));
        //获取多个key的value
        System.out.println(jedis.mget("name", "age"));
        //如果key不存在 则设值
        System.out.println(jedis.setnx("name", "zhaoliu"));
        jedis.strlen("name");//返回字符串长度
        //同时设多组键值对
        System.out.println(jedis.mset("tel", "152..", "lover", "gsy"));
        //当key不存在同时添加多组键值对
        System.out.println(jedis.msetnx("tel", "152", "age", "10"));
        //将value+1
        System.out.println(jedis.incr("age"));
        //将value+n
        System.out.println(jedis.incrBy("age", 50));
        //将value-1
        System.out.println(jedis.decr("age"));
        //将value-n
        System.out.println(jedis.decrBy("age", 10));
        //追加
        System.out.println(jedis.append("name", "xxxxxx"));

        jedis.close();


    }

}
