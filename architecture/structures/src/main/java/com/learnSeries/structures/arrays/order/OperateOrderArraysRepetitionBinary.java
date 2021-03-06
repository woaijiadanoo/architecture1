package com.learnSeries.structures.arrays.order;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示二分法操作有序数组的查询[可重复]
 * 
 * @author jiang-zh
 *
 */
public class OperateOrderArraysRepetitionBinary {

	private int[] arrs;
	private int currentIndex;
//	private int length;

	public OperateOrderArraysRepetitionBinary(int length) {
		arrs = new int[length];
//		this.length = length;
	}

	/**
	 * 将输入插入有序数组中
	 * 
	 * @param data
	 */
	public void insertArrs(int data) {
		int index = 0;
		// 1、循环遍历数组
		for (index = 0; index < currentIndex; index++) {
			if (arrs[index] > data) {
				break;
			}
		}

		for (int i = currentIndex; i > index; i--) {
			arrs[i] = arrs[i - 1];
		}

		arrs[index] = data;

		currentIndex++;
	}

	/**
	 * With this method, You will delete a data in an array
	 * 
	 * @param The
	 *            data what you want to remove in arrays
	 */
	public void removeArr(int data) {

		int dataIndex = getIndexByData(data);

		while(dataIndex>0){
			// 删除任意一条数据，后面的数据都要依次向前挪动一位
			for (int i = dataIndex; i < currentIndex; i++) {
				arrs[i] = arrs[i + 1];
			}
			currentIndex--;
			dataIndex = getIndexByData(data);
		}

	}

	/**
	 * With this method, You will query a data in an array by the data index
	 * 
	 * @param dataIndex
	 * @return The data what you want to get;
	 */
	public int queryByIndex(int dataIndex) {
		int result = -1;

		if (dataIndex > currentIndex - 1) {
			System.out.println("当前位置没有数据");
		} else {
			result = arrs[dataIndex];
		}

		return result;
	}

	/**
	 * Get a data in array what you want to
	 * 
	 * @param data
	 * @return
	 */
	public int queryByData(int data) {

		int minIndex = 0;
		int maxIndex = currentIndex-1;
		int middleIndex =-1;
		
		// 首先比较数组中间位置与传入数据
		// 如果大于则去数组左侧寻找，如果小于，则去右侧寻找
		while(true){
			middleIndex =(maxIndex+minIndex)/2;
			
			if(minIndex>maxIndex){
				return -1;
			}else if(arrs[middleIndex] == data){
				return arrs[middleIndex];
			}else{
				if(arrs[middleIndex]>data){
					maxIndex = middleIndex-1;
				}else if(arrs[middleIndex]<data){
					minIndex = middleIndex+1;
				}
				
			}
			
		}

	}

	/**
	 * Get a data index by a data what you want to
	 * 
	 * @param data
	 * @return the data index
	 */
	private int getIndexByData(int data) {

		for (int i = 0; i < currentIndex; i++) {
			if (arrs[i] == data) {
				return i;
			}
		}

		return -1;
	}
	
	public void printArrays(){
		System.out.println("=======================================>");
		for(int i=0;i<arrs.length;i++){
			System.out.println("This is arr["+i+"] = "+arrs[i]);
		}
	}


	public static void main(String[] args) {
		OperateOrderArraysRepetitionBinary ooap = new OperateOrderArraysRepetitionBinary(8);
		
		ooap.insertArrs(3);
		ooap.insertArrs(5);
		ooap.insertArrs(1);
		ooap.insertArrs(4);
		ooap.insertArrs(7);
		ooap.insertArrs(5);
		
		ooap.printArrays();
		
		ooap.removeArr(5);
		ooap.printArrays();
		
		System.out.println("===============================>");
		System.out.println(ooap.queryByData(3));
		
	}

}
