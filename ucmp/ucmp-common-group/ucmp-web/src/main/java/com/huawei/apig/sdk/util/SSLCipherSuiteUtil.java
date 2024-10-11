/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.apig.sdk.util;

import okhttp3.OkHttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.*;
import org.openeuler.BGMProvider;

public class SSLCipherSuiteUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(SSLCipherSuiteUtil.class);
    private static OkHttpClient okHttpClient;

    public static OkHttpClient createOkHttpClient(String protocol) throws Exception {
        SSLContext sslContext = getSslContext(protocol);
        // Create an ssl socket factory with our all-trusting manager
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, new TrustAllManager())
                .hostnameVerifier(new TrustAllHostnameVerifier());
        okHttpClient = builder.connectTimeout(10, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).build();
        return okHttpClient;
    }

    public static HttpURLConnection createHttpsOrHttpURLConnection(URL uUrl, String protocol) throws Exception {
        // initial connection
        if (uUrl.getProtocol().toUpperCase(Locale.getDefault()).equals(Constant.HTTPS)) {
            SSLContext sslContext = getSslContext(protocol);
            HttpsURLConnection.setDefaultHostnameVerifier(new TrustAllHostnameVerifier());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            return (HttpsURLConnection) uUrl.openConnection();
        }
        return (HttpURLConnection) uUrl.openConnection();
    }

    private static SSLContext getSslContext(String protocol) throws UnsupportProtocolException,
            NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        if (!Constant.GM_PROTOCOL.equals(protocol) && !Constant.INTERNATIONAL_PROTOCOL.equals(protocol)) {
            LOGGER.info("Unsupport protocol: {}, Only support GMTLS TLSv1.2", protocol);
            throw new UnsupportProtocolException("Unsupport protocol, Only support GMTLS TLSv1.2");
        }
        // Create a trust manager that does not validate certificate chains
        TrustAllManager[] trust = {new TrustAllManager()};
        KeyManager[] kms = null;
        SSLContext sslContext;

        sslContext = SSLContext.getInstance(Constant.INTERNATIONAL_PROTOCOL, "SunJSSE");

        if (Constant.GM_PROTOCOL.equals(protocol)) {
            Security.insertProviderAt(new BGMProvider(), 1);
            sslContext = SSLContext.getInstance(Constant.GM_PROTOCOL, "BGMProvider");
        }
        SecureRandom secureRandom = new SecureRandom();
        sslContext.init(kms, trust, secureRandom);
        sslContext.getServerSessionContext().setSessionCacheSize(8192);
        sslContext.getServerSessionContext().setSessionTimeout(3600);
        return sslContext;
    }

    // 不校验域名
    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
    // 不校验服务端证书
    private static class TrustAllManager implements X509TrustManager {
        private X509Certificate[] issuers;

        public TrustAllManager() {
            this.issuers = new X509Certificate[0];
        }

        public X509Certificate[] getAcceptedIssuers() {
            return issuers;
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }
    }
}