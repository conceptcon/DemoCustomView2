# DemoCustomView2

###LightingColorFilter效果图

过滤掉绿色：<br>
mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
 
![lightcolorfilter](https://github.com/LeeeYou/DemoCustomView2/blob/master/lightcolorfilter.png)

---

###PorterDuffColorFilter效果图<br>
 
红色+加深 混合：<br>
mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));

![porterduffcolorfilter](https://github.com/LeeeYou/DemoCustomView2/blob/master/porterduffcolorfilter.png)

---

###PorterDuffXfermode效果图
![porterduffxfermode](https://github.com/LeeeYou/DemoCustomView2/blob/master/porterduffxfermode.png)

---

###DST_IN美女练习

使用DST_IN抠出美女图像，去掉了周围的黄色和顶部的文字

![DST_IN美女练习前](https://github.com/LeeeYou/DemoCustomView2/blob/master/dst_in_%E7%BE%8E%E5%A5%B3%E7%BB%83%E4%B9%A0_%E5%89%8D.png)
![DST_IN美女练习后](https://github.com/LeeeYou/DemoCustomView2/blob/master/dst_in_%E7%BE%8E%E5%A5%B3%E7%BB%83%E4%B9%A0_%E5%90%8E.png)