2.多线程了解吗？
多线程有4种使用方式
继承Thread类、实现Runnable接口、实现Callable接口、使用线程池
终止线程：设置一个控制变量
Interrupt()：中断线程的休眠
Thread.yield()：线程的礼让。让出cpu让其他线程执行，让出时间不确定，不一定让成功
Join()：线程的插队。一旦插入成功先执行完插入的线程所有任务
用户线程：也叫工作线程，当线程任务执行完或者通知方式结束
守护线程：一般为用户线程服务的，所有用户线程结束，守护线程自动结束
常见的守护线程：垃圾回收机制

使用线程池：
【不允许】java提供了Executors构建线程池的方式，规范中不允许使用，这种方式对线程池的控制粒度比较低。
【推荐】手动创建线程池
ThreadPoolExecutor executor = new ThreadPoolExecutor (七个参数)
（1）corePoolSize：线程池中的常驻核⼼线程数。
（2）maximumPoolSize：线程池能够容纳同时执⾏的最⼤线程数，此值⼤于等于1。
（3）keepAliveTime：多余的空闲线程存活时间，当空间时间达到keepAliveTime值时，多余的线程会被销毁直到只剩下corePoolSize个线程为⽌。
（4）unit：keepAliveTime的单位。
（5）workQueue：任务队列，被提交但尚未被执⾏的任务。
（6）threadFactory：表⽰⽣成线程池中⼯作线程的线程⼯⼚，⽤户创建新线程，⼀般⽤默认即可。
（7）handler：拒绝策略，表⽰当线程队列满了并且⼯作线程⼤于等于线程池的最⼤显⽰数(maxnumPoolSize)时如何来拒绝请求执⾏的runnable的策略。

线程池的执行流程：
提交任务，【核心线程数】有空闲，创建一个新线程执行，无空闲，查看【阻塞队列】
【阻塞队列】没有满，添加到队列中等待执行，阻塞队列满了，查看【最大线程数】
【最大线程数】没有满，创建一个新线程执行，最大线程数满了，执行【拒绝策略】

4种默认的拒绝策略
AbortPolicy：为线程池默认的拒绝策略，该策略直接抛异常处理。
DiscardPolicy：直接抛弃不处理。
DiscardOldestPolicy：丢弃队列中最⽼的任务。
CallerRunsPolicy：将任务分配给当前执⾏execute⽅法线程来处理。