package com.example.bootdemo1.controller;

import com.example.bootdemo1.goal.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RequestController {
    @RequestMapping("/recommend")
    public Result recommend() {
        Result result = new Result();

        // 创建一个装Recommend对象的List集合
        List<Recommend> recommendList = new ArrayList<>();

        // 向List集合中添加Recommend对象
        Recommend r1 = new Recommend();
        r1.setID(1);
        r1.setImage("http://192.168.199.146:8080/file/clothes/1.jpg");

        r1.setDesc("女士优质双排口西装套装裙");
        r1.setPrice(230.20f);
        r1.setSaleNumber(21340);
        recommendList.add(r1);

        Recommend r2 = new Recommend();
        r2.setID(2);
        r2.setImage("http://192.168.199.146:8080/file/clothes/2.jpg");
        r2.setDesc("女士灰麻色高级小香风短圆领外套");
        r2.setPrice(890.10f);
        r2.setSaleNumber(15320);
        recommendList.add(r2);


        Recommend r3 = new Recommend();
        r3.setID(3);
        r3.setImage("http://192.168.199.146:8080/file/clothes/3.jpg");
        r3.setDesc("男士看似是衬衫实际是鹅绒服轻薄舒适");
        r3.setPrice(1199.09f);
        r3.setSaleNumber(1830);
        recommendList.add(r3);

        Recommend r4 = new Recommend();
        r4.setID(4);
        r4.setImage("http://192.168.199.146:8080/file/clothes/4.jpg");
        r4.setDesc("男士棕色亮面皮衣夹克帅气有型");
        r4.setPrice(370.99f);
        r4.setSaleNumber(2601);
        recommendList.add(r4);

        Recommend r5 = new Recommend();
        r5.setID(5);
        r5.setImage("http://192.168.199.146:8080/file/clothes/5.jpg");
        r5.setDesc("儿童薄羽绒外套藏青色加橘色点缀");
        r5.setPrice(348.80f);
        r5.setSaleNumber(1985);
        recommendList.add(r5);

        Recommend r6 = new Recommend();
        r6.setID(6);
        r6.setImage("http://192.168.199.146:8080/file/clothes/6.jpg");
        r6.setDesc("童趣轻羽绒外套戴帽杏色卡通印花");
        r6.setPrice(280.60f);
        r6.setSaleNumber(2457);
        recommendList.add(r6);


        // 将List集合设置到Result对象的data属性中
        result.setCode(200);
        result.setMessage("success");
        result.setData(recommendList);


        return result;
    }
}