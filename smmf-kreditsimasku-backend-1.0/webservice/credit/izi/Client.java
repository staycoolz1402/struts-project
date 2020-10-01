package credit.izi;

import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.util.Calendar;
import java.util.Map;

import credit.izi.http.Headers;
import credit.izi.http.HttpContentType;
import credit.izi.http.HttpMethodName;
import credit.izi.http.IziHttpClient;
import credit.izi.http.IziRequest;
import credit.izi.http.IziResponse;
import credit.izi.util.IziClientConfiguration;
import credit.izi.util.SSLUtilities;
import credit.izi.util.SignUtil;
import credit.izi.util.Util;

public class Client {

    protected String aipKey;
    protected String aipToken;
    protected Calendar expireDate;
    public static IziClientConfiguration config;

    public Client(String apiKey, String secretKey) {
        this.aipKey = apiKey;
        this.aipToken = secretKey;

        expireDate = null;

        SSLUtilities.trustAllHostnames();
        SSLUtilities.trustAllHttpsCertificates();
    }

    /**
     * @param timeout 服务器建立连接的超时时间（单位：毫秒）
     */
    public void setConnectionTimeoutInMillis(int timeout) {
        if (config == null) {
            config = new IziClientConfiguration();
        }
        this.config.setConnectionTimeoutMillis(timeout);
    }

    /**
     * @param timeout 通过打开的连接传输数据的超时时间（单位：毫秒）
     */
    public void setSocketTimeoutInMillis(int timeout) {
        if (config == null) {
            config = new IziClientConfiguration();
        }
        this.config.setSocketTimeoutMillis(timeout);
    }

    /**
     * 设置访问网络需要的http代理
     *
     * @param host 代理服务器地址
     * @param port 代理服务器端口
     */
    public void setHttpProxy(String host, int port) {
        if (config == null) {
            config = new IziClientConfiguration();
        }
        this.config.setProxy(host, port, Proxy.Type.HTTP);
    }

    /**
     * 设置访问网络需要的socket代理
     *
     * @param host 代理服务器地址
     * @param port 代理服务器端口
     */
    public void setSocketProxy(String host, int port) {
        if (config == null) {
            config = new IziClientConfiguration();
        }
        this.config.setProxy(host, port, Proxy.Type.SOCKS);
    }

    public static void preOperation(IziRequest request) {

        request.setHttpMethod(HttpMethodName.POST);
        request.addHeader(Headers.CONTENT_TYPE, HttpContentType.FORM_URLENCODE_DATA);
        request.addHeader("accept", "*/*");
        request.setConfig(config);
    }


    protected void postOperation(IziRequest request) {

        String bodyStr = request.getBodyStr();

        try {
            int len = bodyStr.getBytes(request.getContentEncoding()).length;
            request.addHeader(Headers.CONTENT_LENGTH, Integer.toString(len));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        request.addHeader(Headers.CONTENT_MD5, SignUtil.md5(bodyStr, request.getContentEncoding()));

        String timestamp = Util.getCanonicalTime();
        request.addHeader(Headers.HOST, request.getUri().getHost());
        request.addHeader(Headers.AUTHORIZATION, Auth.sign(request, this.aipKey, this.aipToken, timestamp));

    }

    /**
     * send request to server
     *
     * @param request IziRequest object
     * @return String of server response
     */
    protected String requestServer(IziRequest request) {
        // 请求API
        IziResponse response = IziHttpClient.post(request);
        String resData = response.getBodyStr();
        Integer status = response.getStatus();
        if (status.equals(200) && !resData.equals("")) {
            return resData;
        } else {
            return IziError.NET_TIMEOUT_ERROR.toString();
        }
    }

    public String Request(String url, Map<String, String> data) {
        IziRequest request = new IziRequest();
        this.preOperation(request);
        request.addBody(data);
        request.setUri(url);
        this.postOperation(request);
        return this.requestServer(request);
    }

}
