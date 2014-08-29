package it.unibz.teststore.entity;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
	

public class TestInstanceSPResult  implements Comparable<TestInstanceSPResult> {
	
	public TestInstanceSPResult(){
	
	}
	
	public TestInstanceSPResult(Long testId,Double selectionProbability,Double averageTime,Double entropy,Double wtime,Boolean status){
		this.testId = testId;
		this.selectionProbability = selectionProbability;
		this.averageTime = averageTime;
		this.status= status;
		this.entropy = entropy;
		this.wtime= wtime;
		
	}
		
	private Long testId;
	private Double selectionProbability;
	private Double averageTime;
	private Boolean status;
	private Double entropy;
    private Double  wtime;
	
	public void setTestId(Long testId){
		this.testId= testId;
	}
	
	public Long getTestId(){
		return testId;
	}
	
	public void setSelectionProbability(Double selectionProbability){
		this.selectionProbability= selectionProbability;
	}
	
	public Double getSelectionProbability(){
		return selectionProbability;
	}
	
	public void setEntropy(Double entropy){
		this.entropy= entropy;
	}
	
	public Double getEntropy(){
		return entropy;
	}
	
	public void setWeightedTime(Double wtime){
		this.wtime= wtime;
	}
	
	public Double getWeightedTime(){
		return wtime;
	}
	
		
	public void setAverageTime(Double averageTime){
		this.averageTime= averageTime;
	}
	
	public Double getAverageTime(){
		return averageTime;
	}
	
	public void setExecutionStatus(Boolean status){
		this.status= status;
	}
	
	public Boolean getExecutionStatus(){
		return status;
	}
	
	public static class OrderByEntropy implements Comparator<TestInstanceSPResult> {

	    @Override
	    public int compare(TestInstanceSPResult d1, TestInstanceSPResult d2) {
	    		return d2.entropy.compareTo(d1.entropy);
	    }

		@Override
		public Comparator<TestInstanceSPResult> reversed() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparing(
				Comparator<? super TestInstanceSPResult> other) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U> Comparator<TestInstanceSPResult> thenComparing(
				Function<? super TestInstanceSPResult, ? extends U> keyExtractor,
				Comparator<? super U> keyComparator) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U extends Comparable<? super U>> Comparator<TestInstanceSPResult> thenComparing(
				Function<? super TestInstanceSPResult, ? extends U> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingInt(
				ToIntFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingLong(
				ToLongFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingDouble(
				ToDoubleFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}



		public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
			// TODO Auto-generated method stub
			return null;
		}



		public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
			// TODO Auto-generated method stub
			return null;
		}



		public static <T> Comparator<T> nullsFirst(
				Comparator<? super T> comparator) {
			// TODO Auto-generated method stub
			return null;
		}


		public static <T> Comparator<T> nullsLast(
				Comparator<? super T> comparator) {
			// TODO Auto-generated method stub
			return null;
		}

		
		public static <T, U> Comparator<T> comparing(
				Function<? super T, ? extends U> keyExtractor,
				Comparator<? super U> keyComparator) {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
				Function<? super T, ? extends U> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

	    
		public static <T> Comparator<T> comparingInt(
				ToIntFunction<? super T> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		
		public static <T> Comparator<T> comparingLong(
				ToLongFunction<? super T> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}



		public static <T> Comparator<T> comparingDouble(
				ToDoubleFunction<? super T> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}
    }
	
	
	public static class OrderByEntropyDesc implements Comparator<TestInstanceSPResult> {

	    @Override
	    public int compare(TestInstanceSPResult d1, TestInstanceSPResult d2) {
	    		return d1.entropy.compareTo(d2.entropy);
	    }

		@Override
		public Comparator<TestInstanceSPResult> reversed() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparing(
				Comparator<? super TestInstanceSPResult> other) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U> Comparator<TestInstanceSPResult> thenComparing(
				Function<? super TestInstanceSPResult, ? extends U> keyExtractor,
				Comparator<? super U> keyComparator) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U extends Comparable<? super U>> Comparator<TestInstanceSPResult> thenComparing(
				Function<? super TestInstanceSPResult, ? extends U> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingInt(
				ToIntFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingLong(
				ToLongFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingDouble(
				ToDoubleFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}






    }
	
	public static class OrderBySP implements Comparator<TestInstanceSPResult> {

	    @Override
	    public int compare(TestInstanceSPResult d1, TestInstanceSPResult d2) {
	    	   	
	    /*	int c=0;
	    	if(d1.selectionProbability>0.0)
	    		c = d2.selectionProbability.compareTo(d1.selectionProbability);
	    	if(c==0)
	    		c = d1.averageTime.compareTo(d2.averageTime);
	    	return c;*/
	    	//if(d2.averageTime>d1.averageTime)
	    	return d2.selectionProbability.compareTo(d1.selectionProbability);
	    }

		@Override
		public Comparator<TestInstanceSPResult> reversed() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparing(
				Comparator<? super TestInstanceSPResult> other) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U> Comparator<TestInstanceSPResult> thenComparing(
				Function<? super TestInstanceSPResult, ? extends U> keyExtractor,
				Comparator<? super U> keyComparator) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <U extends Comparable<? super U>> Comparator<TestInstanceSPResult> thenComparing(
				Function<? super TestInstanceSPResult, ? extends U> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingInt(
				ToIntFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingLong(
				ToLongFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Comparator<TestInstanceSPResult> thenComparingDouble(
				ToDoubleFunction<? super TestInstanceSPResult> keyExtractor) {
			// TODO Auto-generated method stub
			return null;
		}
  }
	

	@Override 
	public int compareTo(TestInstanceSPResult arg0) {
		return 0;
	}
		

}
