package oneDailyQuestion.Solution0025.java;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String, String> a = new HashMap<>();
        a.put("code", "200");
        a.put("message", "1111");
        a.put("success", "true");
        List<Map<String, String>> bb = new ArrayList<>();
        bb.add(a);
        System.out.println(11%10 == 0? 10/10 : 10/10+1);
        String b = "aaa bbb  ccc";
        System.out.println(b.split("\\s+").length);
        String c = "{\"data\":{\"shipAttach\":[{\"emsListNo\":\"\",\"attachType\":\"提运单/合同/发票箱单/报关单/税单/情况说明/其它/原产地证（类型可代码传输，需协定规则）\",\"attachName\":\"完整的文件名\",\"attachFlow\":\"base64加密\"}]}}";
    }
}

//    public String upload(MultipartFile uploadFile) {
//        String filename = UUID.randomUUID().toString().replace("-", "");
//        String path = ossPathProperties.getPath();
//        // 判断UUID是否重复
//        while (new File(path + File.separator + filename).exists()) {
//            filename = UUID.randomUUID().toString().replace("-", "");
//        }
//        try (InputStream inputStream = uploadFile.getInputStream()) {
//            new File(path).mkdirs();
//            OutputStream out = new FileOutputStream(path + File.separator + filename);
//            IOUtils.copy(inputStream, out);
//            IOUtils.closeQuietly(inputStream);
//            out.close();
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//            throw new RuntimeException("oss文件上传失败");
//        }
//        return filename;
//    }
