package com.maodun.mybatisplus.ctl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.maodun.mybatisplus.mapper.UserMapper;
import com.maodun.mybatisplus.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserCtl {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/all")
    public ResponseEntity<JsonNode> getAll(){
        List<User> users = userMapper.selectList(null);
        ArrayNode jsonNodes = JsonNodeFactory.instance.arrayNode();
        for (User user : users) {
            jsonNodes.addPOJO(user);
        }
        return ResponseEntity.status(200).body(jsonNodes);
    }
}
