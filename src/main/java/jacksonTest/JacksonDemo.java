/*
 * �ļ�����JacksonDemo.java
 * ��Ȩ��Copyright by www.bonc.com.cn
 * ������
 * �޸��ˣ�HCN
 * �޸�ʱ�䣺2017��7��31��
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
         * ObjectMapper��JSON�����ĺ��ģ�Jackson������JSON����������ObjectMapper��ʵ�֡�
         * ObjectMapper�ж��JSON���л��ķ��������԰�JSON�ַ�������File��OutputStream�Ȳ�ͬ�Ľ����С�
         * writeValue(File arg0, Object arg1)��arg1ת��json���У������浽arg0�ļ��С�
         * writeValue(OutputStream arg0, Object arg1)��arg1ת��json���У������浽arg0������С�
         * writeValueAsBytes(Object arg0)��arg0ת��json���У����ѽ��������ֽ����顣
         * writeValueAsString(Object arg0)��arg0ת��json���У����ѽ��������ַ�����
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); //���÷����л�ʱ���Բ���Ҫ������
        //User��תJSON
        //��������{"name":"zhangsan","age":20,"birthday":844099200000,"email":"zhangsan@163.com"}
        String json = mapper.writeValueAsString(user);
        
        /*File file = new File("file.txt");
        mapper.writeValue(file, user);
        */
        
        /*//JsonNode�ķ���
         System.out.println(json);
        JsonNode node = mapper.readTree(json);
        System.out.println(node.get("age").asInt());*/
        
        
      //תmap
       /* Map m = mapper.readValue(json, Map.class); //jsonת����map
        
        System.out.println(m.get("age"));*/
        
        /*Map<String,Object> map = new HashMap<String, Object>();
        map.put("user1", user);
        map.put("user2", user2);
        String jsonmap = mapper.writeValueAsString(map);
        System.out.println(jsonmap);
        JsonNode node = mapper.readTree(jsonmap);
        System.out.println(node.get("user1").toString());*/
        
        /*//�����л�
        String jsonString = "{\"name\":\"zhangsan\",\"age\":20,\"hhh\":\"zhangsan@163.com\"}";
        User userReturn = mapper.readValue(jsonString, User.class);
        System.out.println(userReturn);*/
        
        
        //Java����תJSON
        //��������[{"name":"zhangsan","age":20,"birthday":844099200000,"email":"zhangsan@163.com"}]
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
        
        /*//�����л�ʱ���Բ���Ҫ���ֶ�
        String string ="{\"name\":\"zhangsan\",\"age\":21,\"email\":\"zhangsan@163.com\",\"sex\":true},\"email\":\"zhangsan@162.com\"";
        User user3 = mapper.readValue(string, User.class);
        System.out.println(user3);*/
        
        
        /*JavaType javaType = mapper.getTypeFactory().constructParametricType(  
            List.class, User.class);  
       List<User> me = mapper.readValue(jsonlist, javaType);
       System.out.println(me);*/
      
    }
}
