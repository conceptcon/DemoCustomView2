# DemoCustomView2

踉踉跄跄中，终于完成了对Paint各种效果的练习。

收获非常多，对于Paint的各种过滤和混合效果，不再那么含糊和模棱两可，同时加深了对于矩阵的理解。

Demo中的各种示例均是在练习【aige】写的[文章](http://blog.csdn.net/aigestudio/article/details/41316141)。下面简单罗列下Demo中涉及到的知识点：<br>

## 1、矩阵

关于矩阵不清楚的童鞋可以转到[wiki](https://zh.wikipedia.org/wiki/%E7%9F%A9%E9%98%B5)

## 2、ColorMatrixColorFilter

色彩矩阵过滤器，利用它可以实现很多美图秀秀中的效果，比如：变灰、变暗、颜色反转、老照片、高度对比等

![变暗](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/colormatrix_%E5%8F%98%E6%9A%97.png)
![变灰](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/colormatrix_%E5%8F%98%E7%81%B0.png)
![反相效果](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/colormatrix_%E5%8F%8D%E7%9B%B8.png)
![红蓝色相互变换](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/colormatrix_%E7%BA%A2%E8%93%9D%E8%89%B2%E4%BA%92%E7%9B%B8%E5%8F%98%E6%8D%A2.png)
![老照片效果](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/colormatrix_%E8%80%81%E7%85%A7%E7%89%87.png)
![去色后高度对比](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/colormatrix_%E5%8E%BB%E8%89%B2%E5%90%8E%E9%AB%98%E5%BA%A6%E5%AF%B9%E6%AF%94.png)
![饱和度对比度加强](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/colormatrix_%E9%A5%B1%E5%92%8C%E5%BA%A6%E5%AF%B9%E6%AF%94%E5%BA%A6%E5%8A%A0%E5%BC%BA.png)

## 3、LightingColorFilter

`光照颜色过滤器，利用它可以实现的效果就像有色光照在物体上染色一样`

过滤掉绿色：<br>
mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
 
![lightcolorfilter](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/lightcolorfilter.png)


## 4、PorterDuffColorFilter

`混合颜色过滤器，可以通过指定一个颜色和一种模式，进行混合从而产生相应的效果`

红色+加深 混合：<br>
mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));

![porterduffcolorfilter](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/porterduffcolorfilter.png)


## 5、PorterDuffXfermode

这个是`最重量级 最重量级 最重量级`的东东了。ProterDuff是两个人名的组合: Tomas Proter和 Tom Duff. 他们是最早在SIGGRAPH上提出图形混合概念的大神级人物.有兴趣的童靴们可以自己查下并深入了解，在此不再做过多描述.

PorterDuffXfermode是一个非常强大的转换模式，通过它，可以使用图像合成的16条Porter-Duff规则的任意一条来控制Paint如何与已有的Canvas图像进行交互。

![PorterDuffXfermode](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/porterduffxfermode2.jpg)

Demo中花了大量的篇幅练习和体会PorterDuffXfermode的强大，包括如下自定义view:
>
    PorterDuffView :基本练习
    DstInView：抠出美女轮廓
    DstOutView：挖出美女轮廓
    EraserView：橡皮擦练习
    
基本练习

![DST_IN效果](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/porterduffxfermode.png)


使用DST_IN抠出美女图像，去掉了周围的黄色和顶部的文字

![DST_IN美女练习前](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/dst_in_%E7%BE%8E%E5%A5%B3%E7%BB%83%E4%B9%A0_%E5%89%8D.png)
![DST_IN美女练习后](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/dst_in_%E7%BE%8E%E5%A5%B3%E7%BB%83%E4%B9%A0_%E5%90%8E.png)


利用Path绘制路径，采用DST_IN混合模式，完成橡皮擦效果

![eraserview](https://github.com/LeeeYou/DemoCustomView2/blob/master/effectPicture/eraserview.png)


---

最后感谢[【aige】](http://blog.csdn.net/aigestudio/article/details/41316141) 的高质量文章