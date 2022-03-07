package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobClientBuilder;

@Configuration
public class AzureStorageBlobClientConfig {

    @Value("${blob.connection-string}")
    String connectionString;

    @Value("${blob.container-name}")
    String containerName;
    
    @Value("${azure.valut.url}")
    String valutUrl;

    @Bean
    public BlobClientBuilder getClient() {
        BlobClientBuilder client = new BlobClientBuilder();
        client.connectionString(connectionString);
        client.containerName(containerName);
        return client;
    }
    
//    @Bean
//    public SecretClient  getSecureClient() {
//    	return new SecretClientBuilder()
//    			  .vaultUrl(valutUrl)
//    			  .credential(new DefaultAzureCredentialBuilder().build())
//    			  .buildClient();
//    }
}
