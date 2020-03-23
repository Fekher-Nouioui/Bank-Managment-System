package tri;

import java.util.Vector;

public class Trieuse {
	public static Vector triInsertion(Vector v)
	{
		Vector res = new Vector();;
		for(int i = 0; i < v.size(); i++)
		{
			Comparable elti = (Comparable) v.elementAt(i);
			int p = 0;
			while((p < res.size()) && (elti.compareTo(res.elementAt(p)) < 0))
				p++;
			res.insertElementAt(elti, p);
		}
		return res;
	}
}
