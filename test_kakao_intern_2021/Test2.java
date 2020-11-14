package test_kakao_intern_2021;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

// GET해서 json 데이터 접근해서 원하는 데이터 가져오고
// 페이지 수를 0 ~ total page만큼 돌려서 parentId가 일치하는 것들의 속도?를 찾아서
// 평균 속도를 구하는 것..
// GET통신을 할 수 있고, json data를 다루는 방법을 잘 안다면 어렵지 않게 풀었을 것 같다.
// 19, 20 카카오 2차 블라인드 테스트는 http통신을 했다고 들었다. 이런식의 문제가 나오지 않았을까 예상해본다.
public class Test2 {
    public static void main(String[] args) throws IOException {
        String statusQuery = "RUNNING";
        int parentId = 7;

        String str = "https://jsonmock.hackerrank.com/api/iot_devices/search?status="
                + statusQuery + "&page=" + parentId;
        URL url = new URL(str);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();



    }
}
