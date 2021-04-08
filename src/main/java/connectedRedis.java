import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * <p>文档描述：</p>
 *
 * @Author connectedRedis
 * @Date 2021/4/7 0007 下午 11:30
 * @Version 1.0
 */
public class connectedRedis {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        jedis.auth("95827");
        System.out.println("服务在运行"+jedis.ping());
        //选择数据库，默认0-15
        jedis.select(1);
        System.out.println(jedis.set("name", "95827"));
        System.out.println(jedis.set("age", "10"));
        System.out.println(jedis.getDB());
        //模糊查找所有键，返回集合
        Set<String> keys = jedis.keys("*");
        keys.forEach(i->{
            //查看所有键
            System.out.println(i);
            //删除成功，返回1 or 0
            System.out.println(jedis.del(i));
        });
    }
}
