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
        novel.setLatestchapterid(28307845L);
        novel.setId(1465L);
        novel.setNetid(3L);

        novel.setTitle("无敌天下");
        novel.setLatestchaptername("第三千一百六十三章 黄龙套装四件");
        processor.test(novel);
    }

}
