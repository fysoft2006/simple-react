package com.aol.simple.react.async;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import uk.co.real_logic.agrona.concurrent.ManyToOneConcurrentArrayQueue;


public class QueueFactories {

	public static<T> QueueFactory<T> boundedQueue(int queueSize){
		return () -> new Queue<T>(new LinkedBlockingQueue<>(queueSize));
	}
	public static<T> QueueFactory<T> unboundedQueue(){
		return () -> new Queue<T>();
	}
	public static<T> QueueFactory<T> unboundedNonBlockingQueue(){
		return () -> new Queue<T>(new NonBlockingQueue());
		
	}
	public static<T> QueueFactory<T> boundedNonBlockingQueue(int queueSize){
		return () -> new Queue<T>(new NonBlockingBoundedQueue(queueSize));
		
	}
	
	public static<T> QueueFactory<T> synchronousQueue(){
		return () -> new Queue<T>(new SynchronousQueue<>());
	}
	private static class NonBlockingQueue implements BlockingQueue{
		
		ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

		public  void forEach(Consumer action) {
			queue.forEach(action);
		}

		public int hashCode() {
			return queue.hashCode();
		}

		public Object remove() {
			return queue.remove();
		}

		public boolean equals(Object obj) {
			return queue.equals(obj);
		}

		public Object element() {
			return queue.element();
		}

		public void clear() {
			queue.clear();
		}

		public boolean containsAll(Collection c) {
			return queue.containsAll(c);
		}

		public boolean add(Object e) {
			return queue.add(e);
		}

		public boolean removeAll(Collection c) {
			return queue.removeAll(c);
		}

		public boolean offer(Object e) {
			return queue.offer(e);
		}

		public boolean retainAll(Collection c) {
			return queue.retainAll(c);
		}

		public Object poll() {
			return queue.poll();
		}

		public Object peek() {
			return queue.peek();
		}

		public String toString() {
			return queue.toString();
		}

		public boolean isEmpty() {
			return queue.isEmpty();
		}

		public int size() {
			return queue.size();
		}

		public boolean contains(Object o) {
			return queue.contains(o);
		}

		public boolean remove(Object o) {
			return queue.remove(o);
		}

		public boolean removeIf(Predicate filter) {
			return queue.removeIf(filter);
		}

		public boolean addAll(Collection c) {
			return queue.addAll(c);
		}

		public Object[] toArray() {
			return queue.toArray();
		}

		public Object[] toArray(Object[] a) {
			return queue.toArray(a);
		}

		public Iterator iterator() {
			return queue.iterator();
		}

		public  Stream stream() {
			return queue.stream();
		}

		public  Stream parallelStream() {
			return queue.parallelStream();
		}

		public Spliterator spliterator() {
			return queue.spliterator();
		}

		@Override
		public void put(Object e) throws InterruptedException {
			offer(e);
			
		}

		@Override
		public boolean offer(Object e, long timeout, TimeUnit unit)
				throws InterruptedException {
			return offer(e);
		}

		@Override
		public Object take() throws InterruptedException {
			
			return poll();
		}

		@Override
		public Object poll(long timeout, TimeUnit unit)
				throws InterruptedException {
			
			return poll();
		}

		@Override
		public int remainingCapacity() {
			
			return 0;
		}

		@Override
		public int drainTo(Collection c) {
			
			return 0;
		}

		@Override
		public int drainTo(Collection c, int maxElements) {
			
			return 0;
		}
		
	}
	private static class NonBlockingBoundedQueue implements BlockingQueue{
		private final ManyToOneConcurrentArrayQueue queue;
		public NonBlockingBoundedQueue(int size){
			queue = new ManyToOneConcurrentArrayQueue(size);	
		}
		
		

		public  void forEach(Consumer action) {
			queue.forEach(action);
		}

		public int hashCode() {
			return queue.hashCode();
		}

		public Object remove() {
			return queue.remove();
		}

		public boolean equals(Object obj) {
			return queue.equals(obj);
		}

		public Object element() {
			return queue.element();
		}

		public void clear() {
			queue.clear();
		}

		public boolean containsAll(Collection c) {
			return queue.containsAll(c);
		}

		public boolean add(Object e) {
			return queue.add(e);
		}

		public boolean removeAll(Collection c) {
			return queue.removeAll(c);
		}

		public boolean offer(Object e) {
			return queue.offer(e);
		}

		public boolean retainAll(Collection c) {
			return queue.retainAll(c);
		}

		public Object poll() {
			return queue.poll();
		}

		public Object peek() {
			return queue.peek();
		}

		public String toString() {
			return queue.toString();
		}

		public boolean isEmpty() {
			return queue.isEmpty();
		}

		public int size() {
			return queue.size();
		}

		public boolean contains(Object o) {
			return queue.contains(o);
		}

		public boolean remove(Object o) {
			return queue.remove(o);
		}

		public boolean removeIf(Predicate filter) {
			return queue.removeIf(filter);
		}

		public boolean addAll(Collection c) {
			return queue.addAll(c);
		}

		public Object[] toArray() {
			return queue.toArray();
		}

		public Object[] toArray(Object[] a) {
			return queue.toArray(a);
		}

		public Iterator iterator() {
			return queue.iterator();
		}

		public  Stream stream() {
			return queue.stream();
		}

		public  Stream parallelStream() {
			return queue.parallelStream();
		}

		public Spliterator spliterator() {
			return queue.spliterator();
		}

		@Override
		public void put(Object e) throws InterruptedException {
			offer(e);
			
		}

		@Override
		public boolean offer(Object e, long timeout, TimeUnit unit)
				throws InterruptedException {
			return offer(e);
		}

		@Override
		public Object take() throws InterruptedException {
			// TODO Auto-generated method stub
			return poll();
		}

		@Override
		public Object poll(long timeout, TimeUnit unit)
				throws InterruptedException {
			
			return poll();
		}

		@Override
		public int remainingCapacity() {
			
			return 0;
		}

		@Override
		public int drainTo(Collection c) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int drainTo(Collection c, int maxElements) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
}
