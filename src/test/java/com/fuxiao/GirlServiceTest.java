package com.fuxiao;

import com.fuxiao.domain.Girl;
import com.fuxiao.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create by FuXiao on 2018/7/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void getOneTest() {
        Girl girl = girlService.getOne(7);
        Assert.assertEquals(new Integer(11), girl.getAge());
    }
}
