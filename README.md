# springBoot_myBatis_shiro

## 说明
项目是将awesome-flask-webapp（python-flask写的，https://github.com/mapeimapei/awesome-flask-webapp）用java重构了一遍：

项目依然包括博客+宠物商店。

所以前台部分几乎没话精力，只是从之前的vueBlogMaster2.6.6 master上拉了一个java_branches分支改了改。https://github.com/mapeimapei/vueBlogMaster2.6.6

主要工作都在后端上，技术栈主要包含springBoot+MyBatis+JWT+shiro+fastJson

虽然目前主流的开发模式是前后台分离，但java的模板引擎，session，cookie还是要会的，所以，博客列表和详情页面用Thymeleaf实现了。只是简单实现了两个页面。但该有的还是有的。

## 后台管理包括博客的增删改查和宠物商店，纯粹的前后端分离。
参考过jeesite和一些推荐的结构布局，项目结构的布置也比较规范：

使用JWT+shiro授权和鉴权；

统一的异常封装；

restFul统一接口的封装；

练习并掌握了多种前后端对接访问传参方式，formdata,@RequestBody,@RequestParam,@PathVariable；

练习并掌握了多种情况的校验方式；

练习并掌握了fastJson的多种技术：json序列化和反序列化，FilterResult，和统一接口的封装；

练习并掌握了MyBatis XML映射，增删改查，动态语句，resultMap,map,一次执行多条语句等；


## 这个项目的git地址如下，喜欢可以拿去：
https://github.com/mapeimapei/springBoot_myBatis_shiro
