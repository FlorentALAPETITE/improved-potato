import javafx.scene.paint.Color;


class Case {

	private int colonne_;
	private int ligne_;

	private Color couleur_;

	private ClasseUnion unionFind_;

	private boolean caseObjectif_;

	public Case(int colonne, int lig, Color col){
		colonne_=colonne;
		ligne_=lig;
		couleur_=col;
		caseObjectif_ = false;
		if(col==Color.WHITE)
			unionFind_=null;
		else
			unionFind_ = new ClasseUnion(this);

	}

	public ClasseUnion getClasseUnion(){
		return unionFind_;
	}


	public int getColonne(){
		return colonne_;
	}

	public int getLigne(){
		return ligne_;
	}


	public boolean testCaseObjectif(){
		return caseObjectif_;
	}


	public void setCaseObjectif(Color col){
		caseObjectif_=true;
		couleur_=col;
		unionFind_ = new ClasseUnion(this);
	}

	public Color getCouleur(){
		return couleur_;
	}

	public void setCouleur(Color c){
		couleur_=c;
	}


	@Override
	public String toString(){
		if(couleur_ == Color.BLUE)
			return "+";
		else if (couleur_ == Color.RED)
			return "-";
		else 
			return "#";
	}


}