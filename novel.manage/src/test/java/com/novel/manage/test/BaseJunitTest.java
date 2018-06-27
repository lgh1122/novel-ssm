package com.novel.manage.test;

import com.novel.common.pojo.TbNovel;
import com.novel.manage.storage.impl.KanShuZhongNovelStorageImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"}) 
public class BaseJunitTest {

    @Test
    public void testUpdateNovel() throws FileNotFoundException {
        KanShuZhongNovelStorageImpl processor = new KanShuZhongNovelStorageImpl();

        TbNovel novel = new TbNovel();
        novel.setLatestchapterid(28319322L);
        novel.setId(119134L);
        novel.setNetid(3L);

        novel.setTitle("大道朝天");
        novel.setLatestchaptername("第三千一百六十七章 数万年之后");
        processor.test(novel);
    }

}
