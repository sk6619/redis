package testList;

import redis.clients.jedis.Jedis;

/**
 * <p>文档描述：列表数据类型命令</p>
 *
 * @Author TestList
 * @Date 2021/4/8 0008 下午 9:06
 * @Version 1.0
 */
public class TestList {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");

        jedis.auth("95827");
        jedis.flushDB();
        //弹出元素 如果列表没有元素会阻塞或者=时间
        long l = System.currentTimeMillis();
        System.out.println(jedis.brpop(10, "name"));
        System.out.println(jedis.blpop(10, "name"));
        long l1 = System.currentTimeMillis();
        System.out.println("等待时间："+(l1-l));

        //向列表添加元素
        for (int i = 0; i < 20; i++) {
            jedis.lpush("list1", String.valueOf(i));
        }
        //获取列表的长度
        System.out.println(jedis.llen("list1"));
        //向左取出所有列表
        jedis.lrange("list1", 0, -1).forEach(System.out::println);
        //从右边弹出并且获取一个元素
        System.out.println(jedis.rpop("list1"));
        //移除一个元素
        System.out.println(jedis.lrem("list1", 1, "0"));
        jedis.close();
    }
}
