/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.aws2.s3.springboot;

import org.apache.camel.component.aws2.s3.AWS2S3Component;
import org.apache.camel.component.aws2.s3.AWS2S3Configuration;
import org.apache.camel.component.aws2.s3.AWS2S3Operations;
import org.apache.camel.component.aws2.s3.stream.AWSS3NamingStrategyEnum;
import org.apache.camel.component.aws2.s3.stream.AWSS3RestartingPolicyEnum;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;
import software.amazon.awssdk.core.Protocol;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

/**
 * Store and retrieve objects from AWS S3 Storage Service.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.aws2-s3")
public class AWS2S3ComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the aws2-s3 component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Setting the autocreation of the S3 bucket bucketName. This will apply
     * also in case of moveAfterRead option enabled, and it will create the
     * destinationBucket if it doesn't exist already.
     */
    private Boolean autoCreateBucket = false;
    /**
     * The component configuration. The option is a
     * org.apache.camel.component.aws2.s3.AWS2S3Configuration type.
     */
    private AWS2S3Configuration configuration;
    /**
     * The delimiter which is used in the
     * com.amazonaws.services.s3.model.ListObjectsRequest to only consume
     * objects we are interested in.
     */
    private String delimiter;
    /**
     * Set whether the S3 client should use path-style URL instead of
     * virtual-hosted-style
     */
    private Boolean forcePathStyle = false;
    /**
     * If it is true, the S3 Object Body will be ignored completely if it is set
     * to false, the S3 Object will be put in the body. Setting this to true
     * will override any behavior defined by includeBody option.
     */
    private Boolean ignoreBody = false;
    /**
     * Set the need for overriding the endpoint. This option needs to be used in
     * combination with the uriEndpointOverride option
     */
    private Boolean overrideEndpoint = false;
    /**
     * If we want to use a POJO request as body or not
     */
    private Boolean pojoRequest = false;
    /**
     * The policy for this queue to set in the
     * com.amazonaws.services.s3.AmazonS3#setBucketPolicy() method.
     */
    private String policy;
    /**
     * The prefix which is used in the
     * com.amazonaws.services.s3.model.ListObjectsRequest to only consume
     * objects we are interested in.
     */
    private String prefix;
    /**
     * The region in which the S3 client needs to work. When using this
     * parameter, the configuration will expect the lowercase name of the region
     * (for example, ap-east-1) You'll need to use the name
     * Region.EU_WEST_1.id()
     */
    private String region;
    /**
     * Set the overriding uri endpoint. This option needs to be used in
     * combination with overrideEndpoint option
     */
    private String uriEndpointOverride;
    /**
     * Define the customer algorithm to use in case CustomerKey is enabled
     */
    private String customerAlgorithm;
    /**
     * Define the id of the Customer key to use in case CustomerKey is enabled
     */
    private String customerKeyId;
    /**
     * Define the MD5 of Customer key to use in case CustomerKey is enabled
     */
    private String customerKeyMD5;
    /**
     * Allows for bridging the consumer to the Camel routing Error Handler,
     * which mean any exceptions (if possible) occurred while the Camel consumer
     * is trying to pickup incoming messages, or the likes, will now be
     * processed as a message and handled by the routing Error Handler.
     * Important: This is only possible if the 3rd party component allows Camel
     * to be alerted if an exception was thrown. Some components handle this
     * internally only, and therefore bridgeErrorHandler is not possible. In
     * other situations we may improve the Camel component to hook into the 3rd
     * party component and make this possible for future releases. By default
     * the consumer will use the org.apache.camel.spi.ExceptionHandler to deal
     * with exceptions, that will be logged at WARN or ERROR level and ignored.
     */
    private Boolean bridgeErrorHandler = false;
    /**
     * Delete objects from S3 after they have been retrieved. The deleting is
     * only performed if the Exchange is committed. If a rollback occurs, the
     * object is not deleted. If this option is false, then the same objects
     * will be retrieved over and over again in the polls. Therefore, you need
     * to use the Idempotent Consumer EIP in the route to filter out duplicates.
     * You can filter using the AWS2S3Constants#BUCKET_NAME and
     * AWS2S3Constants#KEY headers, or only the AWS2S3Constants#KEY header.
     */
    private Boolean deleteAfterRead = true;
    /**
     * Define the destination bucket where an object must be moved when
     * moveAfterRead is set to true.
     */
    private String destinationBucket;
    /**
     * Define the destination bucket prefix to use when an object must be moved,
     * and moveAfterRead is set to true.
     */
    private String destinationBucketPrefix;
    /**
     * Define the destination bucket suffix to use when an object must be moved,
     * and moveAfterRead is set to true.
     */
    private String destinationBucketSuffix;
    /**
     * If provided, Camel will only consume files if a done file exists.
     */
    private String doneFileName;
    /**
     * To get the object from the bucket with the given file name
     */
    private String fileName;
    /**
     * If it is true, the S3Object exchange will be consumed and put into the
     * body and closed. If false, the S3Object stream will be put raw into the
     * body and the headers will be set with the S3 object metadata. This option
     * is strongly related to the autocloseBody option. In case of setting
     * includeBody to true because the S3Object stream will be consumed then it
     * will also be closed, while in case of includeBody false then it will be
     * up to the caller to close the S3Object stream. However, setting
     * autocloseBody to true when includeBody is false it will schedule to close
     * the S3Object stream automatically on exchange completion.
     */
    private Boolean includeBody = true;
    /**
     * If it is true, the folders/directories will be consumed. If it is false,
     * they will be ignored, and Exchanges will not be created for those
     */
    private Boolean includeFolders = true;
    /**
     * Move objects from S3 bucket to a different bucket after they have been
     * retrieved. To accomplish the operation, the destinationBucket option must
     * be set. The copy bucket operation is only performed if the Exchange is
     * committed. If a rollback occurs, the object is not moved.
     */
    private Boolean moveAfterRead = false;
    /**
     * If this option is true and includeBody is false, then the
     * S3Object.close() method will be called on exchange completion. This
     * option is strongly related to includeBody option. In case of setting
     * includeBody to false and autocloseBody to false, it will be up to the
     * caller to close the S3Object stream. Setting autocloseBody to true, will
     * close the S3Object stream automatically.
     */
    private Boolean autocloseBody = true;
    /**
     * The number of messages composing a batch in streaming upload mode
     */
    private Integer batchMessageNumber = 10;
    /**
     * The batch size (in bytes) in streaming upload mode
     */
    private Integer batchSize = 1000000;
    /**
     * The buffer size (in bytes) in streaming upload mode
     */
    private Integer bufferSize = 1000000;
    /**
     * Delete file object after the S3 file has been uploaded
     */
    private Boolean deleteAfterWrite = false;
    /**
     * Setting the key name for an element in the bucket through endpoint
     * parameter
     */
    private String keyName;
    /**
     * Whether the producer should be started lazy (on the first message). By
     * starting lazy you can use this to allow CamelContext and routes to
     * startup in situations where a producer may otherwise fail during starting
     * and cause the route to fail being started. By deferring this startup to
     * be lazy then the startup failure can be handled during routing messages
     * via Camel's routing error handlers. Beware that when the first message is
     * processed then creating and starting the producer may take a little time
     * and prolong the total processing time of the processing.
     */
    private Boolean lazyStartProducer = false;
    /**
     * If it is true, camel will upload the file with multipart format. The part
     * size is decided by the partSize option. Camel will only do multipart
     * uploads for files that are larger than the part-size thresholds. Files
     * that are smaller will be uploaded in a single operation.
     */
    private Boolean multiPartUpload = false;
    /**
     * The naming strategy to use in streaming upload mode
     */
    private AWSS3NamingStrategyEnum namingStrategy = AWSS3NamingStrategyEnum.progressive;
    /**
     * The operation to do in case the user don't want to do only an upload
     */
    private AWS2S3Operations operation;
    /**
     * Set up the partSize which is used in multipart upload, the default size
     * is 25M. Camel will only do multipart uploads for files that are larger
     * than the part-size thresholds. Files that are smaller will be uploaded in
     * a single operation.
     */
    private Long partSize = 26214400L;
    /**
     * The restarting policy to use in streaming upload mode
     */
    private AWSS3RestartingPolicyEnum restartingPolicy = AWSS3RestartingPolicyEnum.override;
    /**
     * The storage class to set in the
     * com.amazonaws.services.s3.model.PutObjectRequest request.
     */
    private String storageClass;
    /**
     * When stream mode is true, the upload to bucket will be done in streaming
     */
    private Boolean streamingUploadMode = false;
    /**
     * While streaming upload mode is true, this option set the timeout to
     * complete upload
     */
    private Long streamingUploadTimeout;
    /**
     * Define the id of KMS key to use in case KMS is enabled
     */
    private String awsKMSKeyId;
    /**
     * Uploads the object only if the object key name does not already exist in
     * the bucket specified.
     */
    private Boolean conditionalWritesEnabled = false;
    /**
     * Define if KMS must be used or not
     */
    private Boolean useAwsKMS = false;
    /**
     * Define if Customer Key must be used or not
     */
    private Boolean useCustomerKey = false;
    /**
     * Define if SSE S3 must be used or not
     */
    private Boolean useSSES3 = false;
    /**
     * Reference to a com.amazonaws.services.s3.AmazonS3 in the registry. The
     * option is a software.amazon.awssdk.services.s3.S3Client type.
     */
    private S3Client amazonS3Client;
    /**
     * An S3 Presigner for Request, used mainly in createDownloadLink operation.
     * The option is a software.amazon.awssdk.services.s3.presigner.S3Presigner
     * type.
     */
    private S3Presigner amazonS3Presigner;
    /**
     * Whether autowiring is enabled. This is used for automatic autowiring
     * options (the option must be marked as autowired) by looking up in the
     * registry to find if there is a single instance of matching type, which
     * then gets configured on the component. This can be used for automatic
     * configuring JDBC data sources, JMS connection factories, AWS Clients,
     * etc.
     */
    private Boolean autowiredEnabled = true;
    /**
     * Used for enabling or disabling all consumer based health checks from this
     * component
     */
    private Boolean healthCheckConsumerEnabled = true;
    /**
     * Used for enabling or disabling all producer based health checks from this
     * component. Notice: Camel has by default disabled all producer based
     * health-checks. You can turn on producer checks globally by setting
     * camel.health.producersEnabled=true.
     */
    private Boolean healthCheckProducerEnabled = true;
    /**
     * To define a proxy host when instantiating the SQS client
     */
    private String proxyHost;
    /**
     * Specify a proxy port to be used inside the client definition.
     */
    private Integer proxyPort;
    /**
     * To define a proxy protocol when instantiating the S3 client
     */
    private Protocol proxyProtocol = Protocol.HTTPS;
    /**
     * Amazon AWS Access Key
     */
    private String accessKey;
    /**
     * If using a profile credentials provider, this parameter will set the
     * profile name
     */
    private String profileCredentialsName;
    /**
     * Amazon AWS Secret Key
     */
    private String secretKey;
    /**
     * Amazon AWS Session Token used when the user needs to assume an IAM role
     */
    private String sessionToken;
    /**
     * If we want to trust all certificates in case of overriding the endpoint
     */
    private Boolean trustAllCertificates = false;
    /**
     * Set whether the S3 client should expect to load credentials through a
     * default credentials provider.
     */
    private Boolean useDefaultCredentialsProvider = false;
    /**
     * Set whether the S3 client should expect to load credentials through a
     * profile credentials provider.
     */
    private Boolean useProfileCredentialsProvider = false;
    /**
     * Set whether the S3 client should expect to use Session Credentials. This
     * is useful in a situation in which the user needs to assume an IAM role
     * for doing operations in S3.
     */
    private Boolean useSessionCredentials = false;

    public Boolean getAutoCreateBucket() {
        return autoCreateBucket;
    }

    public void setAutoCreateBucket(Boolean autoCreateBucket) {
        this.autoCreateBucket = autoCreateBucket;
    }

    public AWS2S3Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(AWS2S3Configuration configuration) {
        this.configuration = configuration;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public Boolean getForcePathStyle() {
        return forcePathStyle;
    }

    public void setForcePathStyle(Boolean forcePathStyle) {
        this.forcePathStyle = forcePathStyle;
    }

    public Boolean getIgnoreBody() {
        return ignoreBody;
    }

    public void setIgnoreBody(Boolean ignoreBody) {
        this.ignoreBody = ignoreBody;
    }

    public Boolean getOverrideEndpoint() {
        return overrideEndpoint;
    }

    public void setOverrideEndpoint(Boolean overrideEndpoint) {
        this.overrideEndpoint = overrideEndpoint;
    }

    public Boolean getPojoRequest() {
        return pojoRequest;
    }

    public void setPojoRequest(Boolean pojoRequest) {
        this.pojoRequest = pojoRequest;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUriEndpointOverride() {
        return uriEndpointOverride;
    }

    public void setUriEndpointOverride(String uriEndpointOverride) {
        this.uriEndpointOverride = uriEndpointOverride;
    }

    public String getCustomerAlgorithm() {
        return customerAlgorithm;
    }

    public void setCustomerAlgorithm(String customerAlgorithm) {
        this.customerAlgorithm = customerAlgorithm;
    }

    public String getCustomerKeyId() {
        return customerKeyId;
    }

    public void setCustomerKeyId(String customerKeyId) {
        this.customerKeyId = customerKeyId;
    }

    public String getCustomerKeyMD5() {
        return customerKeyMD5;
    }

    public void setCustomerKeyMD5(String customerKeyMD5) {
        this.customerKeyMD5 = customerKeyMD5;
    }

    public Boolean getBridgeErrorHandler() {
        return bridgeErrorHandler;
    }

    public void setBridgeErrorHandler(Boolean bridgeErrorHandler) {
        this.bridgeErrorHandler = bridgeErrorHandler;
    }

    public Boolean getDeleteAfterRead() {
        return deleteAfterRead;
    }

    public void setDeleteAfterRead(Boolean deleteAfterRead) {
        this.deleteAfterRead = deleteAfterRead;
    }

    public String getDestinationBucket() {
        return destinationBucket;
    }

    public void setDestinationBucket(String destinationBucket) {
        this.destinationBucket = destinationBucket;
    }

    public String getDestinationBucketPrefix() {
        return destinationBucketPrefix;
    }

    public void setDestinationBucketPrefix(String destinationBucketPrefix) {
        this.destinationBucketPrefix = destinationBucketPrefix;
    }

    public String getDestinationBucketSuffix() {
        return destinationBucketSuffix;
    }

    public void setDestinationBucketSuffix(String destinationBucketSuffix) {
        this.destinationBucketSuffix = destinationBucketSuffix;
    }

    public String getDoneFileName() {
        return doneFileName;
    }

    public void setDoneFileName(String doneFileName) {
        this.doneFileName = doneFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Boolean getIncludeBody() {
        return includeBody;
    }

    public void setIncludeBody(Boolean includeBody) {
        this.includeBody = includeBody;
    }

    public Boolean getIncludeFolders() {
        return includeFolders;
    }

    public void setIncludeFolders(Boolean includeFolders) {
        this.includeFolders = includeFolders;
    }

    public Boolean getMoveAfterRead() {
        return moveAfterRead;
    }

    public void setMoveAfterRead(Boolean moveAfterRead) {
        this.moveAfterRead = moveAfterRead;
    }

    public Boolean getAutocloseBody() {
        return autocloseBody;
    }

    public void setAutocloseBody(Boolean autocloseBody) {
        this.autocloseBody = autocloseBody;
    }

    public Integer getBatchMessageNumber() {
        return batchMessageNumber;
    }

    public void setBatchMessageNumber(Integer batchMessageNumber) {
        this.batchMessageNumber = batchMessageNumber;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public Integer getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(Integer bufferSize) {
        this.bufferSize = bufferSize;
    }

    public Boolean getDeleteAfterWrite() {
        return deleteAfterWrite;
    }

    public void setDeleteAfterWrite(Boolean deleteAfterWrite) {
        this.deleteAfterWrite = deleteAfterWrite;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public Boolean getMultiPartUpload() {
        return multiPartUpload;
    }

    public void setMultiPartUpload(Boolean multiPartUpload) {
        this.multiPartUpload = multiPartUpload;
    }

    public AWSS3NamingStrategyEnum getNamingStrategy() {
        return namingStrategy;
    }

    public void setNamingStrategy(AWSS3NamingStrategyEnum namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    public AWS2S3Operations getOperation() {
        return operation;
    }

    public void setOperation(AWS2S3Operations operation) {
        this.operation = operation;
    }

    public Long getPartSize() {
        return partSize;
    }

    public void setPartSize(Long partSize) {
        this.partSize = partSize;
    }

    public AWSS3RestartingPolicyEnum getRestartingPolicy() {
        return restartingPolicy;
    }

    public void setRestartingPolicy(AWSS3RestartingPolicyEnum restartingPolicy) {
        this.restartingPolicy = restartingPolicy;
    }

    public String getStorageClass() {
        return storageClass;
    }

    public void setStorageClass(String storageClass) {
        this.storageClass = storageClass;
    }

    public Boolean getStreamingUploadMode() {
        return streamingUploadMode;
    }

    public void setStreamingUploadMode(Boolean streamingUploadMode) {
        this.streamingUploadMode = streamingUploadMode;
    }

    public Long getStreamingUploadTimeout() {
        return streamingUploadTimeout;
    }

    public void setStreamingUploadTimeout(Long streamingUploadTimeout) {
        this.streamingUploadTimeout = streamingUploadTimeout;
    }

    public String getAwsKMSKeyId() {
        return awsKMSKeyId;
    }

    public void setAwsKMSKeyId(String awsKMSKeyId) {
        this.awsKMSKeyId = awsKMSKeyId;
    }

    public Boolean getConditionalWritesEnabled() {
        return conditionalWritesEnabled;
    }

    public void setConditionalWritesEnabled(Boolean conditionalWritesEnabled) {
        this.conditionalWritesEnabled = conditionalWritesEnabled;
    }

    public Boolean getUseAwsKMS() {
        return useAwsKMS;
    }

    public void setUseAwsKMS(Boolean useAwsKMS) {
        this.useAwsKMS = useAwsKMS;
    }

    public Boolean getUseCustomerKey() {
        return useCustomerKey;
    }

    public void setUseCustomerKey(Boolean useCustomerKey) {
        this.useCustomerKey = useCustomerKey;
    }

    public Boolean getUseSSES3() {
        return useSSES3;
    }

    public void setUseSSES3(Boolean useSSES3) {
        this.useSSES3 = useSSES3;
    }

    public S3Client getAmazonS3Client() {
        return amazonS3Client;
    }

    public void setAmazonS3Client(S3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public S3Presigner getAmazonS3Presigner() {
        return amazonS3Presigner;
    }

    public void setAmazonS3Presigner(S3Presigner amazonS3Presigner) {
        this.amazonS3Presigner = amazonS3Presigner;
    }

    public Boolean getAutowiredEnabled() {
        return autowiredEnabled;
    }

    public void setAutowiredEnabled(Boolean autowiredEnabled) {
        this.autowiredEnabled = autowiredEnabled;
    }

    public Boolean getHealthCheckConsumerEnabled() {
        return healthCheckConsumerEnabled;
    }

    public void setHealthCheckConsumerEnabled(Boolean healthCheckConsumerEnabled) {
        this.healthCheckConsumerEnabled = healthCheckConsumerEnabled;
    }

    public Boolean getHealthCheckProducerEnabled() {
        return healthCheckProducerEnabled;
    }

    public void setHealthCheckProducerEnabled(Boolean healthCheckProducerEnabled) {
        this.healthCheckProducerEnabled = healthCheckProducerEnabled;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public Integer getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(Integer proxyPort) {
        this.proxyPort = proxyPort;
    }

    public Protocol getProxyProtocol() {
        return proxyProtocol;
    }

    public void setProxyProtocol(Protocol proxyProtocol) {
        this.proxyProtocol = proxyProtocol;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getProfileCredentialsName() {
        return profileCredentialsName;
    }

    public void setProfileCredentialsName(String profileCredentialsName) {
        this.profileCredentialsName = profileCredentialsName;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Boolean getTrustAllCertificates() {
        return trustAllCertificates;
    }

    public void setTrustAllCertificates(Boolean trustAllCertificates) {
        this.trustAllCertificates = trustAllCertificates;
    }

    public Boolean getUseDefaultCredentialsProvider() {
        return useDefaultCredentialsProvider;
    }

    public void setUseDefaultCredentialsProvider(
            Boolean useDefaultCredentialsProvider) {
        this.useDefaultCredentialsProvider = useDefaultCredentialsProvider;
    }

    public Boolean getUseProfileCredentialsProvider() {
        return useProfileCredentialsProvider;
    }

    public void setUseProfileCredentialsProvider(
            Boolean useProfileCredentialsProvider) {
        this.useProfileCredentialsProvider = useProfileCredentialsProvider;
    }

    public Boolean getUseSessionCredentials() {
        return useSessionCredentials;
    }

    public void setUseSessionCredentials(Boolean useSessionCredentials) {
        this.useSessionCredentials = useSessionCredentials;
    }
}