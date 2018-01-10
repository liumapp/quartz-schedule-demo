# quartz-scheduler-demo
quartz scheduler's demo , which coming from the official site.

## Demo1

简单的循环任务，每隔10秒一次输出

*  启动Test下SimpleTest的demo1Test（请将其ignore注释）

*  SimpleJob将每隔10秒钟运行一次。

## Demo2

传递参数到Jobs中

* 启动Test下DataParseTest的parameterTest（请将其ignore注释）

* DataParseJob将每隔10秒运行一次。

* 访问 "http://localhost:40612/parameter/advanced" ，HighLevelParameterJob将每隔40秒运行一次。

* DataParseJob与HighLevelParameterJob的区别在于，前者直接从context中读取参数，后者将参数写入了Jobs自身的属性。

## Demo3

延时五秒后执行任务

* 启动

* 访问"http://localhost:40612/trigger"

* 五秒后控制台可以看到输出。

## Demo4 

延时五秒后启动一个任务，该任务每隔10秒执行一次，直到执行了10次为止。

* 启动

* 访问"http://localhost:40612/trigger/repeat"

* 五秒后控制台可以看到输出。(一共会看到11行输出)

## Demo5 

立即启动一个任务，然后每隔5分钟执行一次，直到当天下午4点为止。

* 启动

* 访问"http://localhost:40612/trigger/endlater"

## Demo6

每个偶数小时整（14:00，16：00）执行一次任务。

* 启动

* 访问"http://localhost:40612/trigger/evenhour"


