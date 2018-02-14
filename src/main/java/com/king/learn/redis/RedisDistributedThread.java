package com.king.learn.redis;

public class RedisDistributedThread extends Thread {
	private RedisDistributedLockService service;
	public RedisDistributedThread(RedisDistributedLockService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
    //http://www.cnblogs.com/liuyang0/p/6744076.html
    public static void main(String[] args) {
    	RedisDistributedLockService service = new RedisDistributedLockService();
        for (int i = 0; i < 10; i++) {
        	RedisDistributedThread threadA = new RedisDistributedThread(service);
            threadA.start();
        }
    }
}
