package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb= new StringBuilder();

        postData.entrySet().forEach(map->{
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return sb.toString();
    
        /*RequestBody 는 HTTP 에 Body 내용을 해당 어노테이션이 저장된 객체에 매핑하는 역할을 함*/
    }

    @PostMapping("/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
        /* Map 객체는 요청을 통해 어떤 값이 들어오게 될지 특정하기 어려울때 사용한다.
        * 요청 메세지에 들어갈 값이 정해져 있다면 매개변수로 받아 올 수 있다.*/
    }
    
}
