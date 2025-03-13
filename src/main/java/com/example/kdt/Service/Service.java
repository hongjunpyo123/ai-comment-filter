package com.example.kdt.Service;

import com.example.kdt.Common.util.Utility;
import com.example.kdt.Common.util.response.ResponseDto;
import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@org.springframework.stereotype.Service
public class Service {
    private final AnthropicChatModel chatModel; //챗봇 관련 객체

    @Autowired
    public Service(AnthropicChatModel chatModel) { //챗봇 생성자 주입
        this.chatModel = chatModel;
    }

    public ResponseEntity<?> sendChatBot(String chatBotMessage){
        try{ //응답에 실패했을 경우 예외처리
            String responseMessage = chatModel.call(Utility.PROMPT + "/채팅 : " +chatBotMessage);
            String responseMessage2;
            if(Integer.parseInt(responseMessage) <= 3) {
                return ResponseEntity.ok(ResponseDto.response(HttpStatus.OK, "위험도가 3점 이하 입니다", responseMessage, null));
            } else{
                responseMessage2 = chatModel.call(Utility.PROMPT2 + "/채팅 : " +chatBotMessage);
                return ResponseEntity.ok(ResponseDto.response(HttpStatus.OK, "위험도가 4점 이상입니다", responseMessage, responseMessage2));
            }
        } catch (Exception e){
            return ResponseEntity.ok(ResponseDto.response(HttpStatus.BAD_REQUEST, "api키가 유효하지 않을 수 있습니다.", null, null));
        }
    }
}
