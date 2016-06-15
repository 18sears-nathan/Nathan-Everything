import java.util.ArrayList;

public class APQueue<E> implements APQueue<E>
{
	private ArrayList<E> queue;
	
	public APQueue()
	{
		queue = new ArrayList<E>();
	}
	public E deQueue()
	{
		E obj = queue.remove(0)
		return obj;
	}
	
	public void enqueue()
	{
		queue.add(obj);
	}
	
	public boolean isEmpty()
	{
		if (queue.size()==0)
			return true;
		else
			return false;
	}
	
	public E peekFront()
	{
		E obj = queue.get(0);
		return obj;
	}
}
