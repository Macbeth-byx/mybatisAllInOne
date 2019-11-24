package com.p2.springbootmybatis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.p2.springbootmybatis.dao.UserMapper;
import com.p2.springbootmybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootmybatisApplication {
    @Autowired
    UserMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmybatisApplication.class, args);
    }

    @GetMapping("/user/{id}")
    public JsonNode getUserById(@PathVariable int id){
        User byId = mapper.findById(id);
        ObjectNode jsonNodes = JsonNodeFactory.instance.objectNode();
        jsonNodes.put("name", byId.getName());
        return jsonNodes;
    }

    @PostMapping("/user/add")
    public JsonNode addUser(@RequestBody User user){
        try {
            int insert = mapper.insert(user);
            return JsonNodeFactory.instance.objectNode().put("message", "success");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonNodeFactory.instance.objectNode().put("message", "fail");
        }
    }

    @GetMapping("/user")
    public JsonNode getAllUser(){
        List<User> users = mapper.showUser();
        ArrayNode jsonNodes = JsonNodeFactory.instance.arrayNode();
        for (User user : users) {
            jsonNodes.addPOJO(user);
        }
        return jsonNodes;
    }
}
