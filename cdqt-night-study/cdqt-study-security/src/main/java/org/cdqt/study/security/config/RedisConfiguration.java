package org.cdqt.study.security.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.cdqt.night.redis.RedisCacheConfiguration;
import org.cdqt.night.redis.RedisCacheManager;
import org.cdqt.study.security.global.BaseGlobal;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

/**
 * Redis配置类
 *
 * @author LiuGangQiang Create in 2020/10/25
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

	/**
	 * Redis缓存管理
	 *
	 * @author LiuGangQiang Create in 2020/10/25
	 * @param factory 连接工厂
	 * @return {@link RedisCacheManager}
	 */
	@Bean
	public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {
		/* Redis序列化设置 */
		Jackson2JsonRedisSerializer<?> jsonSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
		jsonSerializer.setObjectMapper(om);

		/* Redis缓存配置类 */
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		/* 设置默认过期时间 默认30分钟 */
		config = config.entryTtl(Duration.ofMinutes(30))
				/* 不缓存空值 */
				.disableCachingNullValues()
				/* 设置Key的序列化方式 */
				.serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
				/* 设置Value的序列化方式 */
				.serializeValuesWith(SerializationPair.fromSerializer(jsonSerializer))
				/* 设置是否自动延期 */
				.setDelay(true);

		/* 设置一个初始化的缓存空间set集合 */
		Set<String> cacheNames = new HashSet<>();
		cacheNames.add(BaseGlobal.CACHE_WEB_USER);
		cacheNames.add(BaseGlobal.CACHE_USER_SECURITY);

		/* 对每个缓存空间应用不同的配置 */
		Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
		configMap.put(BaseGlobal.CACHE_WEB_USER, config);
		configMap.put(BaseGlobal.CACHE_WEB_USER, config);

		/* 使用自定义的缓存配置初始化一个RedisCacheManager */
		RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
				/* 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，再初始化相关的配置 */
				.initialCacheNames(cacheNames)
				/* 初始化相关配置 */
				.withInitialCacheConfigurations(configMap).build();
		return cacheManager;
	}
}