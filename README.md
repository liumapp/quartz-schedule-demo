# quartz-scheduler-demo
quartz scheduler's demo , which coming from the official site.

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
