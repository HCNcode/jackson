/*
 * 文件名：JacksonDemo.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月31日
 */

package jacksonTest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import jackson.entity.User;

public class JacksonDemo
{
    public static void main(String[] args) throws ParseException, IOException {
        User user = new User();
        user.setName("zhangsan");
        user.setEmail("zhangsan@163.com");
        user.setAge(20);
        user.setSex(true);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));
        
        User user2 = new User();
        user2.setName("zhangsan");
        user2.setEmail("zhangsan@163.com");
        user2.setAge(20);
        user2.setSex(false);
        
         dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1997-10-01"));
        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //设置反序列化时忽略不必要的属性
        //User类转JSON
        //输出结果：{"name":"zhangsan","age":20,"birthday":844099200000,"email":"zhangsan@163.com"}
        String json = mapper.writeValueAsString(user);
        
        /*File file = new File("file.txt");
        mapper.writeValue(file, user);
        */
        
        /*//JsonNode的方法
         System.out.println(json);
        JsonNode node = mapper.readTree(json);
        System.out.println(node.get("age").asInt());*/
        
        
      //转map
       /* Map m = mapper.readValue(json, Map.class); //json转换成map
        
        System.out.println(m.get("age"));*/
        
        /*Map<String,Object> map = new HashMap<String, Object>();
        map.put("user1", user);
        map.put("user2", user2);
        String jsonmap = mapper.writeValueAsString(map);
        System.out.println(jsonmap);
        JsonNode node = mapper.readTree(jsonmap);
        System.out.println(node.get("user1").toString());*/
        
        /*//反序列化
        String jsonString = "{\"name\":\"zhangsan\",\"age\":20,\"hhh\":\"zhangsan@163.com\"}";
        User userReturn = mapper.readValue(jsonString, User.class);
        System.out.println(userReturn);*/
        
        
        //Java集合转JSON
        //输出结果：[{"name":"zhangsan","age":20,"birthday":844099200000,"email":"zhangsan@163.com"}]
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        String jsonlist = mapper.writeValueAsString(users);
        System.out.println(jsonlist);
        
        User[] u = mapper.readValue(jsonlist, User[].class);
        for(User u1:u){
            System.out.println(u1.getEmail());
        }
        /*JsonNode node = mapper.readTree(jsonlist);
        for(JsonNode node1:node){
            System.out.println(node.get(0));
        }*/
        
        /*//反序列化时忽略不需要的字段
        String string ="{\"name\":\"zhangsan\",\"age\":21,\"email\":\"zhangsan@163.com\",\"sex\":true},\"email\":\"zhangsan@162.com\"";
        User user3 = mapper.readValue(string, User.class);
        System.out.println(user3);*/
        
        
        /*JavaType javaType = mapper.getTypeFactory().constructParametricType(  
            List.class, User.class);  
       List<User> me = mapper.readValue(jsonlist, javaType);
       System.out.println(me);*/
      
    }
}
