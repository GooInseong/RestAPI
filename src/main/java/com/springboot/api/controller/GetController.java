package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    /*GET API 는 웹 애플리케이션 서버에서 값을 가져올때 사용하는 API 이다.*/
    @RequestMapping(value ="/hello",method = RequestMethod.GET)
    public String getHello(){
        return "HelloWorld";
    }

    @GetMapping(value="/name")
    public String getName(){    /*매개 변수가 없는 GET 메서드*/
        return"Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
        /*매개 변수가 있는 GET 메서드.
        GetMapping 어노테이션값으로 url 을 입력 할 때 중괄호를 활용하여 어느 위치에서 값을 받을지 표시.
        또, GetMapping 에 명시된 변수의 이름과 PathVariable 의 변수 명이 같아야함.*/
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
        /*만약  GetMapping 의 변수명과 PathVariable 의 변수명을 동일하게 맞추기 어렵다면
        * PathVariable에 ()를 열어 변수명을 지정해야 한다.*/
    }

    /*본 어노테이션은 Swagger 를 통해 대상 API 설명을 작성하기 위한 어노테이션이다.*/
    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getRequestParam1(@ApiParam(value="이름",required = true)
                                   /*ApiPram 은 매개변수에 대한 설명 및 설정을 위한 어노테이션이다.*/
                                       @RequestParam String name,
                                   @ApiParam(value="이메일",required = true)@RequestParam String email,
                                   @ApiParam(value="회사",required = true)@RequestParam String organization   ){
        return name+" "+email+ " "+organization;
        /*GET 요청을 구할때, 위처럼 url 경로상에 값을 담아 보내는 방법 외에도,
        * 쿼리 형식으로 값을 전달 할 수 있음. 경로 뒤에 ?와 {키}={값}&.. 의 형태로
        * 구성된 요청을 전송 할 수 있다. GetMapping 매소드 매개변수에 @RequestParam
        * 어노테이션을 사용하고 쿼리의 키값과 동일한 변수를 지정하면 된다.*/
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        StringBuilder sb= new StringBuilder();
        param.entrySet().forEach(map->{
            sb.append(map.getKey()+" : "+map.getValue()+"\n");
        });
        return sb.toString();
        /*만약 쿼리스트링에 어떤 값이 들어올지 모른다면 Map 객체를 활용하여 값을 받을 수 있다.*/
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

}
