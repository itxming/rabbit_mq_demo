# rabbit_mq_demo
安装及配置
接下来我们介绍下RabbitMQ的安装和配置，提供Windows和Linux两种安装方式。

###Windows下的安装
安装Erlang，下载地址：http://erlang.org/download/otp_win64_21.3.exe

安装RabbitMQ，下载地址：https://dl.bintray.com/rabbitmq/all/rabbitmq-server/3.7.14/rabbitmq-server-3.7.14.exe

安装完成后，进入RabbitMQ安装目录下的sbin目录；
在地址栏输入cmd并回车启动命令行，然后输入以下命令启动管理功能。

`rabbitmq-plugins enable rabbitmq_management`


###Linux下的安装
下载rabbitmq 3.7.15的Docker镜像；

`docker pull rabbitmq:3.7.15`

使用Docker命令启动服务；

`docker run -p 5672:5672 -p 15672:15672 --name rabbitmq \ -d rabbitmq:3.7.15`

进入容器并开启管理功能；

`docker exec -it rabbitmq /bin/bash `
`rabbitmq-plugins enable rabbitmq_management`

开启防火墙便于外网访问。

`firewall-cmd --zone=public --add-port=15672/tcp --permanent`
`firewall-cmd --zone=public --add-port=5672/tcp --permanent`
`firewall-cmd --reload`

访问及配置
访问RabbitMQ管理页面地址，查看是否安装成功（Linux下使用服务器IP访问即可）：
http://localhost:15672/

输入账号密码并登录，这里使用默认账号密码登录：guest guest
