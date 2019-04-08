package com.itgo.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * 
 * <p>
 * 发送http请求
 * </p>
 *
 * @project core
 * @class HTTPUtil
 */
public class HTTPUtil {

	/**
	 * http post
	 * 
	 * @param url
	 * @param requestBody
	 * @return
	 */
	public static String postBody(String url, String requestBody) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost httppost = new HttpPost(url);
			StringEntity reqEntity = new StringEntity(requestBody, "UTF-8");
			httppost.setEntity(reqEntity);
			httppost.addHeader("Content-type", "application/json; charset=utf-8");
			httppost.setHeader("Accept", "application/json");
			response = httpclient.execute(httppost);
			return EntityUtils.toString(response.getEntity());
		} catch (RuntimeException rex) {
			throw rex;
		} catch (Exception ex) {
			throw new RuntimeException("http请求出现错误!", ex);
		} finally {
			IOUtils.closeQuietly(response);
			IOUtils.closeQuietly(httpclient);
		}
	}

	/**
	 * post
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public static String postParams(String url, Map<String, String> params) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			RequestBuilder requestBuilder = RequestBuilder.post().setUri(new URI(url));
			for (Iterator<String> itr = params == null ? null : params.keySet().iterator(); itr != null && itr.hasNext();) {
				String key = itr.next();
				requestBuilder.addParameter(key, params.get(key));
			}
			HttpUriRequest request = requestBuilder.build();
			request.addHeader("Content-type", "application/json; charset=utf-8");
			request.setHeader("Accept", "application/json");
			response = httpclient.execute(request);
			return EntityUtils.toString(response.getEntity());
		} catch (RuntimeException rex) {
			throw rex;
		} catch (Exception ex) {
			throw new RuntimeException("http请求出现错误!", ex);
		} finally {
			IOUtils.closeQuietly(response);
			IOUtils.closeQuietly(httpclient);
		}
	}

	/**
	 * get httpjson
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public static String get(String url, Map<String, String> params) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			RequestBuilder requestBuilder = RequestBuilder.post().setUri(new URI(url));
			for (Iterator<String> itr = params == null ? null : params.keySet().iterator(); itr != null && itr.hasNext();) {
				String key = itr.next();
				requestBuilder.addParameter(key, params.get(key));
			}
			HttpUriRequest request = requestBuilder.build();
			request.addHeader("Content-type", "application/json; charset=utf-8");
			request.setHeader("Accept", "application/json");
			response = httpclient.execute(request);
			return EntityUtils.toString(response.getEntity());
		} catch (RuntimeException rex) {
			throw rex;
		} catch (Exception ex) {
			throw new RuntimeException("http请求出现错误!", ex);
		} finally {
			IOUtils.closeQuietly(response);
			IOUtils.closeQuietly(httpclient);
		}
	}



	public static String sendGet(String url) {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			URL realUrl = new URL(url);

			HttpURLConnection httpURLConnection = (HttpURLConnection) realUrl.openConnection();
			//在这里设置一些属性，详细见UrlConnection文档，HttpURLConnection是UrlConnection的子类
			//设置连接超时为5秒
			httpURLConnection.setConnectTimeout(5000);
			//设定请求方式(默认为get)
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("accept", "*/*");
			httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
			httpURLConnection.setRequestProperty("contentType", "UTF-8");
			httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
			//建立到远程对象的实际连接
			httpURLConnection.connect();
			GZIPInputStream gZIPInputStream = null;
			String encoding = httpURLConnection.getContentEncoding();
			if(encoding.equals("gzip")){
				gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream));
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					//转化为UTF-8的编码格式
					line = new String(line.getBytes("UTF-8"));
					stringBuffer.append(line);
				}
				bufferedReader.close();
			}else{
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					//转化为UTF-8的编码格式
					line = new String(line.getBytes("UTF-8"));
					stringBuffer.append(line);
				}
				bufferedReader.close();
			}
			//返回打开连接读取的输入流，输入流转化为StringBuffer类型，这一套流程要记住，常用


			httpURLConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}


}
