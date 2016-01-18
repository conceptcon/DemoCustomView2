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