package com.it.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

@Component
@Api(value = "页面管理接口",description = "增删改查")
public interface UserSV {
    @ApiOperation("测试say")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",value = "",required = true,paramType = "",defaultValue ="int")})
    String say();
}
