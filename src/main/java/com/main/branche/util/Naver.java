package com.main.branche.util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Naver {

	public static String getShoppingData(String clientId,String clientSecret, Pager pager) {
        String text = null;
        try {
            text = URLEncoder.encode(pager.getSearch(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        String apiURL = "https://openapi.naver.com/v1/search/shop.json?query=" + text + "&start=" + pager.getStartRow() 
        		+  "&display=" + pager.getPerPage();    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


        Map<String, String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = ApiCallManager.get(apiURL,requestHeaders);
        
        return responseBody;
    }


   

}

