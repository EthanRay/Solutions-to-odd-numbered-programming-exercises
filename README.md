# Solutions-to-odd-numbered-programming-exercises
"introduction to java programming" is a great Java book for learning, but there are only solutions to even-numbered programming exercises, here are some solutions to odd-number programming by me, welcome to fork!
<p style="margin: 0px; padding: 0px 0px 15px; word-wrap: break-word; color: rgb(73, 73, 73); font-family: Helvetica, Arial, sans-serif;">
	<h1 style="font-size: 25px; line-height: 1.25; box-sizing: border-box; margin-right: 0px; margin-bottom: 16px; margin-left: 0px; padding-bottom: 0.3em; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(234, 236, 239); color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol'; margin-top: 0px !important;">
		Introducing to Java Programming&nbsp;
	</h1>
	<h1 style="box-sizing: border-box; margin-right: 0px; margin-bottom: 16px; margin-left: 0px; padding-bottom: 0.3em; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(234, 236, 239); color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol'; margin-top: 0px !important;">
		<span style="font-size: 50px; line-height: 62.5px;">Java程序设计奇数题解答</span><span style="font-size: 25px; line-height: 1.25;">&nbsp;</span>
	</h1>
	<hr style="font-size: 16px; line-height: 24px; box-sizing: content-box; height: 0.25em; overflow: hidden; margin: 24px 0px; border: 0px; border-image-source: initial; border-image-slice: initial; border-image-width: initial; border-image-outset: initial; border-image-repeat: initial; padding: 0px; color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol'; background-image: initial; background-attachment: initial; background-color: rgb(225, 228, 232); background-size: initial; background-origin: initial; background-clip: initial; background-position: initial; background-repeat: initial;" />
</p>
<p style="font-size: 16px; line-height: 24px; box-sizing: border-box; margin-top: 0px; margin-bottom: 16px; color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';">
	<span style="color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; line-height: 19.4400005340576px;">此书实用性远胜thinking in java。华裔写的书，显浅的语法，但并不代表没有深度。各位读者，还是读英文版吧，通俗易懂，中文学java只会让你越来越脱离java思想。那么到时候，你就是think in chinese java，not java！课后习题同样很有挑战性，涵盖了Java一些基本的技术，这些技术在实际项目中必不可缺，在算法与数据结构部分可以分析得也很清楚。然而课后习题只有偶数部分提供了官方答案（官方答案代码很规范，值得学习），这里提供了部分奇数题解答，日常更新，欢迎Fork和Watch。</span>
</p>
<h3 style="font-size: 1.25em; line-height: 1.25; box-sizing: border-box; margin-top: 24px; margin-bottom: 16px; color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';">
	<a id="user-content-功能概述" class="anchor" href="https://github.com/Tencent/ncnn#功能概述" aria-hidden="true" style="box-sizing: border-box; color: rgb(3, 102, 214); text-decoration: none; float: left; padding-right: 4px; margin-left: -20px; line-height: 1; background-color: transparent;"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewbox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>功能概述
</h3>
<ul style="font-size: 16px; line-height: 24px; box-sizing: border-box; padding-left: 2em; margin-top: 0px; margin-bottom: 16px; color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';">
	<li style="box-sizing: border-box;">
		提供.java格式代码文件，无须反编译
	</li>
	<li style="box-sizing: border-box; margin-top: 0.25em;">
		无任何第三方库依赖
	</li>
	<li style="box-sizing: border-box; margin-top: 0.25em;">
		纯Java实现，跨平台
	</li>
	<li style="box-sizing: border-box; margin-top: 0.25em;">
		级良心优化，计算速度快
	</li>
	<li style="box-sizing: border-box; margin-top: 0.25em;">
		精细结构设计，便于阅读与维护
	</li>
	<li style="box-sizing: border-box; margin-top: 0.25em;">
		全面使用javaFX与GUI设计
	</li>
</ul>
<hr style="font-size: 16px; line-height: 24px; box-sizing: content-box; height: 0.25em; overflow: hidden; margin: 24px 0px; border: 0px; border-image-source: initial; border-image-slice: initial; border-image-width: initial; border-image-outset: initial; border-image-repeat: initial; padding: 0px; color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol'; background-image: initial; background-attachment: initial; background-color: rgb(225, 228, 232); background-size: initial; background-origin: initial; background-clip: initial; background-position: initial; background-repeat: initial;" />
<h3 style="font-size: 1.25em; line-height: 1.25; box-sizing: border-box; margin-top: 24px; margin-bottom: 16px; color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol';">
	<a id="user-content-license" class="anchor" href="https://github.com/Tencent/ncnn#license" aria-hidden="true" style="box-sizing: border-box; color: rgb(3, 102, 214); text-decoration: none; float: left; padding-right: 4px; margin-left: -20px; line-height: 1; background-color: transparent;"><svg aria-hidden="true" class="octicon octicon-link" height="16" version="1.1" viewbox="0 0 16 16" width="16"><path fill-rule="evenodd" d="M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z"></path></svg></a>License
</h3>
<p style="font-size: 16px; line-height: 24px; box-sizing: border-box; margin-top: 0px; color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol'; margin-bottom: 0px !important;">
	<span style="color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol'; font-size: 16px; line-height: 24px;">This project is licensed under the terms of the MIT license.</span>
</p>
<br />
