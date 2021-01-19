# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.1/maven-plugin/reference/html/#build-image)


https://redis.io/topics/quickstart

### Install Redis
wget http://download.redis.io/redis-stable.tar.gz
tar xvzf redis-stable.tar.gz
cd redis-stable
make

`It is a good idea to copy both the Redis server and the command line interface into the proper places, either manually using the following commands:

sudo cp src/redis-server /usr/local/bin/
sudo cp src/redis-cli /usr/local/bin/
Or just using sudo make install.

In the following documentation we assume that /usr/local/bin is in your PATH environment variable so that you can execute both the binaries without specifying the full path.`

### Starting Redis
redis-server 

### Check if Redis is working
$ redis-cli ping
PONG
and 
通过telnet命令检测redis端口6379, telnet ip port,

### redis-cli
$ redis-cli
redis 127.0.0.1:6379> ping
PONG
redis 127.0.0.1:6379> set mykey somevalue
OK
redis 127.0.0.1:6379> get mykey
"somevalue"

### Redis persistence
$ redis-cli shutdown
or
ps -u [my_account] -o pid,rss,command | grep redis
kill -9 pid

### Linux下安装redis常见错误server.c:3318:16: error: 'struct redisServer' has no member named 'loading'
解决办法：升级gcc
1. yum -y install centos-release-scl
2. yum -y install devtoolset-9-gcc devtoolset-9-gcc-c++ devtoolset-9-binutils
3. scl enable devtoolset-9 bash

### redis-server - Command Not Found
restarted the terminal. After 
• sudo cp src/redis-server /usr/local/bin/
• sudo cp src/redis-cli /usr/local/bin/
Now can run redis-server

### 如下所示,程序连接redis报错, 根据错误信息, redis运行在受保护模式, 需要redis命令行下作设置: config set protected-mode no

`redis.clients.jedis.exceptions.JedisDataException: DENIED Redis is running in protected mode because
protected mode is enabled, no bind address was specified, no authentication password is requested to
clients. In this mode connections are only accepted from the loopback interface. If you want to 
connect from external computers to Redis you may adopt one of the following solutions: 1) Just disable
protected mode sending the command 'CONFIG SET protected-mode no' from the loopback interface by 
connecting to Redis from the same host the server is running, however MAKE SURE Redis is not publicly 
accessible from internet if you do so. Use CONFIG REWRITE to make this change permanent. 2) Alternatively 
you can just disable the protected mode by editing the Redis configuration file, and setting the protected 
mode option to 'no', and then restarting the server. 3) If you started the server manually just for testing, 
restart it with the '--protected-mode no' option. 4) Setup a bind address or an authentication password.
NOTE: You only need to do one of the above things in order for the server to start accepting connections 
from the outside.`

#### 复现问题, 通过telnet命令检测redis端口6379, telnet ip port, 设置protected-mode no, 再次通过telnet命令检测redis端口6379, 没有出现访问异常
`user: Liker
command: redis-cli
command: config get protected-mode
command: config set protected-mode no
command: config get protected-mode`

