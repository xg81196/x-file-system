package com.itgo.service.base.api.base;

import com.itgo.bean.PageBean;
import com.itgo.service.base.vo.base.BaseDicVO;
import com.itgo.utils.ServiceResponse;
import com.itgo.utils.json.RequestData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Create by xb
 * The file is [ BaseDicAPI] on [ x-file-system ] project
 * The file path is com.itgoservice.base.api.BaseDicAPI
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/6 22:32
 * @description
 *      字典表
 */
@FeignClient(value = "${server.name.base}")
public interface BaseDicAPI {

    String PREFIX_URL = "/base-dic";

    /**
     * 分页查询
     * @param vo
     * @return
     */
    @RequestMapping(value = PREFIX_URL+"/find-page",method = RequestMethod.POST)
    ServiceResponse<PageBean<BaseDicVO>> findByPage(RequestData<BaseDicVO> vo);

}
