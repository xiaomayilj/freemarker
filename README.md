## FreeMarker使用
本工程使用freemarker生成word文档，/classes/templates目录下面存放了模板文件，gb.ftl和questtitle.ftl为两个模板文件，其中gb.ftl模板可以接收list对象在word文档中生成多个表格
### 比较容易踩的坑：
1.如果要在其他工程中添加这个自动生成word文档的功能,比较容易踩的坑就是ftl模板的加载，模板相对于.class文件的路径一定要确定好
### 一些比较好的教程整理：
1. [FreeMarker实例教程](http://blog.csdn.net/chenghui0317/article/details/7832474)
2. [FreeMarker学习笔记](http://blog.csdn.net/luowangcan/article/details/71404205)
3. [模板中包含图片和表格](http://blog.csdn.net/w2393040183/article/details/51096994)
4. [WEB项目中使用freemarker生成word文档](http://blog.csdn.net/jackfrued/article/details/39449021)
5. [FreeMarker中list的遍历](http://blog.csdn.net/codepython/article/details/46290005)
6. [FreeMarker中map的遍历](http://blog.csdn.net/mexican_jacky/article/details/50638443):
