package com.ustc.zwxu.lc.reply.web.controller.api;

public class QueueArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueDemo demo=new QueueDemo(5);
		//demo.push(1);
		demo.push(3);
		demo.push(5);
		demo.push(7);
		demo.push(9);
		demo.push(11);
		System.out.println(demo.pop());

	}

}

class QueueDemo
{
	private int front;
	private int rear;
	private int max;
	private int[] queueArray;
	
	public QueueDemo(int s)
	{
		front=0;
		rear=0;
		max=s;
		queueArray=new int[max];	
	}
	
	public void push(int i)
	{
		if(isFull())
		{
			throw new RuntimeException("队满");
		}
		queueArray[rear++]=i;
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("队空");
		}
		int temp=queueArray[front++];
		
		return temp;
	}
	
	public boolean isEmpty()
	{
		return (rear==front);
	}
	
	public boolean isFull()
	{
		return (rear+1)%max == front;
	}
}
