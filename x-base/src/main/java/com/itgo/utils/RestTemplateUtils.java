package com.itgo.utils;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;

/**
 * Created by admin on 2018/4/17.
 */
public class RestTemplateUtils {
    private static class SingletonRestTemplate {


        /**
         * 单例对象实例
         */
        static final RestTemplate INSTANCE = new RestTemplate();
    }

    private RestTemplateUtils() {

    }
    /**
     * 单例实例
     */
    public static RestTemplate getInstance() {
        return SingletonRestTemplate.INSTANCE;
    }


    /**
     *
     * 发送post请求
     *
     * @param url
     *            请求URL地址
     * @param data
     *            json数据
     * @param token
     *            RSA加密token【RSA({PlatformCode+TenantCode+DateTime.Now()})//平台代码
     *            +会员/租户代码+当前时间，然后进行RSA加密】
     */
    public static String post(String url, String data, String token)
            throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");
        headers.add("Content-Encoding", "UTF-8");
        headers.add("Content-Type", "text/xml;charset=utf-8");
        headers.add("SOAPAction", "");
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return RestTemplateUtils.getInstance().postForObject(url, formEntity, String.class);
    }


    public static String postkingdee(String url, String data, String token)
            throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","text/html;charset=utf-8");
        headers.add( HttpHeaders.USER_AGENT,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
        headers.add( HttpHeaders.ORIGIN,"chrome-extension://aicmkgpgakddgnaphhhpliifpcfhicfo");
        headers.add( HttpHeaders.ACCEPT_LANGUAGE,"zh-CN,zh;q=0.9,en;q=0.8");
        headers.add("SOAPAction", "Jakarta Commons-HttpClient/3.1");
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        return RestTemplateUtils.getInstance().postForObject(url, formEntity, String.class);
    }
  //  jian.li    ljjian
    /**
     * get根据url获取对象
     */
    public String get(String url) {
        return RestTemplateUtils.getInstance().getForObject(url, String.class,
                new Object[]{});
    }

    /**
     * getById根据ID获取对象
     */
    public String getById(String url, String id) {
        return RestTemplateUtils.getInstance().getForObject(url, String.class,
                id);
    }

    /**
     * post提交对象
     */
    public String post(String url, String data) {
        return RestTemplateUtils.getInstance().postForObject(url, null,
                String.class, data);
    }

    /**
     * put修改对象
     */
    public void put(String url, String data) {
        RestTemplateUtils.getInstance().put(url, null, data);
    }

    /**
     * delete根据ID删除对象
     */
    public void delete(String url, String id) {
        RestTemplateUtils.getInstance().delete(url, id);
    }

    public static void main(String[] args) {
        try {
         //   System.out.println(RestTemplateUtils.post("http://111.6.186.56:6887/ormrpc/services/EASLogin",KingdeeEnum.TestEASLogin.getTemplate(),""));

            System.out.println();
            StringReader stringReader=new StringReader( RestTemplateUtils.post("http://111.6.186.56:6887/ormrpc/services/WSBaseSuplyServices","<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.fac.custom.eas.kingdee.com\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <web:TransCurrencyData soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                    "         <jsonData xsi:type=\"xsd:string\">{\n" +
                    "   \"number\":\"\",\n" +
                    "   \"name\":\"\",\n" +
                    "   \"isonum\":\"\",\n" +
                    "   \"baseunit\":\"\",\n" +
                    "   \"float\":\"\",\n" +
                    "   \"accuracy\":\"\"\n" +
                    "}\n" +
                    "</jsonData>\n" +
                    "      </web:TransCurrencyData>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>",""));

            SAXReader saxReader=new SAXReader();
            Document document=  saxReader.read(stringReader);
            Node node=document.selectSingleNode("//TransCurrencyDataReturn");
            System.out.println(node.getText());

            //System.out.println(KingdeeEnum.Currency.getTemplate());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
