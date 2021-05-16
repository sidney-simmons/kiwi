package com.sidneysimmons.kiwi.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Cache configuration.
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    /**
     * Setup the cache manager.
     * 
     * @return the cache manager
     * @throws URISyntaxException thrown if the configuration file cannot be read
     */
    @Bean(name = "cacheManager")
    public JCacheCacheManager cacheManager() throws URISyntaxException {
        return new JCacheCacheManager(cacheManagerFactory().getObject());
    }

    /**
     * Setup the cache manager factory.
     * 
     * @return the cache manager factory
     * @throws URISyntaxException thrown if the configuration file cannot be read
     */
    @Bean(name = "cacheManagerFactory")
    public JCacheManagerFactoryBean cacheManagerFactory() throws URISyntaxException {
        JCacheManagerFactoryBean factory = new JCacheManagerFactoryBean();
        factory.setCacheManagerUri(new URI("classpath:ehcache.xml"));
        return factory;
    }

}