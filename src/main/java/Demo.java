import cloud.neice.ApiClient;
import cloud.neice.ApiException;
import cloud.neice.Configuration;
import cloud.neice.api.BalanceApi;
import cloud.neice.api.DeviceApi;
import cloud.neice.api.OauthApi;
import cloud.neice.auth.OAuth;
import cloud.neice.model.OutResponseOfBalance;
import cloud.neice.model.OutResponseOfListOfPersonalCertificate;
import cloud.neice.model.OutResponseOfPersonalCertificate;

public class Demo {
    public static void main(String[] args) {

        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://neice.cloud");  // host填写渠道的地址

        // Configure OAuth2 access token for authorization: Authorization
        OAuth Authorization = (OAuth) defaultClient.getAuthentication("Authorization");
        OauthApi api = new OauthApi(defaultClient);

        // 在平台的"账户管理--AccessKey管理"菜单中创建AccessKey，获得AccessKey ID和AccessKey Secret
        String accessKeyId = "your_accessKey_id";
        String accessKeySecret = "your_accessKey_secret";
        try {
            Authorization.setAccessToken(api.getToken(accessKeyId, accessKeySecret));
        } catch (ApiException ignore) {
        }

        /**
         * 获取用户余额
         */
        BalanceApi apiInstance = new BalanceApi(defaultClient);
        try {
            OutResponseOfBalance result = apiInstance.getBalance();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BalanceApi#getBalance");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }

        /**
         * 获取iOS设备证书/列表
         */
        DeviceApi deviceApi = new DeviceApi(defaultClient);
        String udid = "device_udid";
        try {
            // 获取iOS设备证书
            OutResponseOfPersonalCertificate cert = deviceApi.getCertificate(udid);

            // 获取iOS设备证书列表
            OutResponseOfListOfPersonalCertificate certs = deviceApi.getCertificates(20, 1, true);
            System.out.println(cert);
            System.out.println(certs);
        } catch (ApiException ignore) {
        }

    }
}
