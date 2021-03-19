# demo

用chrome调试页面时，发现audio控件有时不能正常播放音频，控制台报错 Uncaught (in promise) DOMException；
解决方法如下：
在chrome的地址栏中输入：chrome://flags/#autoplay-policy，回车打开设置页面，在该设置改页面会看到黄色方框标记的字体：Autoplay policy ，该选项默认设置为Default，改为：No user gesture is required ，修改选项后页面下方会弹出个提示框，点击提示框上的“RELAUNCH NOW”即可。
该选项修改自动播放的政策，应该可以解决chrome下视频、音频无法正常自动播放的问题（当前调试的代码中，audio没有加autoplay的属性，是事件触发播放但没有正常播放，autoplay属性无效的情况并没有测试）。
之前视频无法自动播放是加了muted（静音播放）属性解决的，对于需要有声音的视频及音频来说，这个方法更适用吧
————————————————
版权声明：本文为CSDN博主「Mariosss」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Mariosss/article/details/87861167
