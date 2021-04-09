package com.example.demo.tools;

import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>文档描述：redis工具类，封装redisTemplate</p>
 *
 * @Author RedisUtil
 * @Date 2021/4/9 0009 下午 6:09
 * @Version 1.0
 */

@Component
public class RedisUtil {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 判断key是否存在  命令exists
     *
     * @param key
     * @return true false
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 操作字符串
     *
     * @param key
     * @param value
     * @return true false
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取value
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 通配符搜索key
     *
     * @param pattern
     * @return
     */
    public Set<String> getKeys(String pattern) {
        try {
            return redisTemplate.keys(pattern);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 清空当前数据库缓存
     *
     * @return true false
     */
    public boolean flushDB() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        try {
            connection.flushDb();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            connection.close();
        }
    }

    /**
     * 清空所有缓存
     *
     * @return
     */
    public boolean flushAll() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        try {
            connection.flushAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            connection.close();
        }
    }

    /**
     * 添加地理空间
     * @param key
     * @param point
     * @param member
     * @return true false
     */
    public boolean geoAdd(String key, Point point, String member) {
        try {
            redisTemplate.opsForGeo().add(key, point, member);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加多个
     * @param key
     * @param map
     * @return
     */
    public boolean geoAdds(String key, Map<Object,Point> map) {
        try {
            redisTemplate.opsForGeo().add(key, map);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 返回地理空间
     * @param key
     * @param members
     * @return list
     */
    public List<Point> geoPos(String key,Object...members) {
        try {
            return redisTemplate.opsForGeo().position(key, members);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
