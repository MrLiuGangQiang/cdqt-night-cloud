package org.cdqt.module.security.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.cdqt.night.redis.RedisCacheConfiguration;
import org.cdqt.night.redis.RedisCacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

/**
 * Redis配置
 *
 * @author LiuGangQiang Create in 2020/03/02
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
	/**
	 * 缓存名 值为 {@value}
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 */
	private final static String CACHE_NAME = "cahce";

	/**
	 * 实例化 {@link RedisCacheManager} 对象
	 *
	 * @author LiuGangQiang Create in 2020/03/02
	 * @param factory {@link RedisConnectionFactory} 对象
	 * @return {@link RedisCacheManager} 对象
	 */
	@Bean
	public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {
		/* redis序列化设置 */
		Jackson2JsonRedisSerializer<?> jsonSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		/* 此设置已过时 */
		// om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
		jsonSerializer.setObjectMapper(om);

		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		config = config.entryTtl(Duration.ofMinutes(30))/* 设置默认过期时间 默认30分钟 */
				.setDelay(true) /* 设置是否自动延期 扩展属性 */
				.disableCachingNullValues()/* 不缓存空值 */
				.serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))/* 序列化key */
				.serializeValuesWith(SerializationPair.fromSerializer(jsonSerializer));/* 设置序列化方式 */

		/* 设置一个初始化的缓存空间set集合 */
		Set<String> cacheNames = new HashSet<>();
		cacheNames.add(CACHE_NAME);

		/* 对每个缓存空间应用不同的配置 */
		Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
		configMap.put(CACHE_NAME, config);

		RedisCacheManager cacheManager = RedisCacheManager.builder(factory) /* 使用自定义的缓存配置初始化一个cacheManager */
				.initialCacheNames(cacheNames) /* 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，再初始化相关的配置 */
				.withInitialCacheConfigurations(configMap).build();
		return cacheManager;
	}
}