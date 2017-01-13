# abstract
该项目主要演示如何一次性替换app全局字体,以及遇到的一些特殊情况.
## ReplaceFonts
---------------

> 关于我，欢迎关注  
  博客：[简书](http://www.jianshu.com/users/8d01db870d4a/timeline) 微信：[ben_said](279113482)  
 (如果你想打造个人品牌，把自己的介绍放在这里也是可以的)

（项目背景/作用介绍）

#### 示例图片:

### 特性
- app全局字体设置.
- 自定义字体替换的View和TextView,ToolBar子类.

### 原理说明



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
(1).将需要的字体ttf文件放置到assets目录下的,如/fonts/xxx.ttf
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step1.png)
		(2).在Application使用的Theme中添加标签<item name="android:typeface">monospace</item>
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step2.png)
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step3.png)
		(3).在Application中初始化字体文件,这里需要使用到第三方的工具类FontUtil
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step4.png)
		(4).如果使用到了ToolBar,用FontSystemToolBar替换，同时要通过paddingLeft来控制标题的左偏移量
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step6.png)
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step8.png)
		(5).如果使用到了自定义View,继承FontSystemview或通过以下方式修改自定义View的字体
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step5.png)
		(6).通过以上方式,基本完成了整个app字体的统一替换.		

### 注意事项

-注意,如果项目需要简繁体切换功能,切记不要在控件中直接使用繁体字源数据,否则无论是全局替换的方式还是自定义字体View控件,
	 都会导致简繁体不一致.
		![image](https://github.com/liangzhongtai/ReplaceFonts/blob/master/resultPic/system_step7.png)


## License

