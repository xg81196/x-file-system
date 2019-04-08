package com.itgo.service.base.realize.apiimpl.base;

import com.itgo.bean.PageBean;
import com.itgo.service.base.api.base.BaseDicAPI;
import com.itgo.service.base.realize.bean.base.Dictionary;
import com.itgo.service.base.realize.service.DictionaryService;
import com.itgo.service.base.vo.base.BaseDicVO;
import com.itgo.utils.BeanCopyUtil;
import com.itgo.utils.ServiceResponse;
import com.itgo.utils.json.RequestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by xb
 * The file is [ BaseDicAPIImpl] on [ x-file-system ] project
 * The file path is com.itgo.service.base.realize.apiimpl.base.BaseDicAPIImpl
 *
 * @versio 1.0.0
 * @Author he ming xi
 * @date 2019/4/6 23:19
 * @description
 */
@RestController
@RequestMapping(value = "/base-dic")
public class BaseDicAPIImpl implements BaseDicAPI {


    @Autowired
    private DictionaryService dictionaryService;

    private static Logger logger = LoggerFactory.getLogger(BaseDicAPIImpl.class);


    @RequestMapping(value = "/find-page")
    public ServiceResponse<PageBean<BaseDicVO>> findByPage(@RequestBody RequestData<BaseDicVO> data) {
        ServiceResponse<PageBean<BaseDicVO>> response = new ServiceResponse<>();
        BaseDicVO vo = data.getReqData();
        if(vo == null){
            vo = new BaseDicVO();
            vo.setPageNum(1);
            vo.setPageSize(5);
        }
        try {
            Dictionary dictionary = BeanCopyUtil.copy(vo, Dictionary.class);
            PageBean<List<Dictionary>>  pageData = dictionaryService.findByPage(dictionary);
            List<BaseDicVO> voList = BeanCopyUtil.copyList(pageData.getResultData(), BaseDicVO.class);
            PageBean<BaseDicVO> pageBean = new PageBean<>();
            pageBean.setResultData(voList);
            pageBean.setPages(pageData.getPages());
            pageBean.setStartRow(pageData.getStartRow());
            pageBean.setPageNum(pageData.getPageNum());
            pageBean.setPageSize(pageData.getPageSize());
            pageBean.setTotal(pageData.getTotal());
            pageBean.setResultData(voList);
            response.setRetContent(pageBean);
            response.setRetMessage("success");
            response.setRetCode("200");
        }catch (Exception e){
            response.setRetMessage(e.getMessage()+",system error!");
            response.setException(e);
            response.setRetCode("500");
            return response;
        }
        return response;
    }

}
