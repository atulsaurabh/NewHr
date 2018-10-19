package com.poonamsk.newhr;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.technoride.erp.api.entity.Member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;



public class MemberAddAsyncTask extends AsyncTask<Member, Integer, Void> {
    Context context;
    @Override
    protected Void doInBackground(Member... members)
    {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<String> entity = restTemplate.postForEntity("http://192.168.0.105:8080/createmember", members[0], String.class);
        HttpStatus status=entity.getStatusCode();
        if(status == HttpStatus.FOUND)
        {
            Toast.makeText(null,  entity.getBody(), Toast.LENGTH_LONG).show();
        }
        else
        if (status == HttpStatus.CREATED)
        {
            Toast.makeText(context,  entity.getBody(), Toast.LENGTH_LONG).show();
        }
    return null;
    }
}
