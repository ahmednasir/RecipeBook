package com.recipebook.utils;

import com.recipebook.entity.ResponseBody;

public class BuildResponseMesage {

    public ResponseBody getSuccessMessage(){
        return new ResponseBody(200, "Success");
    }

    public ResponseBody getBadRequestMesage(){
        return new ResponseBody(400, "Bad Request");
    }

    public ResponseBody getInternalServerErrorMesage(){
        return new ResponseBody(500, "InternalServerError");
    }
}
