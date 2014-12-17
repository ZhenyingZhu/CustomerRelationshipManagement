# 新加的部分内容

CRM

1. RabbitMQ && SNS

	先改了一个页面，就是CusCreate.jsp , CusCreateSucc.jsp 那个文件修改了，因为我看Piazza上面貌似说只用考虑这种情况通知agent即可。 然后里面的EmitLogTopic.send; ReceiveLogsTopic.receive; SimpleNotificationService.send 的Java程序都在Java Resources里面

2. Pagination 做了个example , 就是那个Try.jsp

3. REST, 之前传了。。。但是没有和在现在的project里，还没想到怎么弄方便，只是在另外一个project里试了试



Commerce App

1. 用了S3， DynamoDB
   就做了一个最简单的example 分别是CommerceHome.jsp, facebook.jsp
   DynamoDB的Java程序也在Java Resources里面

2. Redis 还没做






Notice

1. CRM Commerce
   Credential 两边的文件都要修改 .aws / JavaResource Example

2. REST
put files in vogella in a package
use jersey 1.18
add jersey-bundle and asm 1.3 jar
put the jars both in build path and WEN-INF/lib
