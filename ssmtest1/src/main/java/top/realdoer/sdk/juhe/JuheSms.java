package top.realdoer.sdk.juhe;

import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import top.realdoer.constant.ResultEnum;
import top.realdoer.exception.ExternalAPIException;

/**
 * @author 孙继峰
 * @date 2019年2月16日 
 * TODO: 配置able
 */
@Component
public class JuheSms {
    private static final String DEF_CHATSET = "UTF-8";
    private static final int DEF_CONN_TIMEOUT = 30000;
    private static final int DEF_READ_TIMEOUT = 30000;
    /**
     * 注册场景短信模板 id
     */
    public static final String REGIST_TEMPLATE_ID = "134462";
    /**
     * 登陆场景短信模板 id
     */
    public static final String LOGIN_TEMPLATE_ID = "134464";
    
    private static final String APPKEY = "055abbd1493becfae19cab33becd7d83";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) "
            + "Gecko/20100101 Firefox/65.0";

    /**
     * 发送登陆验证码短信
     * @param phone 电话号
     * @param verificationCode 验证码
     * @throws ExternalAPIException 外部 API 调用失败时抛出
     */
    public void sendLoginSms(String phone, String verificationCode) throws ExternalAPIException {
        sendSms(phone, verificationCode, LOGIN_TEMPLATE_ID);
    }

    /**
     * 发送注册验证短信
     * @param phone 电话号
     * @param verificationCode 验证码
     * @throws ExternalAPIException 外部 API 调用失败时抛出
     */
    public void sendRegistSms(String phone, String verificationCode) throws ExternalAPIException {
        sendSms(phone, verificationCode, REGIST_TEMPLATE_ID);
    }

    private void sendSms(String phone, String verificationCode, String scene) throws ExternalAPIException {
        String result = null;
        // 请求接口地址
        String url = "http://v.juhe.cn/sms/send";
        // 请求参数
        Map<String, String> params = new HashMap<>();
        params.put("mobile", phone);
        // 短信模板ID
        params.put("tpl_id", scene);
        // 您设置的模板变量，根据实际情况修改
        params.put("tpl_value", "#code#=" + verificationCode);
        // 应用APPKEY(应用详细页查询)
        params.put("key", APPKEY);
        try {
            result = net(url, params, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject(result);
        if (!(jsonObject.getInt("error_code") == 0)) {
            ResultEnum resultEnum = ResultEnum.EXTERNAL_API_ERROR;
            resultEnum.setResultMessage(jsonObject.getString("reason"));
            throw new ExternalAPIException(resultEnum);
        }
    }

    /**
     * 发送请求
     * 
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return 网络请求字符串
     * @throws Exception
     */
    private String net(String strUrl, Map<String, String> params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if (method == null || method.equals("GET")) {
                strUrl = strUrl + "?" + urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (method == null || method.equals("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", USER_AGENT);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    /**
     * 将 map 型转为请求参数型
     * 
     * @param data
     * @return
     */
    private String urlencode(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
