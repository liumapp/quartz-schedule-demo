# quartz-scheduler-demo
quartz scheduler's demo , which coming from the official site.

所有demo位于junit测试单元下的jobs/SimpleTest.java下

## Demo1

简单的循环任务，每隔10秒一次输出

*  启动Test下SimpleTest的demo1Test（请将其ignore注释）

*  SimpleJob将每隔10秒钟运行一次。

## Demo2

传递参数到Jobs中，直接从context中读取参数。

* 启动Test下DataParseTest的parameterTest（请将其ignore注释）

* DataParseJob将每隔10秒运行一次。

## Demo3

同样传递参数到Jobs中，但将参数写入Jobs的属性。

* 启动Test下DataParseTest的parameterAutoWriteTest（请将其ignore注释）

* HighLevelParameterJob将每隔10秒运行一次。

## Demo4

延时五秒后执行任务

* 启动Test下SimpleTest的demo4Test（请将其ignore注释）

* 五秒后控制台可以看到输出。

## Demo5

延时五秒后启动一个任务，该任务每隔10秒执行一次，直到执行了10次为止。

* 启动Test下SimpleTest的demo5Test（请将其ignore注释）

* 五秒后控制台可以看到输出。(一共会看到11行输出)

## Demo6

立即启动一个任务，然后每隔5分钟执行一次，直到当天下午4点为止。

* 启动Test下SimpleTest的demo6Test（请将其ignore注释）

* 检查结果

## Demo7

每个偶数小时整（14:00，16：00）执行一次任务。

* 启动Test下SimpleTest的demo7Test（请将其ignore注释）

* 检查结果

## Demo8

通过配置，将Spring的Bean对象自动加载到Quartz的JobFactory中。

Demo8检测了Quartz的job在执行的过程中，能否正常使用Spring的Bean对象

* 启动Test下HelloTest的Demo8Test（请将其ignore注释）

* 检查运行结果


## Demo9

将Quartz的执行情况 保存到数据库，防止程序重启，造成任务调度的丢失，
* 启动Test下的SqlTest来创建调度任务，创建完后程序自动关闭，此时就会造成调度任务丢失，
我们在SqlServiceImpl类设置，程序启动就把数据库中未完成的任务查询出来，算出该任务还有多少秒执行
，然后创建调度任务去继续执行该任务。

* 然后启动程序的Main.java 此时 丢失的任务会再次按照之前设置的时间来进行任务的执行

* 检查运行结果

## Demo10

因为项目是使用 springboot2.0编写,所以这里只放项目链接:

springboot-quartz(<a href="https://github.com/HLW-Tec/springboot-quartz">任务调度,持久化任务<a>)

* 启动项目

* 输入 http://localhost:12741/JobManager.html 会看到这个页面,在这里可以看到你的所有任务

![image](https://github.com/haoxiaoyong1014/best-pay-demo/raw/master/src/main/java/com/github/lly835/Images/q1.jpg)

* 添加任务

![image](https://github.com/haoxiaoyong1014/best-pay-demo/raw/master/src/main/java/com/github/lly835/Images/q2.jpeg)

在添加任务的时候 `任务名称`一定要 带上包名,类名，通过反射得到该类, 由于NewJob和HelloJob都实现了BaseJob，

所以这里不需要我们手动去判断。这里涉及到了一些java多态调用的机制

`任务名称`例如: `com.example.quartz.jobs.HelloJob`

当然持久化也是将任务添加到数据库的,sql脚本在项目的跟目录下 <a href="https://github.com/HLW-Tec/springboot-quartz/blob/master/quartz.sql">quartz</a> (官方提供的sql脚本),

在添加任务中的`表达式`你可以到 <a href="http://cron.qqe2.com/">这里自动生成</a> 





