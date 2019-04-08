package com.itgo.web.controller.base;

import com.itgo.bean.PageBean;
import com.itgo.service.base.api.base.BaseDicAPI;
import com.itgo.service.base.vo.base.BaseDicVO;
import com.itgo.utils.ServiceResponse;
import com.itgo.utils.json.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by xb
 * The file is [ BaseDicController] on [ x-file-system ] project
 * The file path is BaseDicController
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/7 18:42
 * @description
 */
@RestController
@RequestMapping("/base-dic")
public class BaseDicController {

    @Autowired
    private BaseDicAPI baseDicAPI;

    @RequestMapping(value = "/find-page",method = RequestMethod.POST)
    public ServiceResponse<PageBean<BaseDicVO>> findByPage(@RequestBody RequestData<BaseDicVO> vo) {
        ServiceResponse<PageBean<BaseDicVO>> response = baseDicAPI.findByPage(vo);
        return response;
    }
}
