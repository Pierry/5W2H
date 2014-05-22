package model;

public class AtividadeModel {

	private long idAtiv;
	private String what;
	private String why;
	private String where;
	private String when;
	private String who;
	private String how;
	private String howmuch;

	public static String ID = "idativ";
	public static String WHAT = "awhat";
	public static String WHY = "awhy";
	public static String WHERE = "awhere";
	public static String WHEN = "awhen";
	public static String WHO = "awho";
	public static String HOW = "ahow";
	public static String HOWMUCH = "ahowmuch";

	public static String[] colunas = new String[] { ID, WHAT, WHY, WHERE, WHEN, WHO, HOW, HOWMUCH };

	public long getIdAtiv() {
		return idAtiv;
	}

	public void setIdAtiv(long idAtiv) {
		this.idAtiv = idAtiv;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getWhy() {
		return why;
	}

	public void setWhy(String why) {
		this.why = why;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getHow() {
		return how;
	}

	public void setHow(String how) {
		this.how = how;
	}

	public String getHowmuch() {
		return howmuch;
	}

	public void setHowmuch(String howmuch) {
		this.howmuch = howmuch;
	}
	
}
