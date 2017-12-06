package annotation;

public class Field4Test{

	@Annotation1(value1=1,value2=2)
	@Annotation2(value2=2,value3=3)
	private int x;

	@Annotation3
	private int y;
	
	private int z;

}