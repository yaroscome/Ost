package com.yrs.ost;

import android.app.Application;
import android.util.Log;

import com.yrs.ost.commons.SimpleInjection;
import com.yrs.ost.networking.connectors.SkylarkConnector;
import com.yrs.ost.networking.responses.SkylarkGetRootSetResponse;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yaros on 03/03/16.
 */
public class EndpointTest {

    SkylarkConnector skylarkConnector;
    SimpleInjection simpleInjection;

    @Before
    public void setUp() {
        simpleInjection = new SimpleInjection();
        skylarkConnector = simpleInjection.getSkylarkConnector();
    }

    @Test
    public void endpoint_isAvailable() {
        Call<SkylarkGetRootSetResponse> rootSetCall = skylarkConnector.getRootSet();

        try {
            int reponseCode = rootSetCall.execute().code();
            Assert.assertEquals(200, reponseCode);

        } catch (IOException e) {
            Assert.fail();
        }

//        rootSetCall.enqueue(new Callback<SkylarkGetRootSetResponse>() {
//            @Override
//            public void onResponse(Call<SkylarkGetRootSetResponse> call, Response<SkylarkGetRootSetResponse> response) {
//                System.out.println("OK");
//                Assert.assertEquals(300, response.code());
//            }
//
//            @Override
//            public void onFailure(Call<SkylarkGetRootSetResponse> call, Throwable t) {
//                System.out.println("NOT OK");
//                Assert.fail();
//            }
//        });
    }
}
