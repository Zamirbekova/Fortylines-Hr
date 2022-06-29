package com.example.fortylineshr.dto.mapper;

import com.example.fortylineshr.dto.HeadOfRequest;
import com.example.fortylineshr.dto.HeadOfResponse;
import com.example.fortylineshr.enums.Role;
import com.example.fortylineshr.model.AuthInfo;
import com.example.fortylineshr.model.HeadOf;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class HeadOfMapperImpl {
    public HeadOf create(HeadOfRequest headOfRequest) {
        if (headOfRequest == null) {
            return null;
        }
        HeadOf headOf = new HeadOf();
        headOf.setFirstName(headOfRequest.getFirstName());
        headOf.setLastName(headOfRequest.getLastName());

        AuthInfo authInfo = new AuthInfo();
        authInfo.setRole(Role.HEADOF);
        authInfo.setEmail(headOfRequest.getEmail());
        authInfo.setPassword(headOfRequest.getPassword());

        headOf.setAuthInfo(authInfo);
        return headOf;
    }

    public HeadOf update(HeadOf headOf, HeadOfRequest headOfRequest) {
        headOf.setFirstName(headOfRequest.getFirstName());
        headOf.setLastName(headOfRequest.getLastName());
        headOf.getAuthInfo().setRole(Role.HEADOF);
        headOf.getAuthInfo().setEmail(headOfRequest.getEmail());
        headOf.getAuthInfo().setPassword(headOfRequest.getPassword());
        return headOf;
    }

    public HeadOfResponse convert(HeadOf headOf) {
        HeadOfResponse headOfResponse = new HeadOfResponse();

        headOfResponse.setId(headOf.getId());
        headOfResponse.setFirstName(headOf.getFirstName());
        headOfResponse.setLastName(headOf.getLastName());
        headOfResponse.setEmail(headOf.getAuthInfo().getEmail());

        return headOfResponse;
    }

    public List<HeadOfResponse> deConvert(List<HeadOf> headOfs) {
        List<HeadOfResponse> headOfResponses = new ArrayList<>();
        for (HeadOf h : headOfs) {
            headOfResponses.add(convert(h));
        }
        return headOfResponses;
    }
}

