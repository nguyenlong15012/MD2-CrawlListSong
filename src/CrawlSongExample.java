import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            //cloae scanner;
            sc.close();

            //remove all new line
            content = content.replaceAll("\\n+", "");

            //Lọc thông tin nội dung content lấy đc trong tag a chứa class name_song và In ra danh sách
            //regex
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()){
                System.out.println(m.group(1));
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
