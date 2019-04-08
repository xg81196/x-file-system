package com.itgo.service.base.realize.service.impl;

import com.itgo.service.base.realize.bean.base.BookInfo;
import com.itgo.service.base.realize.service.BookInfoService;
import com.itgo.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookInfoServiceImpl extends BaseServiceImpl<BookInfo> implements BookInfoService {
//
//    @Autowired
//    private BookInfoMapper bookInfoMapper;
//
//    @Override
//    @Transactional
//    public List<BookInfo> findBooks() {
//        return bookInfoMapper.findBooks();
//    }
//
//    /**
//     * 分页查询
//     * @param bookInfo
//     * @return
//     */
//    @Override
//    @Transactional
//    public PageBean<List<BookInfo>> findByPage(BookInfo bookInfo) {
//        List<BookInfo> listData = bookInfoMapper.findByPage(bookInfo);
//        Integer count = bookInfoMapper.count();
//        PageBean pageBean = new PageBean();
//        pageBean.setTotal(count);
//        pageBean.setPageSize(bookInfo.getPageSize());
//        pageBean.setPageNum(bookInfo.getPageNum());
//        //总页数
//        Long pages = pageBean.getTotal()%pageBean.getPageSize()!=0?pageBean.getTotal()/pageBean.getPageSize()+1:pageBean.getTotal()/pageBean.getPageSize();
//        pageBean.setPages(pages);
//        pageBean.setResultData(listData);
//        return pageBean;
//    }
//
//    /**
//     * 新增
//     * @param bookInfo
//     * @return
//     */
//    public Integer save(BookInfo bookInfo){
//        return null;
//    }

}
