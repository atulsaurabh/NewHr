package com.poonamsk.newhr;

import android.content.Context;
import android.widget.Toast;

import com.technoride.erp.api.entity.Member;
import com.technoride.erp.api.process.MemberAction;
import com.technoride.erp.api.security.AuthResult;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class HRAppMemberProcess implements MemberAction
{

    Context context;

    @Override
    public AuthResult performLogin(Member member) {
        return null;
    }

    @Override
    public void addMember(Member member)
    {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity entity = restTemplate.postForEntity("http://192.168.0.103:8080/createmember", member, ResponseEntity.class);
        HttpStatus status=entity.getStatusCode();
        if(status == HttpStatus.FOUND)
        {
            Toast.makeText(context,  entity.getBody().toString(), Toast.LENGTH_LONG).show();

        }
        else
            if (status == HttpStatus.CREATED)
            {
                Toast.makeText(context,  entity.getBody().toString(), Toast.LENGTH_LONG).show();
            }
        // Create RestTemplate and call url /memberadd
        
    }
}
