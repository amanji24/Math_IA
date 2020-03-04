

public class StatPkg {
	
	float variance;
	float stdev;

	
	public StatPkg() {}
	
	public StatPkg(float var, boolean b) {
		this.setVariance(var);
	}
	
	public StatPkg(float st) {
		this.setStdev(st);
	}
	
	
	public void setVariance(float v) {
		variance = v;
		stdev = (float) Math.sqrt(v);
	}
	
	public void setStdev(float s) {
		stdev = s;
		variance = (float) Stats.square(s);
	}
	
}