import redis.clients.jedis.Jedis;

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
    }
}
