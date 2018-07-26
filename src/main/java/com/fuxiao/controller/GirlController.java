package com.fuxiao.controller;

import com.fuxiao.domain.Result;
import com.fuxiao.repository.GirlRepository;
import com.fuxiao.service.GirlService;
import com.fuxiao.domain.Girl;

import com.fuxiao.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 获取女生列表
     *
     * @return
     */
    @GetMapping(value = "/girlList")
    public List<Girl> girlList() {
        logger.info("getGirlList");

        return girlRepository.findAll();
    }

    /**
     * 新增女生
     *
     * @return
     */
    @PostMapping(value = "/insertGirl")
    public Result<Girl> insertGirl(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtils.success(girlRepository.save(girl));
    }

    /**
     * 通过id查询一个女生
     *
     * @param id
     *
     * @return
     */
    @GetMapping(value = "/searchGirl/{id}")
    public Girl serchGirl(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).orElse(null);
    }

    /**
     * 通过id修改一个女生
     *
     * @param
     *
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public Girl update(@PathVariable("id") Integer id,
                          @RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = girlRepository.findById(id).orElse(null);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 根据id删除一个女生
     *
     * @param id
     *
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /**
     * 插入两个女生
     */
    @PostMapping(value = "/girl/two")
    public void insertTwo() {
        girlService.insertTwo();
    }

    /**
     * 判断女生的年龄
     */
    @GetMapping(value = "/girl/age/{id}")
    public void judgment(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
