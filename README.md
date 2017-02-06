# abstract
该项目主要演示如何一次性替换app全局字体,以及遇到的一些特殊情况.
## ReplaceFonts
---------------

> 关于我，欢迎关注
  博客：[简书](http://www.jianshu.com/users/8d01db870d4a/timeline) 微信：[lzt橘子](18520660170)

（项目背景/作用介绍）

#### 示例图片:

### 特性
- app全局字体设置.
- 自定义字体替换的View和TextView,ToolBar子类.

### 原理说明

替换app全局字体利用了反射的方式,该方法优点是使用简单，并且不会对app运行的流畅性影响很小，缺点是会占用一部分运行内存,并且字体文件不能作
为压缩文件打包,因为需要在Application初始化时就读取assets目录里的字体文件,而我们知道assets目录是没有具体绝对路径的。
核心方法如下图，android系统的Typeface.MONOSPACE变量对应的字体，只要利用反射改变这个变量指向的字体对象即可.
![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_theory1.png)

自定义字体控件的原理就更简单了,
无论是是继承自非TextView的自定义控件，需要设置Paint对象的Typeface,还是继承自TextView的自定义控件,则可以利用替换app全局字体的方式,
也可以单独设置其Typeface.建议设置该Typeface为自定义控件的静态成员,否则多次初始化字体文件是一件很费性能的事情;
### 下载安装
Project_Gradle
``` xml
allprojects {
		    repositories {
			    maven { url 'https://jitpack.io' }
		    }
	}
```
App_Gradle:
``` xml
dependencies {
	        compile 'com.github.liangzhongtai:ReplaceFonts:-SNAPSHOT'
	}
```

### 使用方法

## 1.全局字体设置

(1).将需要的字体ttf文件放置到assets目录下的,如/fonts/xxx.ttf.


![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step1.png)

(2).在Application使用的Theme中添加标签<item name="android:typeface">monospace</item>.


![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step2.png)

![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step3.png)

(3).在Application中初始化字体文件,这里需要使用到第三方的工具类FontUtil.

![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step4.png)

(4).如果使用到了ToolBar,用FontSystemToolBar替换，同时要通过paddingLeft来控制标题的左偏移量.

![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step6.png)

![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step8.png)

(5).如果使用到了自定义View,继承FontSystemview或通过以下方式修改自定义View的字体.

![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step5.png)

(6).通过以上方式,基本完成了整个app字体的统一替换.

## 2.自定义字体View
(1).创建View的子类,通过paint.setTypeface(typeface)方法改变字体,注意同一种字体只需读取一次，因为字体读取比较耗费时间并且会占用大量内存.

![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/free_step1.png)

(2).创建TextView的子类,通过TextView的setTypeface(typeface)方法来改变字体,注意事项同上.

![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/free_step2.png)



### 注意事项

-注意,如果项目需要简繁体切换功能,切记不要在控件中直接使用繁体字源数据,否则无论是全局替换的方式还是自定义字体View控件,
	 都会导致简繁体不一致.
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step7.png)


## License

