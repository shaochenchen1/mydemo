package com.example.scc.config;

import com.example.scc.entity.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@JsonComponent
public class UserJsonCustom {
    public static class Serializer extends JsonObjectSerializer<User> {

        @Override
        protected void serializeObject(User user, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeObjectField("id", user.getId());   //{"id","xxx"}
            jgen.writeObjectField("uname", user.getUsername());
            /*jgen.writeFieldName("");  单独写key
            jgen.writeObject();   单独写value
            */
            // 1. 一次查不出完整的数据返回给客户端， 需要根据需求去做一些个性化调整
            // 2. 根据不同的权限给他返回不同的序列化数据
        }
    }

    public static class Deserializer extends JsonObjectDeserializer<User> {

        @Override
        protected User deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
            User user = new User();
            user.setId(tree.findValue("id").asInt());

            return user;
        }
    }
}
