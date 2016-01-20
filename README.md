# DemoCustomView2
---

踉踉跄跄中，终于完成了对Paint各种效果的练习。

Demo中的各种示例均是在练习【aige】写的[文章](http://blog.csdn.net/aigestudio/article/details/41316141)。下面简单罗列下Demo中涉及到的知识点：<br>

###1、矩阵

`关于矩阵不清楚的童鞋可以转到[wiki](https://zh.wikipedia.org/wiki/%E7%9F%A9%E9%98%B5)`

###2、ColorMatrixColorFilter

色彩矩阵过滤器，利用它可以实现很多美图秀秀中的效果，比如：变灰、变暗、颜色反转、老照片、高度对比等

###3、LightingColorFilter

`光照颜色过滤器，利用它可以实现的效果就像有色光照在物体上染色一样`

过滤掉绿色：<br>
mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
 
![lightcolorfilter](https://github.com/LeeeYou/DemoCustomView2/blob/master/lightcolorfilter.png)


###4、PorterDuffColorFilter

`混合颜色过滤器，可以通过指定一个颜色和一种模式，进行混合从而产生相应的效果`

红色+加深 混合：<br>
mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));

![porterduffcolorfilter](https://github.com/LeeeYou/DemoCustomView2/blob/master/porterduffcolorfilter.png)


###5、PorterDuffXfermode

这个是`最重量级 最重量级 最重量级`的东东了。ProterDuff是两个人名的组合: Tomas Proter和 Tom Duff. 他们是最早在SIGGRAPH上提出图形混合概念的大神级人物.有兴趣的童靴们可以自己查下并深入了解，在此不再做过多描述.

PorterDuffXfermode是一个非常强大的转换模式，通过它，可以使用图像合成的16条Porter-Duff规则的任意一条来控制Paint如何与已有的Canvas图像进行交互。

![PorterDuffXfermode](https://github.com/LeeeYou/DemoCustomView2/blob/master/porterduffxfermode2.jpg)

Demo中花了大量的篇幅练习和体会PorterDuffXfermode的强大，包括如下自定义view:
>
    PorterDuffView :基本练习
    DstInView：抠出美女轮廓
    DstOutView：挖出美女轮廓
    EraserView：橡皮擦练习
   
使用DST_IN抠出美女图像，去掉了周围的黄色和顶部的文字

![DST_IN美女练习前](https://github.com/LeeeYou/DemoCustomView2/blob/master/dst_in_%E7%BE%8E%E5%A5%B3%E7%BB%83%E4%B9%A0_%E5%89%8D.png)
![DST_IN美女练习后](https://github.com/LeeeYou/DemoCustomView2/blob/master/dst_in_%E7%BE%8E%E5%A5%B3%E7%BB%83%E4%B9%A0_%E5%90%8E.png)


利用Path绘制路径，采用DST_IN混合模式，完成橡皮擦效果

![eraserview](https://github.com/LeeeYou/DemoCustomView2/blob/master/eraserview.png)

