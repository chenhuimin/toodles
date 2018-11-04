package com.chm.toodles.zull.filter;

import com.chm.toodles.common.base.ResponseCode;
import com.chm.toodles.common.base.ResponseData;
import com.chm.toodles.common.util.IpUtils;
import com.chm.toodles.common.util.JsonUtils;
import com.chm.toodles.zull.conf.BasicConf;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class IpFilter extends ZuulFilter {

  @Autowired
  private BasicConf basicConf;

  public IpFilter() {
    super();
  }

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    String ip = IpUtils.getIpAddr(ctx.getRequest());
    if (StringUtils.isNotBlank(ip) && basicConf != null && basicConf.getIpStr().contains(ip)) {
      ctx.setSendZuulResponse(false);
      ResponseData data = ResponseData.fail("非法请求", ResponseCode.NO_AUTH_CODE.getCode());
      ctx.setResponseBody(JsonUtils.toJson(data));
      ctx.getResponse().setContentType("application/json; charset=utf-8");
      return null;
    }
    return null;
  }
}
