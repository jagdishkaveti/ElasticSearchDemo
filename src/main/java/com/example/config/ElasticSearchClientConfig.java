package com.example.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

public class ElasticSearchClientConfig {
	
	@Value("${elasticsearch.cluster-name}")
	String clusterName;
	@Value("${elasticsearch.hostname}")
	String host;
	@Value("${elasticsearch.port}")
	int port;
	
	@Bean
	public Client client() throws Exception {
		
		Settings esSettings = Settings.settingsBuilder().put("cluster.name",clusterName).build();
		return TransportClient.builder().settings(esSettings).build()
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
		
	}
	
	@Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }

}
