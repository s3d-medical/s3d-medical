package com.s3d.tech.cache;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * Reids client used to access redis.
 *
 * @author wind.chen
 */
public class RedisClient {

    // ---------------------------set value ---------------------------------
    public void setInteger(String key, Integer value) {
        this.setInteger(key, value, 0);
    }

    public void setInteger(String key, Integer value, int seconds) {
        this.setString(key, (value == null ? null : value.toString()), seconds);
    }

    public void setLong(String key, Long value) {
        this.setLong(key, value, 0);
    }

    public void setLong(String key, Long value, int seconds) {
        this.setString(key, (value == null ? null : value.toString()), seconds);
    }

    public void setString(String key, String value) {
        this.setString(key, value, 0);
    }

    public void setString(String key, String value, int seconds) {
        if (!this.check(key)) {
            return;
        }
        if (value == null) {
            return;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            shardedJedis.set(key, value);
            if (seconds > 0) {
                shardedJedis.expire(key, seconds);
            }
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e.getCause());
        }
    }

    public Long getLong(String key) {
        String value = this.getString(key);
        return (value == null ? null : Long.parseLong(value));
    }

    public Integer getInteger(String key) {
        String value = this.getString(key);
        return (value == null ? null : Integer.parseInt(value));
    }

    public String getString(String key) {
        String re = null;
        if (!this.check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.get(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * Set object.
     *
     * @param key
     * @param value
     */
    public void setObject(String key, Object value) {
        this.setObject(key, value, 0);
    }

    /**
     * set object by key.
     *
     * @param key
     * @param value
     * @param seconds survive.
     */
    public void setObject(String key, Object value, int seconds) {
        if (!this.check(key) || value == null) {
            return;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            shardedJedis.set(key.getBytes(), SerializeUtil.serialize(value));
            if (seconds > 0) {
                shardedJedis.expire(key, seconds);
            }
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
    }

    /**
     * Get object by key.
     *
     * @param key
     * @return
     */
    public <T> T getObject(String key) {
        T expectResult = null;
        if (!this.check(key)) {
            return expectResult;
        }
        ShardedJedis shardedJedis = null;
        try {
            byte[] re = null;
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.get(key.getBytes());
            this.returnResource(shardedJedis);
            Object obj = SerializeUtil.unserialize(re);
            return (T) obj;
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return expectResult;
    }

    /**
     * 删除记录，根据Key
     *
     * @param key
     * @return 1成功 0失败
     */
    public long delete(String key) {
        long re = 0;
        if (!this.check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.del(key.getBytes());
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 检查key是否存在
     *
     * @param key
     * @return
     */
    public boolean exists(String key) {
        boolean re = false;
        if (!this.check(key)) {
            return re;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.exists(key.getBytes());
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 对key设置指定过期时间
     *
     * @param key
     * @param unixTime
     * @return 1成功 0 找不到key或者对应的key的过期时间被更新
     */
    public long expireAt(String key, long unixTime) {
        long re = 0;
        if (!this.check(key)) {
            return re;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.expireAt(key, unixTime);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 获取key的ttl
     *
     * @param key
     * @return 存活时间以秒为单位，-1为已经到期
     */
    public long ttl(String key) {
        long re = -1;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.ttl(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * increase value of given key, and ensure the max value of this key is limit.
     * if limit is null,  no limit for this value.
     *
     * @param key
     * @param upperLimit
     * @return
     */
    public boolean limitIncr(String key, Long upperLimit) {
        Long latestValue = this.getLong(key);
        if (upperLimit != null && latestValue != null && latestValue >= upperLimit) {
            return false;
        }

        latestValue = this.incr(key);
        if (upperLimit != null && latestValue > upperLimit) {
            this.incr(key, -1);
            return false;
        }
        return true;
    }

    /**
     * @param key
     * @return latest value after increased.
     * @author wind.chen
     * @since 2015-09-21
     */
    public Long incr(String key) {
        return this.incr(key, 1L);
    }

    public Integer incr(String key, Integer step) {
        Long lStep = (step == null ? 0L : new Long(step.longValue()));
        Long re = this.incr(key, lStep);
        return (re == null ? null : re.intValue());
    }

    public Long incr(String key, Long step) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        long re = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.incrBy(key, (step == null ? 0L : step));
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    public Double incr(String key, Double step) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        Double re = 0.0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.incrByFloat(key, (step == null ? 0.0 : step));
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    public Long decr(String key) {
        return this.decr(key, 1L);
    }

    public Long decr(String key, Long step) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        long re = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.decrBy(key, (step == null ? 0L : step));
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

	/*------------------------List value 操作--------------------------------------*/

    /**
     * 向List末尾追加值
     *
     * @param key
     * @param value
     * @author binglin.hu
     * @date 2014-1-16 下午2:35:58
     */
    public void lpush(String key, String... value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            for (int i = 0; i < value.length; i++) {
                String string = value[i];
                shardedJedis.lpush(key, string);
            }
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
    }

    /**
     * 向List起始处插入值
     *
     * @param key
     * @param value
     */
    public void rpush(String key, String... value) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            for (int i = 0; i < value.length; i++) {
                String string = value[i];
                shardedJedis.rpush(key, string);
            }
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
    }

    /**
     * 从列表末尾处弹出值
     *
     * @param key
     * @return
     */
    public String rpop(String key) {
        String re = null;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.rpop(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 覆盖List中指定位置的值
     *
     * @param key
     * @param index
     * @param value
     * @return
     */
    public String lset(String key, int index, String value) {
        String re = null;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.lset(key, index, value);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 获取List中指定位置的值
     *
     * @param key
     * @param index
     * @return
     */
    public String lindex(String key, int index) {
        String re = null;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.lindex(key, index);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * List长度
     *
     * @param key
     * @return
     */
    public long llen(String key) {
        long re = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.llen(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 保留start与end 之间的记录
     *
     * @param key
     * @param start
     * @param end
     * @return 状态码
     */
    public String ltrim(String key, int start, int end) {
        String re = null;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.ltrim(key, start, end);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 返回列表 key 中指定区间内的元素
     *
     * @param key   key
     * @param start 开始下标
     * @param end   结束下标
     * @return 一个列表，包含指定区间内的元素
     */
    public List<String> lrange(String key, long start, long end) {
        List<String> list = null;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            list = shardedJedis.lrange(key, start, end);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return list;
    }

	/*------------------------Hash value 操作--------------------------------------*/

    /**
     * set hash map with (string mapkey, Object value)
     *
     * @param key
     * @param map
     */
    public void hmsetObject(String key, Map<String, Object> map) {
        if (StringUtils.isEmpty(key) || MapUtils.isEmpty(map)) {
            return;
        }
        Map<byte[], byte[]> convertedMap = convertToByteMap(map);
        hmsetObject(key.getBytes(), convertedMap);
    }

    private Map<byte[], byte[]> convertToByteMap(Map<String, Object> map) {
        Map<byte[], byte[]> convertedMap = new HashMap<byte[], byte[]>();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Object obj = map.get(key);
            convertedMap.put(key.getBytes(), SerializeUtil.serialize(obj));
        }
        return convertedMap;
    }

    public void hmsetObject(String key, List<String> fields, List<Object> values) {
        Map<byte[], byte[]> convertedMap = convertToByteMap(fields, values);
        hmsetObject(key.getBytes(), convertedMap);
    }

    private Map<byte[], byte[]> convertToByteMap(List<String> fields, List<Object> values) {
        Map<byte[], byte[]> convertedMap = new HashMap<byte[], byte[]>();
        if (CollectionUtils.isEmpty(fields)
                || CollectionUtils.isEmpty(values) ||
                fields.size() != values.size()) {
            return convertedMap;
        }
        for (int i = 0; i < fields.size(); i++) {
            String field = fields.get(i);
            Object obj = values.get(i);
            convertedMap.put(field.getBytes(), SerializeUtil.serialize(obj));
        }
        return convertedMap;
    }

    /**
     * 添加一条记录，值为 Map
     *
     * @param key
     * @param map
     */
    public void hmsetString(String key, Map<String, String> map) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            shardedJedis.hmset(key, map);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
    }

    /**
     * 添加一条记录，值为 Map
     *
     * @param key
     * @param map
     */
    public void hmsetObject(byte[] key, Map<byte[], byte[]> map) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            shardedJedis.hmset(key, map);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
    }

    /**
     * set integer value in map.
     *
     * @param key   key for this map
     * @param field key in map
     * @param value value in map
     * @return
     */
    public long hsetInteger(String key, String field, Integer value) {
        long re = 0;
        re = hsetString(key, field, (value == null ? null : "" + value));
        return re;
    }

    /**
     * key对应记录的map中添加记录
     *
     * @param key
     * @param field
     * @param value
     * @return 1成功 0失败
     */
    public long hsetString(String key, String field, String value) {
        long re = 0;
        if (!hCheck(key, field)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hset(key, field, value);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    public long hsetObject(String key, String field, Object value) {
        byte[] bkey = (key == null ? null : key.getBytes());
        byte[] bfield = (field == null ? null : field.getBytes());
        byte[] bvalue = (value == null ? null : SerializeUtil.serialize(value));
        return hsetObject(bkey, bfield, bvalue);
    }

    /**
     * key对应记录的map中添加记录
     *
     * @param key
     * @param field
     * @param value
     * @return 1成功 0失败
     */
    public long hsetObject(byte[] key, byte[] field, byte[] value) {
        long re = 0;
        if (!hCheck(key, field)) {
            return 0;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hset(key, field, value);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 判断该key对应的map中是否有field
     *
     * @param key
     * @param field
     * @return
     */
    public boolean hexists(String key, String field) {
        boolean re = false;
        if (!hCheck(key, field)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hexists(key, field);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 判断该key对应的map中是否有field
     *
     * @param key
     * @param field
     * @return
     */
    public boolean hexists(byte[] key, byte[] field) {
        boolean re = false;
        if (!hCheck(key, field)) {
            return re;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hexists(key, field);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * get value from map by field(map key), and this map is cached in redis by key.
     *
     * @param key   key used to cache this map.
     * @param field used to get value from this map.
     * @return
     */
    public Integer hgetInteger(String key, String field) {
        String value = hgetString(key, field);
        return (StringUtils.isEmpty(value) ? null : Integer.parseInt(value));
    }

    /**
     * 获取key 对应的map中field的值
     *
     * @param key
     * @param field
     * @return
     */
    public String hgetString(String key, String field) {
        String re = null;
        if (!hCheck(key, field)) {
            return re;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hget(key, field);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * Get value from map in cache.
     *
     * @param key   cache key for map
     * @param field key in map.
     * @return
     */
    public <T> T hGetObject(String key, String field) {
        byte[] bKey = (key == null ? null : key.getBytes());
        byte[] bField = (field == null ? null : field.getBytes());
        T result = (T) SerializeUtil.unserialize(hgetObject(bKey, bField));
        return result;
    }

    /**
     * 获取key 对应的map中field的值
     *
     * @param key
     * @param field
     * @return
     */
    public byte[] hgetObject(byte[] key, byte[] field) {
        byte[] re = null;
        if (!hCheck(key, field)) {
            return re;
        }

        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hget(key, field);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 删除key对应的map
     *
     * @param key
     * @return 1成功 0失败
     */
    public long hdel(String key) {
        long re = 0;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hdel(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 删除key对应的map
     *
     * @param key
     * @return 1成功 0失败
     */
    public long hdel(byte[] key) {
        long re = 0;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hdel(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 删除key对应map中指定field的记录
     *
     * @param key
     * @param field
     * @return 1成功 0失败
     */
    public long hdel(String key, String field) {
        long re = 0;
        if (!hCheck(key, field)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hdel(key, field);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 删除key对应map中指定field的记录
     *
     * @param key
     * @param field
     * @return
     */
    public long hdel(byte[] key, byte[] field) {
        long re = 0;
        if (!hCheck(key, field)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hdel(key, field);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 获取key对应map中记录总数
     *
     * @param key
     * @return 1成功 0失败
     */
    public long hlen(String key) {
        long re = 0;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hlen(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 获取key对应map中记录总数
     *
     * @param key
     * @return 1成功 0失败
     */
    public long hlen(byte[] key) {
        long re = 0;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hlen(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 获取key对应的map中所有的field 的集合
     *
     * @param key
     * @return
     */
    public Set<String> hkeys(String key) {
        Set<String> re = null;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hkeys(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 获取key对应的map中所有的field 的集合
     *
     * @param key
     * @return
     */
    public Set<byte[]> hkeys(byte[] key) {
        Set<byte[]> re = null;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hkeys(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 获取key对应的map中所有的value的集合
     *
     * @param key
     * @return
     */
    public List<String> hvals(String key) {
        List<String> re = null;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hvals(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 获取key对应的map中所有的value的集合
     *
     * @param key
     * @return
     */
    public Collection<byte[]> hvals(byte[] key) {
        Collection<byte[]> re = null;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hvals(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }


    /**
     * 返回指定hsah key中field和value的集合
     *
     * @param key
     * @return
     */
    public Map<byte[], byte[]> hGetAllObject(byte[] key) {
        Map<byte[], byte[]> re = null;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hgetAll(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    public Map<String, String> hGetAllString(String key) {
        Map<String, String> re = null;
        if (!check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hgetAll(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 对指定key对应的hash中指定field的value作增量操作
     *
     * @param key
     * @param field
     * @param value 可以为负数
     * @return 增量操作后value的值
     */
    public long hincrBy(String key, String field, long value) {
        long re = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hincrBy(key, field, value);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 将哈希表 key 中的域 field 的值设置为 value ，当且仅当域 field 不存在
     *
     * @param key
     * @param field
     * @param value
     * @return 设置成功，返回 1 。如果给定域已经存在且没有操作被执行，返回 0 。
     */
    public long hsetnx(String key, String field, String value) {
        long re = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.hsetnx(key, field, value);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

	/*------------------------Set value 操作--------------------------------------*/

    /**
     * 增加对应key的value
     *
     * @param key
     * @param values
     * @return Integer reply, specifically: 1 if the new element was added 0 if
     * the element was already a member of the set
     */
    public long sadd(String key, String... values) {
        long re = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.sadd(key, values);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 删除对应key的value
     *
     * @param key
     * @param values
     * @return Integer reply, specifically: 1 if the new element was removed 0
     * if the new element was not a member of the set
     */
    public long srem(String key, String... values) {
        long re = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.srem(key, values);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 返回指定set的所有value
     *
     * @param key
     * @return
     */
    public Set<String> smembers(String key) {
        Set<String> re = null;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.smembers(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 判断member是否是集合key中的成员
     *
     * @param key
     * @param member
     * @return
     */
    public boolean sismember(String key, String member) {
        boolean re = false;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.sismember(key, member);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 返回集合中元素的个数
     *
     * @param key
     * @return
     */
    public long scard(String key) {
        long re = 0;
        if (!this.check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.scard(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 移除并返回集合中的一个随机元素
     *
     * @param key
     * @return
     */
    public String spop(String key) {
        String re = null;
        if (!this.check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.spop(key);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

	/*------------------------ZSet value 操作--------------------------------------*/

    /**
     * 新增对应zset key的member
     *
     * @param key
     * @param score
     * @param member
     * @return 0 member已存在 1 新增成功
     */
    public long zadd(String key, double score, String member) {
        long re = 0;
        if (!this.check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.zadd(key, score, member);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * 返回介于min和max score的value集合
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> zrangebyscore(String key, double min, double max) {
        Set<String> re = null;
        if (!this.check(key)) {
            return re;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.zrangeByScore(key, min, max);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }


    /**
     * 获取成员在排序设置相关的Score
     *
     * @param key
     * @param member
     * @return
     */
    public double zscore(String key, String member) {
        double re = 0;
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = this.getShardedJedis();
            re = shardedJedis.zscore(key, member);
            this.returnResource(shardedJedis);
        } catch (Exception e) {
            if (shardedJedis != null) {
                this.returnBrokenResource(shardedJedis);
            }
            logger.error(e);
        }
        return re;
    }

    /**
     * return to pool.
     *
     * @param jedis
     */
    public void returnResource(ShardedJedis jedis) {
        getShardedJedisPool().returnResource(jedis);
    }

    /**
     * destory resource.
     *
     * @param jedis
     */
    public void returnBrokenResource(ShardedJedis jedis) {
        getShardedJedisPool().returnBrokenResource(jedis);
    }

    private boolean check(String key) {
        byte[] bkey = (key == null ? null : key.getBytes());
        return check(bkey);
    }

    private boolean check(byte[] key) {
        if (this.enableRedis == null || this.enableRedis == false) {
            logger.info("Redis is not enabled");
            return false;
        }
        if (key == null) {
            logger.error("Redis key can not be null.");
            return false;
        }
        return true;
    }

    private boolean hCheck(String key, String field) {
        if (!check(key) || field == null) {
            return false;
        }
        return true;

    }

    private boolean hCheck(byte[] key, byte[] field) {
        if (this.enableRedis == null || this.enableRedis == false) {
            logger.info("Redis is not enabled");
            return false;
        }
        if (!check(key) || field == null) {
            return false;
        }
        return true;
    }

    /**
     * Get sharedJedis instance.
     *
     * @return
     */
    public ShardedJedis getShardedJedis() {
        ShardedJedis jedis = getShardedJedisPool().getResource();
        return jedis;
    }

    public ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }

    public Boolean getEnableRedis() {
        return enableRedis;
    }

    public void setEnableRedis(Boolean givenEnableRedis) {
        enableRedis = givenEnableRedis;
    }

    private ShardedJedisPool shardedJedisPool = null;

    private Boolean enableRedis = false;

    private Logger logger = Logger.getLogger(RedisClient.class);

}

class SerializeUtil {
    private static Logger logger = Logger.getLogger(SerializeUtil.class);

    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        ObjectOutputStream oos = null;

        ByteArrayOutputStream baos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public static Object unserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }
}
