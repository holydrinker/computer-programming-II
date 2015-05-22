
public class HashDivisione implements Hash {

	@Override
	public int h(int n, Comparable key) {
		return Math.abs(key.hashCode()) % n;
	}

}
