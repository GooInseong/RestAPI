package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    /*PUT API는 웹 애플리케이션 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트 하는데 사용한다.*/

    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb= new StringBuilder();

        putData.entrySet().forEach(map->{
            sb.append(map.getKey()+" : "+map.getValue());
        });
        return sb.toString();
        /*PUT API 는 POST 메서드와 마찬가지로 HTTP Body 를 통해 값을 전달한다.*/
    }

    @PutMapping("/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
        /*본 메서드는 반환값이 String 이다.
        * memberDto에 정의되어 있는 toString()메서드 결과값이 반환된다.*/
    }

    @PutMapping("/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
        /*본 메서드는 반환값이 MemberDto 이다.
        * RestController 는 Controller 와 ResponseBody 가 결합된 어노테이션이다.
        * ResponseBody 는 자동으로 값을 JSON과 같은 형식으로 변환하여 전달한다.*/
    }

    @PutMapping("/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
        /*자바에는 HttpEntity 라는 클래스가 있다. ResponseEntity 와 ResquestEntity 는
        * HttpEntity 를 상속받아 구현한 클래스이다.
        * 그중 ResponseEntity 는 서버에 들어온 요청에 대해  응답데이터를 구성하여 보낼 수 있다.
        * 이 클래스를 활용하면 응답 코드 변경은 물론 Header 와 Body 를 쉽게 구성할 수 있다.*/
    }

}
