package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    /*DELETE API 는 웹 애플리케이션 서버를 거쳐 데이터 베이스 등의 저장소에 리소스를 삭제 할 때 사용한다.*/

    @DeleteMapping(value = "/{valiable}")
    public String DeleteVariable(@PathVariable String valiable){
        return valiable;
    }

    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return "email:"+email;
    }

}
